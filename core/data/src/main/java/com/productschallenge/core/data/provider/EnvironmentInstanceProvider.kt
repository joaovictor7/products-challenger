package com.productschallenge.core.data.provider

interface EnvironmentInstanceProvider {
    fun <Instance> getInstance(instance: Instance, fakeInstance: Instance): Instance
}