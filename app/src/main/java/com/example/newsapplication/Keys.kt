package com.example.newsapplication

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}