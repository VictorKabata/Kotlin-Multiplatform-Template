package com.vickikbt.kmptemplate

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}