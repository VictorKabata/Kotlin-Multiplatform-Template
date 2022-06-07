package com.vickikbt.kmptemplate.di

import com.vickikbt.kmptemplate.presentation.utils.Greeting
import com.vickikbt.kmptemplate.presentation.viewmodels.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun commonModule(isDebug: Boolean) = module {
    singleOf(::Greeting)

    singleOf(::MainViewModel)
}
