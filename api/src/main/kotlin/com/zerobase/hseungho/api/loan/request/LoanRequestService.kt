package com.zerobase.hseungho.api.loan.request

import com.zerobase.hseungho.domain.domain.UserInfo

interface LoanRequestService {

    fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ) : LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(userInfoDto: UserInfoDto) : UserInfo

    fun loanRequestReview(userKey: String)

}