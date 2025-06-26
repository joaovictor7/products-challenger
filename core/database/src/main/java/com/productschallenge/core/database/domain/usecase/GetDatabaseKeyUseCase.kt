package com.productschallenge.core.database.domain.usecase

import com.productschallenge.core.database.data.repository.DatabaseRepository
import com.productschallenge.core.domain.provider.BuildConfigProvider
import com.productschallenge.core.security.provider.CipherProvider
import com.productschallenge.core.security.util.addPBKDF2
import com.productschallenge.core.security.util.generateSecureKey
import javax.inject.Inject

internal class GetDatabaseKeyUseCase @Inject constructor(
    private val cipherProvider: CipherProvider,
    private val buildConfigProvider: BuildConfigProvider,
    private val databaseRepository: DatabaseRepository,
) {

    suspend operator fun invoke() = if (buildConfigProvider.buildConfig.isRelease) {
        getOrCreateDatabaseKey().toByteArray()
    } else null

    private suspend fun getOrCreateDatabaseKey(): String {
        val encryptedDatabaseKey = databaseRepository.getSqliteSecretKey()
        return if (encryptedDatabaseKey == null) {
            val secureKey = generateSecureKey(SECURE_KEY_LENGTH)
            addPBKDF2(secureKey).also {
                databaseRepository.setSqliteSecretKey(cipherProvider.encrypt(it))
            }
        } else {
            cipherProvider.decrypt(encryptedDatabaseKey)
        }
    }

    private companion object {
        const val SECURE_KEY_LENGTH = 1000
    }
}