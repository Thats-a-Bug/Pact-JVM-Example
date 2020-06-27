package com.thatsabug.provider

data class Information (
        val name: String,
        val credentials: String,
        val skills: String,
        val yearsOfExperience: String?,
        val contact: Map<String, String>?,
        val age: String,
        val relatives: String
)
