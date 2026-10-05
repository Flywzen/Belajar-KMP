package com.mynim_123140148.latihan2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform