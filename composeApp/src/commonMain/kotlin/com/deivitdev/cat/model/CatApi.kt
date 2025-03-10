package com.deivitdev.cat.model

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CatApi (private val client: HttpClient){
    suspend fun getRandomCatImage(): List<CatImage>{
        return client.get("https://api.thecatapi.com/v1/images/search").body()
    }

    suspend fun getRandomCatFact(): CatFact {
        return client.get("https://catfact.ninja/fact").body()
    }

    suspend fun get10RandomCatImages(): List<CatImage>{
        return client.get("https://api.thecatapi.com/v1/images/search?limit=10").body()
    }
}