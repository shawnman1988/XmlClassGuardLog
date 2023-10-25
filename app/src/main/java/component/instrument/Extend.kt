package component.instrument

import android.text.Html
import android.view.View

inline fun <T : View> T.postApply(crossinline block: T.() -> Unit) {
    post {
        apply(block)
    }
}

inline fun safeRun(block: () -> (Unit), catch: ((Throwable) -> (Unit))) {
    try {
        block.invoke()
    } catch (e: Throwable) {
        catch.invoke(e)
        e.printStackTrace()
    }
}

inline fun safeRun(block: () -> (Unit)) {
    try {
        block.invoke()
    } catch (e: Throwable) {
        e.printStackTrace()
    }
}

inline fun safeRunIo(block: () -> (Unit)) {
    threadPool.run {
        try {
            block.invoke()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }
}

fun String.toHtml(): CharSequence {
    return try {
        Html.fromHtml(this)
    } catch (e: Exception) {
        e.printStackTrace()
        this
    }
}
