package com.productschallenge.common.provider

import java.time.LocalDate
import java.time.LocalDateTime

interface DateTimeProvider {
    val currentDateTime: LocalDateTime
    val currentDate: LocalDate
}