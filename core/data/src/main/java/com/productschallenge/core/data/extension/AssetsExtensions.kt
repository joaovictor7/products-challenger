package com.productschallenge.core.data.extension

import com.productschallenge.core.data.provider.AssetsProvider
import com.productschallenge.core.data.util.decodeJson

inline fun <reified T> AssetsProvider.readJsonAs(jsonFile: String): T {
    val json = loadJson(jsonFile)
    return decodeJson<T>(json)
}