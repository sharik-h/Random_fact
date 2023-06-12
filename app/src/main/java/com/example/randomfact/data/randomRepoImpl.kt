package com.example.randomfact.data

import javax.inject.Inject

class randomRepoImpl @Inject constructor(
    private val api: randomApi
): randomRepo {

    override suspend fun getRandomFact(): Fact {
        return api.getRandomFact()
    }

}