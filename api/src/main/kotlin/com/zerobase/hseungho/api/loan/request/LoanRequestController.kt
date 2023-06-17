package com.zerobase.hseungho.api.loan.request

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanRequestController(
        private val loanRequestService: LoanRequestService
) {

    @PostMapping("/request")
    fun loanRequest(
            @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ) : ResponseEntity<LoanRequestDto.LoanRequestResponseDto> =
            ResponseEntity.ok(loanRequestService.loanRequestMain(loanRequestInputDto))

}