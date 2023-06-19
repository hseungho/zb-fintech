package com.zerobase.hseungho.css.service

import com.zerobase.hseungho.css.dto.LoanRequestDto
import com.zerobase.hseungho.css.dto.LoanResultDto

interface LoanReviewService {
    fun loanReview(loanRequestDto: LoanRequestDto.RequestInputDto) : LoanResultDto.ResponseDto
}