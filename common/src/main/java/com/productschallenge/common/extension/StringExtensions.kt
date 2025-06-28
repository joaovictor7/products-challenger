package com.productschallenge.common.extension

import android.util.Patterns

val String.digits get() = filter { it.isDigit() }

val String?.toIntOrZero get() = this?.toIntOrNull() ?: 0

val String.isEmailAddress get() = Patterns.EMAIL_ADDRESS.matcher(this).matches()