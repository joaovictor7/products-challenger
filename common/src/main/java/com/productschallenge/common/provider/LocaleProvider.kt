package com.productschallenge.common.provider

import java.util.Locale

interface LocaleProvider {
    val default: Locale
    val currentLanguage: String
}