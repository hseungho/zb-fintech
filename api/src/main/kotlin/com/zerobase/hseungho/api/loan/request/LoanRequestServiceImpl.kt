package com.zerobase.hseungho.api.loan.request

import com.zerobase.hseungho.api.loan.GenerateKey
import com.zerobase.hseungho.api.loan.encrypt.EncryptComponent
import com.zerobase.hseungho.domain.domain.UserInfo
import com.zerobase.hseungho.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val generateKey: GenerateKey,
        private val encryptComponent: EncryptComponent,
        private val userInfoRepository: UserInfoRepository
) : LoanRequestService {

    override fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
                encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview("")

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(
            userInfoDto: UserInfoDto
    ) : UserInfo = userInfoRepository.save(userInfoDto.toEntity())

    override fun loanRequestReview(userKey: String) {
        TODO("Not yet implemented")
    }

}