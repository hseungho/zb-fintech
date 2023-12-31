package com.zerobase.hseungho.api.loan.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zerobase.hseungho.api.loan.util.GenerateKey
import com.zerobase.hseungho.api.loan.encrypt.EncryptComponent
import com.zerobase.hseungho.domain.domain.UserInfo
import com.zerobase.hseungho.domain.repository.UserInfoRepository
import com.zerobase.hseungho.kafka.producer.LoanRequestSender
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(LoanRequestController::class)
internal class LoanRequestControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var loanRequestController: LoanRequestController

    private lateinit var generateKey: GenerateKey

    private lateinit var encryptComponent: EncryptComponent

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    private lateinit var loanRequestSender: LoanRequestSender

    private lateinit var mapper: ObjectMapper

    private val userInfoRepository: UserInfoRepository = mockk()

    @MockBean
    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl

    companion object {
        private const val BASE_URL = "/fintech/api/v1"
    }

    @BeforeEach
    fun init() {
        generateKey = GenerateKey()
        encryptComponent = EncryptComponent()
        loanRequestSender = LoanRequestSender(kafkaTemplate, mapper)
        loanRequestServiceImpl = LoanRequestServiceImpl(generateKey, encryptComponent, userInfoRepository, loanRequestSender)
        loanRequestController = LoanRequestController(loanRequestServiceImpl)

        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()

        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

    @Test
    @DisplayName("유저 정상 요청이 들어오면 정상 응답을 주어야 한다.")
    fun testNormalCase() {
        //given
        val loanRequestInputDto: LoanRequestDto.LoanRequestInputDto =
                LoanRequestDto.LoanRequestInputDto(
                        userName = "TEST",
                        userIncomeAmount = 10000,
                        userRegistrationNumber = "000101-1234567"
                )

        every { userInfoRepository.save(any()) } returns UserInfo("", "", "", 1)

        //when
        //then
        mockMvc.post("$BASE_URL/request") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loanRequestInputDto)
        }.andExpect {
            status { isOk() }
        }
    }

}