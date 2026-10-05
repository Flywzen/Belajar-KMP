package com.mynim_123140148.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform