package com.zerobase.hseungho.api.loan.request

import com.zerobase.hseungho.api.loan.encrypt.EncryptComponent
import com.zerobase.hseungho.api.loan.util.GenerateKey
import com.zerobase.hseungho.domain.domain.UserInfo
import com.zerobase.hseungho.domain.repository.UserInfoRepository
import com.zerobase.hseungho.kafka.enum.KafkaTopic
import com.zerobase.hseungho.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val generateKey: GenerateKey,
        private val encryptComponent: EncryptComponent,
        private val userInfoRepository: UserInfoRepository,
        private val loanRequestSender: LoanRequestSender
) : LoanRequestService {

    override fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
                encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)

        loanRequestReview(userInfoDto)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(
            userInfoDto: UserInfoDto
    ) : UserInfo = userInfoRepository.save(userInfoDto.toEntity())

    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
                KafkaTopic.LOAN_REQUEST,
                userInfoDto.toLoanRequestKafkaDto()
        )
    }

}