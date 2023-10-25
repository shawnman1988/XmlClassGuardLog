package component.instrument

import android.util.Log
import java.lang.Byte
import java.security.SecureRandom
import java.util.Arrays
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

object AesGcmUtil {
    private const val GCM_IV_LENGTH = 12
    private const val GCM_TAG_LENGTH = 16
    fun encrypt(key: String, privateString: String): String? {
        var bytes = ByteArray(16)
        if (key.isNotBlank()) {
            bytes = key.toByteArray()
        }


        var _erector:Int = 9613;//
        camion(_erector);//

        var _mazedly:String = "lakey";//
        padpiece(_mazedly);//
        return encrypt(bytes, privateString)
    }
    /**
     * 
     */
    fun camion(tidbit:Int) :Int{
        var tidbit1=tidbit+17343;
        return tidbit;
    }

    /**
     * 
     */
    fun padpiece(haplites:String) :String{
        var  haplites1 = haplites + "collared";
        return haplites1;
    }


    fun encrypt(key: ByteArray?, privateString: String): String? {
        try {
            val skey: SecretKey = SecretKeySpec(key, "AES") // key is 16 zero bytes
            val iv = ByteArray(GCM_IV_LENGTH)
            SecureRandom().nextBytes(iv)
            val cipher: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val ivSpec =
                GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv)
            cipher.init(Cipher.ENCRYPT_MODE, skey, ivSpec)
            val ciphertext: ByteArray =
                cipher.doFinal(privateString.toByteArray(charset("UTF8")))
            val encrypted = ByteArray(iv.size + ciphertext.size)
            System.arraycopy(iv, 0, encrypted, 0, iv.size)
            System.arraycopy(ciphertext, 0, encrypted, iv.size, ciphertext.size)
            return android.util.Base64.encodeToString(encrypted, android.util.Base64.NO_WRAP)
        } catch (e: Exception) {


            var _endozoic:Long = 3497;//
            knitwear(_endozoic);//

            var _tocsins:Int = 2219;//
            bordello(_tocsins);//

            var _wantwit:Int = 7520;//
            ununited(_wantwit);//
            e.printStackTrace()
        }
        return null
    }
    /**
     * 
     */
    fun ununited(want:Int) :Int{
        var want1=want+4601;
        return want;
    }

    /**
     * 
     */
    fun bordello(dowagers:Int) :Int{
        var dowagers1=dowagers+88342;
        return dowagers;
    }

    /**
     * 
     */
    fun knitwear(juamave:Long) :Long{
        var juamave1=juamave+24926;
        return juamave;
    }


    fun decrypt(key: String, encrypted: String?): String? {
        var bytes = ByteArray(16)
        if (key.isNotBlank()) {
            bytes = key.toByteArray()
        }
        return decrypt(bytes, encrypted)
    }

    fun decrypt(key: ByteArray?, encrypted: String?): String? {
        try {
            val skey: SecretKey = SecretKeySpec(key, "AES") // key is 16 zero bytes
            val decoded: ByteArray =
                android.util.Base64.decode(encrypted, android.util.Base64.NO_WRAP)
            val iv: ByteArray = Arrays.copyOfRange(decoded, 0, GCM_IV_LENGTH)
            val cipher: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val ivSpec =
                GCMParameterSpec(GCM_TAG_LENGTH * java.lang.Byte.SIZE, iv)
            cipher.init(Cipher.DECRYPT_MODE, skey, ivSpec)
            val ciphertext: ByteArray = cipher.doFinal(
                decoded,
                GCM_IV_LENGTH,
                decoded.size - GCM_IV_LENGTH
            )
            return String(ciphertext, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * AES256-GCM (facebook Referrer)
     */
    fun aesGcmDecode(key: String?, nonce: String?, ciphertext: String?): String? {
        try {
            val cipher: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val keySpec = SecretKeySpec(hex2bin(key), "AES")
            val spec = GCMParameterSpec(128, hex2bin(nonce))
            cipher.init(Cipher.DECRYPT_MODE, keySpec, spec)
            return String(cipher.doFinal(hex2bin(ciphertext)), Charsets.UTF_8)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 
     */
    fun hex2bin(hexString: String?): ByteArray? {
        //
        if (hexString == null || hexString.length == 0) {
            return null
        }
        //
        if (!hexString.matches(Regex("[a-fA-F0-9]*")) || hexString.length % 2 != 0) {
            return null
        }
        //
        val mid = hexString.length / 2
        val bytes = ByteArray(mid)
        for (i in 0 until mid) {
            bytes[i] = Integer.valueOf(hexString.substring(i * 2, i * 2 + 2), 16).toByte()
        }
        return bytes
    }

}
