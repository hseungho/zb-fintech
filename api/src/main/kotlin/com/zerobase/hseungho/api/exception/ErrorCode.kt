package com.zerobase.hseungho.api.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val statusCode: HttpStatus,
        val errorCode: String,
        val errorMessage: String
) {
    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "E-001", errorMessage = "result not found")
}