package com.zerobase.hseungho.api.loan.review

import com.zerobase.hseungho.domain.domain.LoanReview

class LoanReviewDto {
    data class LoanReviewResponseDto(
            val userKey: String,
            val lonaResult: LoanResult
    )

    data class LoanResult(
            val userLimitAmount: Long,
            val userLoanInterest: Double
    )

    data class LoanReview(
            val userKey: String,
            val userLimitAmount: Long,
            val userLoanInterest: Double
    )
}