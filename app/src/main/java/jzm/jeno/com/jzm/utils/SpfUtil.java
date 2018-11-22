package jzm.jeno.com.jzm.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SpfUtil {
    /**
     * 向SP文件存储数据
     *
     * @param context
     * @param key     键名
     * @param value   键值
     */

    public static final String SP_SEARCH = "key_search";


    public static void saveValue(Context context, String key, Object value) {
        try {
            SharedPreferences sp = context.getSharedPreferences(
                    SP_SEARCH, Context.MODE_PRIVATE);
            Editor editor = sp.edit();
            if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            }
            editor.commit();
        } catch (Exception e) {
        }
    }

    /**
     * 从SP文件中读取指定Key的值
     * <p/>
     * type=1/数值 defValue=-1 | type=2/字符串 defValue=null | type=3/布尔
     * defValue=false
     *
     * @param context
     * @param key     键名
     * @return 键值
     */
    public static Object getValue(Context context, String key,
                                  Object defaultObject) {
        Object object = null;
        try {
            SharedPreferences sp = context.getSharedPreferences(
                    SP_SEARCH, Context.MODE_PRIVATE);
            object = null;
            if (defaultObject instanceof Integer) {
                return sp.getInt(key, (Integer) defaultObject);
            } else if (defaultObject instanceof String) {
                return sp.getString(key, (String) defaultObject);
            } else if (defaultObject instanceof Boolean) {
                return sp.getBoolean(key, (Boolean) defaultObject);
            }
        } catch (Exception e) {
        }
        return object;
    }


    /**
     * 清空
     *
     * @param context
     */
    public static void clearValues(Context context) {
        try {
            SharedPreferences sp = context.getSharedPreferences(
                    SP_SEARCH, Context.MODE_PRIVATE);
            Editor editor = sp.edit();
            editor.clear();
            editor.commit();
        } catch (Exception e) {
        }
    }


}
