package com.github.jesuserro.helloworldkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform