package com.productschallenge.core.database.application

import com.productschallenge.common.provider.ApplicationModule

object DatabaseApplication : ApplicationModule {

    override fun onCreate() {
        System.loadLibrary("sqlcipher")
    }
}