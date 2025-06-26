package com.productschallenge.core.data.provider

import com.productschallenge.common.provider.DateTimeProvider
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

internal class DateTimeProviderImpl @Inject constructor() : DateTimeProvider {
    override val currentDateTime: LocalDateTime get() = LocalDateTime.now()
    override val currentDate: LocalDate get() = currentDateTime.toLocalDate()
}