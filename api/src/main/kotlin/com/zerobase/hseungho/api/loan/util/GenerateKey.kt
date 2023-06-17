package com.zerobase.hseungho.api.loan.util

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateKey {

    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "")

}