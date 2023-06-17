package com.zerobase.hseungho.consumer.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.zerobase.hseungho.kafka.dto.LoanRequestDto
import com.zerobase.hseungho.kafka.enum.KafkaTopic
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
        private val objectMapper: ObjectMapper
        // TODO: CB 사 호출 로직
) {

    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)


    }

}