package com.example.tara

class encryptionhelper {
}
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import android.util.Base64

object EncryptionHelper {

  private const val SECRET_KEY = "1234567890123456"

  fun encrypt(data: String): String {
    val key = SecretKeySpec(SECRET_KEY.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val encrypted = cipher.doFinal(data.toByteArray())
    return Base64.encodeToString(encrypted, Base64.DEFAULT)
  }

  fun decrypt(data: String): String {
    val key = SecretKeySpec(SECRET_KEY.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.DECRYPT_MODE, key)
    val decoded = Base64.decode(data, Base64.DEFAULT)
    return String(cipher.doFinal(decoded))
  }
}
