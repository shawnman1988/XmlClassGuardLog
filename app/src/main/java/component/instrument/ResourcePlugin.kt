package component.instrument

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

fun Resources.getResText(resId: Int): String {

    return getResourceText(this, resId)
}

fun Fragment.getResText(resId: Int): String {
    return getResourceText(resources, resId)
}

fun Context.getResText(resId: Int): String {
    return getResourceText(resources, resId)
}

fun getResText(resId: Int): String {
    return "";
}

fun Context.getResText(resId: Int, vararg args: Any): String {
    return getResourceText(resources, resId).format(args)
}

fun View.setBackgroundImageRes(resId: Int) {
    context.getResBitmap(resId).apply {
        setBackgroundDrawable(BitmapDrawable(this))
    }
}

fun ImageView.setImageRes(resId: Int) {
    context.getResBitmap(resId).apply {
        setImageBitmap(this)
    }
}

fun Context.getResBitmap(resId: Int): Bitmap {
    return createBitmap(this, resId)
}

fun Context.getResBitmapDrawable(resId: Int): Drawable {
    return BitmapDrawable(createBitmap(this, resId))
}

/**
 * 
 */
private fun getResourceText(resources: Resources, resId: Int): String {

    return resources.getString(resId);
}

/**
 * 
 */
private fun createBitmap(context: Context, resId: Int): Bitmap {
    return ResourceUtils.readDrawable(context, resId);
}
