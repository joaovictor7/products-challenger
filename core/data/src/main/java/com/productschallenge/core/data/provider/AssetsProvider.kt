package com.productschallenge.core.data.provider

interface AssetsProvider {

    fun loadJson(jsonFile: String): String
}