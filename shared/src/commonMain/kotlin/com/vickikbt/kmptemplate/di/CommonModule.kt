package com.vickikbt.kmptemplate.di

import com.vickikbt.kmptemplate.presentation.utils.Greeting
import org.koin.dsl.module

fun commonModule(isDebug: Boolean) = module {
    single { Greeting() }
}
