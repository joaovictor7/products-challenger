package com.productschallenge.common.extension

import androidx.core.util.PatternsCompat

val String.digits get() = filter { it.isDigit() }

val String?.toIntOrZero get() = this?.toIntOrNull() ?: 0

val String.isEmailAddress get() = PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()