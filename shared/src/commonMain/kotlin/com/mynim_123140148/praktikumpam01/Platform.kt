package com.mynim_123140148.praktikumpam01

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform