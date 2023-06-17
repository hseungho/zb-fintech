package com.zerobase.hseungho.consumer.service

import com.zerobase.hseungho.domain.domain.LoanReview

interface LoanRequestService {

    fun loanRequest()

    fun loanRequestToCB()

    fun saveLoanReviewData(loanReview: LoanReview): LoanReview

}