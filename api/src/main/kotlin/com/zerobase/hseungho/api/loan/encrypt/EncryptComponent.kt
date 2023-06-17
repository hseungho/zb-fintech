package com.zerobase.hseungho.api.loan.encrypt

import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptComponent {

    companion object {
        private const val secretKey = "12345678912341501234102312331231231"
    }

    private val encoder  = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    fun encryptString(target: String) : String {
        val encryptedString = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey).doFinal(target.toByteArray(Charsets.UTF_8))

        return String(encoder.encode(encryptedString))
    }

    fun decryptString(target: String) : String {
        val byteString = decoder.decode(target.toByteArray(Charsets.UTF_8))

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    fun cipherPkcs5(opMode: Int, secretKey: String) : Cipher {
        val c = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))
        c.init(opMode, sk, iv)
        return c
    }

}