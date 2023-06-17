package com.zerobase.hseungho.domain.repository

import com.zerobase.hseungho.domain.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoanReviewRepository: JpaRepository<LoanReview, Long> {

    fun findByUserKey(userKey: String) : LoanReview

}