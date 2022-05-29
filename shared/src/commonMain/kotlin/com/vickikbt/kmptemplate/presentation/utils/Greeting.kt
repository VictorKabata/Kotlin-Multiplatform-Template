package com.vickikbt.kmptemplate.presentation.utils

import com.vickikbt.kmptemplate.domain.utils.Platform

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
