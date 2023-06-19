package com.zerobase.hseungho.api.loan.review

import com.zerobase.hseungho.api.exception.CustomException
import com.zerobase.hseungho.api.exception.ErrorCode
import com.zerobase.hseungho.domain.domain.LoanReview
import com.zerobase.hseungho.domain.repository.LoanReviewRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {

    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        return LoanReviewDto.LoanReviewResponseDto(
                userKey = userKey,
                lonaResult = getLoanResult(userKey)?.toResponseDto()
                        ?: throw CustomException(ErrorCode.RESULT_NOT_FOUND)
        )
    }

    @Cacheable(value = ["REVIEW"], key = "#userKey", cacheManager = "redisCacheManager")
    override fun getLoanResult(userKey: String): LoanReview? = loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
            LoanReviewDto.LoanResult(
                    userLimitAmount = this.loanLimitedAmount,
                    userLoanInterest = this.loanInterest
            )

}