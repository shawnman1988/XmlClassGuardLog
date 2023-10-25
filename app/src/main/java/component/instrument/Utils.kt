package component.instrument

import com.blankj.utilcode.constant.AutoConstants
import com.blankj.utilcode.util.CacheDiskStaticUtils

fun inApp() {
    CacheDiskStaticUtils.put(AutoConstants.INAPP, "true")
}

fun isInApp(): Boolean {
    return CacheDiskStaticUtils.getString(AutoConstants.INAPP, "") == "true"
}
