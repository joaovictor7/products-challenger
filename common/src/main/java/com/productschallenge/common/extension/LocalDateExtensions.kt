package com.productschallenge.common.extension

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

val Long.convertedFromUnix2: LocalDate
    get() = Instant.ofEpochMilli(this)
        .atZone(ZoneOffset.UTC)
        .toLocalDate()

fun LocalDate.convertToString(format: String): String {
    val formatter = DateTimeFormatter.ofPattern(format)
    return format(formatter)
}