package com.zerobase.hseungho.consumer.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.zerobase.hseungho.consumer.service.LoanRequestService
import com.zerobase.hseungho.kafka.dto.LoanRequestDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class LoanRequestConsumer(
        private val objectMapper: ObjectMapper,
        private val loanRequestService: LoanRequestService
) {

    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)

        loanRequestService.loanRequest(loanRequestKafkaDto)
    }

}