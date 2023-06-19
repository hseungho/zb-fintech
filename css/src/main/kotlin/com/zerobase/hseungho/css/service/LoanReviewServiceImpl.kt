package com.zerobase.hseungho.css.service

import com.zerobase.hseungho.css.dto.LoanRequestDto
import com.zerobase.hseungho.css.dto.LoanResultDto
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl : LoanReviewService {
    override fun loanReview(loanRequestDto: LoanRequestDto.RequestInputDto): LoanResultDto.ResponseDto {
        if (loanRequestDto.userIncomeAmount < 0) throw RuntimeException("Invalid userIncomeAmount Param")
        if (loanRequestDto.userIncomeAmount < 10_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 0.0, 10_000_000)
        if (loanRequestDto.userIncomeAmount < 20_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 10.0, 20_000_000)
        if (loanRequestDto.userIncomeAmount < 30_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 9.0, 30_000_000)
        if (loanRequestDto.userIncomeAmount < 40_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 8.0, 40_000_000)
        if (loanRequestDto.userIncomeAmount < 50_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 7.0, 50_000_000)
        if (loanRequestDto.userIncomeAmount >= 50_000_000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 6.0, 60_000_000)
        throw RuntimeException("Invalid userIncomeAmount Param")
    }
}