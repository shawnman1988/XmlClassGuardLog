package component.instrument

import android.os.Handler
import android.os.Looper
import java.lang.Exception
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.jvm.Throws

/**
 * @desc 
 */
val threadPool: ExecutorService = Executors.newCachedThreadPool()

/**
 * Handler
 */
val handler = Handler(Looper.getMainLooper())

/**
 * IO
 */
fun runOnIoThread(block: () -> (Unit)) {
    threadPool.execute(block)
}

/**
 * UI
 */
fun delayOnUiThread(block: () -> (Unit), mills: Long) {
    handler.postDelayed(block, mills)
}

/**
 * UI
 */
fun runOnUiThread(block: () -> (Unit)) {
    handler.post(block)
}

object ThreadState {
    const val MAIN = 0
    const val IO = 1
}

/**
 * 
 */
class Coordination<Result> constructor(private val block: () -> (Result)) {


    /**
     *  
     */
    @Throws(Exception::class)
    fun async(
        threadState: Int = ThreadState.MAIN,
        error: ((Exception) -> (Unit))? = null,
        action: ((Result) -> (Unit))? = null
    ) {
        threadPool.execute {
            val result: Result
            try {
                result = block.invoke()
            } catch (e: Exception) {
                error?.invoke(e) ?: throw e
                return@execute
            }
            if (action != null) {
                if (threadState == ThreadState.MAIN) {
                    handler.post {
                        action.invoke(result)
                    }
                } else {
                    action.invoke(result)
                }
            }
        }
    }

    /**
     * 
     */
    @Throws(Exception::class)
    fun await(): Result {
        return block()
    }

}

/**
 * 
 */
fun <Result> fetch(block: () -> (Result)): Coordination<Result> {
    return Coordination(block)
}
