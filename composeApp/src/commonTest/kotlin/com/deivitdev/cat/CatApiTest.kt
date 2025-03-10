package com.deivitdev.cat

import com.deivitdev.cat.model.CatApi
import com.deivitdev.cat.model.CatImage
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class CatApiTest {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    private val catApi = CatApi(client)

    @Test
    fun `get random cat image`() = runBlocking {
        val images: List<CatImage> = catApi.getRandomCatImage()
        assertTrue(images.isNotEmpty())
    }
}