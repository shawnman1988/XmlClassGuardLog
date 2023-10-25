package component.instrument;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.TypedValue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import component.instrument.AesGcmUtil;
import component.instrument.LoggerKt;
import component.instrument.proguard.BaseProguardString;

public class ResourceUtils {

    /**
     * ID
     */
    private static List<Integer> nhe = Arrays.asList(//T003resIds  nhe  nhe 

    );

    private static Map<Integer, String> alienees = new HashMap<>();//T003resContents  alienees  alienees 
    private static Map<Integer, Locale> beanfest = new HashMap<>();//T003resLocals  beanfest  beanfest 

    /**
     * ：ResourceUtils.getString(context,R.string.notification_battery_low_bt_desc)
     * String
     *
     * @param context
     * @param resId
     * @return
     */
    public static String getString(Context context, int resId) {
        if (nhe.contains(resId) || nhe.size() == 0) {//T003resIds  nhe (nhe.
            if (alienees.containsKey(resId)) {//T003resContents  alienees (alienees.
                return alienees.get(resId);//T003resContents  alienees  alienees.
            }
            String es = context.getString(resId);
            String ds = AesGcmUtil.INSTANCE.decrypt("", es);
            alienees.put(resId, ds);//T003resContents  alienees  alienees.
            return ds;
        }

        return context.getString(resId);
    }

    /**
     * String
     *
     * @param context
     * @param resId
     * @param formatArgs
     * @return
     */
    public static String getString(Context context, int resId, Object... formatArgs) {
        if (nhe.contains(resId) || nhe.size() == 0) {//T003resIds  nhe (nhe.
            String ds = "";
            Locale locale = null;
            if (alienees.containsKey(resId)) {//T003resContents  alienees (alienees.
                ds = alienees.get(resId);//T003resContents  alienees  alienees.
                locale = beanfest.get(resId);//T003resLocals  beanfest  beanfest.
            } else {
                String es = context.getString(resId);
                ds = AesGcmUtil.INSTANCE.decrypt("", es);
                alienees.put(resId, ds);//T003resContents  alienees  alienees.
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    locale = context.getResources().getConfiguration().getLocales().get(0);
                }
                beanfest.put(resId, locale);//T003resLocals  beanfest  beanfest.
            }
            if (locale != null) {
                return String.format(locale, ds, formatArgs);
            } else {
                return String.format(ds, formatArgs);
            }
        }
        return context.getString(resId, formatArgs);
    }

    /**
     * ：ivTabTag.setImageBitmap(ResourceUtils.readDrawable(context,R.drawable.xor_icon_tab_tag))
     * Bitmap
     *
     * @param context
     * @param resId
     * @return
     * @throws Exception
     */
    public static Bitmap readDrawable(Context context, int resId) throws Exception {

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);


        return bitmap;

    }
}
