package component.instrument

import android.text.TextUtils
import android.util.Log
import androidx.annotation.IntDef
import component.instrument.proguard.BaseProguardString
import java.io.File
import java.io.FileInputStream
import java.text.DecimalFormat


/**
 *  () 
 *
 * @param filePath
 * @return  bytes
 * @throws Exception
 */
@Throws(Exception::class)
fun getFileSize(filePath: String?): Long {
    var size: Long = 0
    if (TextUtils.isEmpty(filePath)) {
        return size
    }
    val file = File(filePath)

    if (!file.exists()) {
        return size
    }
    if (file.isFile) {
        var fis: FileInputStream? = null
        fis = FileInputStream(file)
        return fis.available().toLong()
    } else if (file.isDirectory) {
        val flist = file.listFiles()
        for (i in flist.indices) {
            size += getFileSize(flist[i].path)
        }
    }
    return size
}

// ########################################################

// ########################################################
// ，class
@Retention(AnnotationRetention.SOURCE) // 
@IntDef(SizeType.SIZETYPE_B, SizeType.SIZETYPE_KB, SizeType.SIZETYPE_MB, SizeType.SIZETYPE_GB)
annotation class SizeType {
    companion object {
        // Bdouble
        const val SIZETYPE_B = 1

        // KBdouble
        const val SIZETYPE_KB = 2

        // MBdouble
        const val SIZETYPE_MB = 3

        // GBdouble
        const val SIZETYPE_GB = 4
    }
}

/**
 * ：B、KB、MB、GB （）
 *
 * @param filePath
 * @param sizeType
 * @return
 */
fun getFormatFileSize(filePath: String?, @SizeType sizeType: Int): Double {
    var blockSize: Long = 0
    try {
        blockSize = getFileSize(filePath)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formatFileSize(blockSize, sizeType)
}

private fun formatFileSize(fileSize: Long, @SizeType sizeType: Int): Double {
    val df = DecimalFormat(BaseProguardString.FILE_FORMAT)
    var fileSizeLong = 0.0
    when (sizeType) {
        SizeType.SIZETYPE_B -> fileSizeLong =
            java.lang.Double.valueOf(df.format(fileSize.toDouble()))

        SizeType.SIZETYPE_KB -> fileSizeLong =
            java.lang.Double.valueOf(df.format(fileSize.toDouble() / 1024))

        SizeType.SIZETYPE_MB -> fileSizeLong =
            java.lang.Double.valueOf(df.format(fileSize.toDouble() / 1048576))

        SizeType.SIZETYPE_GB -> fileSizeLong = java.lang.Double.valueOf(
            df.format(fileSize.toDouble() / 1073741824)
        )

        else -> {}
    }
    return fileSizeLong
}
