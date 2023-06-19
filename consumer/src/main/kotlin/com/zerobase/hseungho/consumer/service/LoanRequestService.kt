package com.zerobase.hseungho.consumer.service

import com.zerobase.hseungho.consumer.dto.ReviewResponseDto
import com.zerobase.hseungho.domain.domain.LoanReview
import com.zerobase.hseungho.kafka.dto.LoanRequestDto

interface LoanRequestService {

    fun loanRequest(loanRequestDto: LoanRequestDto)

    fun loanRequestToCB(loanRequestDto: LoanRequestDto) : ReviewResponseDto

    fun saveLoanReviewData(loanReview: LoanReview): LoanReview

}