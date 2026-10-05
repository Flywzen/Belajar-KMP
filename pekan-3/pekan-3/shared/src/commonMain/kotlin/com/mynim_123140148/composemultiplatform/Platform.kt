package com.mynim_123140148.composemultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform