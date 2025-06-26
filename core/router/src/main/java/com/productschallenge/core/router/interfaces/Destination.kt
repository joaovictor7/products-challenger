package com.productschallenge.core.router.interfaces

interface Destination {
    val asRoute get() = this::class.qualifiedName
}