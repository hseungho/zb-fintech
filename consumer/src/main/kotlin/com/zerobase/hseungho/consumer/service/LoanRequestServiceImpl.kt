package com.zerobase.hseungho.consumer.service

import com.zerobase.hseungho.domain.domain.LoanReview
import com.zerobase.hseungho.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
) : LoanRequestService {

    override fun loanRequest() {
        // TODO : CB Component 로 요청 보내기 -> 응답값을 DB에 저장
    }

    override fun loanRequestToCB() {
        // TODO
    }

    override fun saveLoanReviewData(loanReview: LoanReview) : LoanReview =
            loanReviewRepository.save(loanReview)
    
}