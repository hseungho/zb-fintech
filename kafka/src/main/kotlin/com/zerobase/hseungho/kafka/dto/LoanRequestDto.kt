package com.zerobase.hseungho.kafka.dto

data class LoanRequestDto(
        val userKey: String,
        val userName: String,
        val userIncomeAmount: Long,
        val userRegistrationNumber: String
)