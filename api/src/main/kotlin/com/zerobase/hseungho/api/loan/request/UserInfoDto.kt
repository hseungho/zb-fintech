package com.zerobase.hseungho.api.loan.request

import com.zerobase.hseungho.domain.domain.UserInfo
import com.zerobase.hseungho.kafka.dto.LoanRequestDto

data class UserInfoDto(
        val userKey: String,
        val userName: String,
        val userRegistrationNumber: String,
        val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
            UserInfo(userKey, userRegistrationNumber, userName, userIncomeAmount)

    fun toLoanRequestKafkaDto() = LoanRequestDto(
            userKey, userName, userIncomeAmount, userRegistrationNumber
    )

}