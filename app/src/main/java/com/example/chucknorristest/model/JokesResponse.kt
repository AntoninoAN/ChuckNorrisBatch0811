package com.example.chucknorristest.model

data class JokesResponse(
    val type: String,
    val value: JokeItem
)

data class JokeItem(
    val id: Int,
    val joke: String,
    val categories: List<String>
)

data class JokeListResponse(
    val type: String,
    val value: List<JokeItem>
)
