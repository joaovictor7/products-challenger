package com.productschallenge.core.data.workmanager

import com.productschallenge.core.data.repository.WorkManagerRepository
import javax.inject.Inject

internal class WorkManagerImpl @Inject constructor(
    private val workManagerRepository: WorkManagerRepository
) : WorkManager {
    override fun enqueuePeriodicWork(workManagerRequest: WorkManagerRequest.PeriodicWorkManagerRequest) {
        workManagerRepository.enqueuePeriodicWork(workManagerRequest)
    }

    override fun enqueueOneTimeWork(workManagerRequest: WorkManagerRequest.OneTimeWorkManagerRequest) {
        workManagerRepository.enqueueOneTimeWork(workManagerRequest)
    }
}