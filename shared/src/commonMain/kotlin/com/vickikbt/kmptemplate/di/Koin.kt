package com.vickikbt.kmptemplate.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(isDebug: Boolean = false, appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(commonModule(isDebug = isDebug))
    }
}

fun initKoin() = initKoin {}
