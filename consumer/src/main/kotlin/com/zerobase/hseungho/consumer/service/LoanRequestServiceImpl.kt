package com.zerobase.hseungho.consumer.service

import com.zerobase.hseungho.consumer.dto.ReviewResponseDto
import com.zerobase.hseungho.domain.domain.LoanReview
import com.zerobase.hseungho.domain.repository.LoanReviewRepository
import com.zerobase.hseungho.kafka.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
) : LoanRequestService {

    companion object {
        const val cssUrl = "http://localhost:8081/css/api/v1/request"
    }

    override fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCB(loanRequestDto).toLoanReviewEntity()

        saveLoanReviewData(reviewResult)
    }

    override fun loanRequestToCB(loanRequestDto: LoanRequestDto) : ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()

        return restTemplate.postForEntity(cssUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    override fun saveLoanReviewData(loanReview: LoanReview) : LoanReview =
            loanReviewRepository.save(loanReview)

}