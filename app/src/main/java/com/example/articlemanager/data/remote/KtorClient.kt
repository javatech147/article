package com.example.articlemanager.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object KtorClient {
    val client =
        HttpClient(Android) {  // engine = Android , add dependency implementation("io.ktor:ktor-client-android:3.4.1")
            install(ContentNegotiation) {
                json()
            }
        }
}
