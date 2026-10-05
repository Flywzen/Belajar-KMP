package com.mynim_123140148.statemanagementmvvm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform