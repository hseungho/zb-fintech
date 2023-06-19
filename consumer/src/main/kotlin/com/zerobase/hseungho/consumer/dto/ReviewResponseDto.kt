package com.zerobase.hseungho.consumer.dto

data class ReviewResponseDto(
        val userKey: String,
        val interest: Double,
        val limitAmount: Long
)
