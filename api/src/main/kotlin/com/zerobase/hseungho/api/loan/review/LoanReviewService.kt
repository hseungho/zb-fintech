package com.zerobase.hseungho.api.loan.review

import com.zerobase.hseungho.domain.domain.LoanReview

interface LoanReviewService {

    fun loanReviewMain(userKey: String) : LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String) : LoanReview?

}