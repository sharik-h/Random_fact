package com.example.randomfact.data

interface randomRepo {
    suspend fun getRandomFact() : Fact
}