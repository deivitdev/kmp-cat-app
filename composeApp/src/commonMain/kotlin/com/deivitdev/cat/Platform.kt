package com.deivitdev.cat

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform