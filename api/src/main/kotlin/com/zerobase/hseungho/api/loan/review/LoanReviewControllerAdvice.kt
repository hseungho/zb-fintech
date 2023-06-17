package com.zerobase.hseungho.api.loan.review

import com.zerobase.hseungho.api.exception.CustomException
import com.zerobase.hseungho.api.exception.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [ LoanReviewController::class ])
class LoanReviewControllerAdvice {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(customException: CustomException) : ResponseEntity<ErrorResponse.ErrorResponseDto> =
            ErrorResponse(customException).toResponseEntity()
    
}