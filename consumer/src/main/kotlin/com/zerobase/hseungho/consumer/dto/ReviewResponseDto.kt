package com.zerobase.hseungho.consumer.dto

import com.zerobase.hseungho.domain.domain.LoanReview

data class ReviewResponseDto(
        val userKey: String,
        val interest: Double,
        val limitAmount: Long
) {
    fun toLoanReviewEntity() : LoanReview =
            LoanReview(
                    userKey = this.userKey,
                    loanInterest = this.interest,
                    loanLimitedAmount = this.limitAmount
            )
}
