package com.productschallenge.core.router.di.quailifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NavGraphQualifier(val navGraph: String)