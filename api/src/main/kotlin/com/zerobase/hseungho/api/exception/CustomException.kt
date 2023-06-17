package com.zerobase.hseungho.api.exception

class CustomException(val errorCode: ErrorCode) : RuntimeException() {
}