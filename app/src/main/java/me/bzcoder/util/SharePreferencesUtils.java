package me.bzcoder.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharePreferences 工具类
 */
public class SharePreferencesUtils {

	/** 日志Tag */
	private static final String TAG = "SharePreferencesUtils";
	/** 默认SharePreferences对象 */
	private static SharedPreferences mSharePreferences = null;
	/** 文件名 */
	private static final String NAME = "ProConfig";
	// ========================================================
	// ============  操作类型  ================
	/** 查询操作 */
	public static final int SP_SELECT_OPERATE = 0;
	/** 保存操作 */
	public static final int SP_SAVE_OPERATE = 1;
	/** 清空操作 */
	public static final int SP_CLEAR_OPERATE = 2;

	/**
	 * 获取 SharedPreferences 对象,防止未null
	 * @param mContext 上下文
	 * @return
	 */
	private static SharedPreferences getSharedPreferences(Context mContext) {
		if (mSharePreferences == null) {
			// 参数：name mode
			mSharePreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		}
		return mSharePreferences;
	}
	
	// =======
	
	/**
	 * 获取boolean
	 * @param mContext 上下文 -- getApplicationContext()
	 * @param key 
	 * @param defValue 默认值
	 * @return
	 */
	public static boolean getBoolean(Context mContext, String key, boolean defValue){
		return getSharedPreferences(mContext).getBoolean(key, defValue);
	}
	
	/**
	 * 设置boolean数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param value
	 */
	public static void setBoolean(Context mContext, String key, boolean value){
		SharedPreferences sp = getSharedPreferences(mContext);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	
	// =======
	
	/**
	 * 获得String数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param defValue 默认值
	 * @return
	 */
	public static String getString(Context mContext, String key, String defValue){
		return getSharedPreferences(mContext).getString(key, defValue);
	}
	
	/**
	 * 设置String数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param value
	 */
	public static void setString(Context mContext, String key, String value){
		SharedPreferences sp = getSharedPreferences(mContext);
		Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	// =======
	
	/**
	 * 获得Long数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param defValue 默认值
	 * @return
	 */
	public static long getLong(Context mContext, String key, long defValue){
		return getSharedPreferences(mContext).getLong(key, defValue);
	}
	
	/**
	 * 设置Long数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param value
	 */
	public static void setLong(Context mContext, String key, long value){
		SharedPreferences sp = getSharedPreferences(mContext);
		Editor editor = sp.edit();
		editor.putLong(key, value);
		editor.commit();
	}
	
	// =======
	
	/**
	 * 获得Float数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param defValue 默认值
	 * @return
	 */
	public static float getFloat(Context mContext, String key, float defValue){
		return getSharedPreferences(mContext).getFloat(key, defValue);
	}
	
	/**
	 * 设置Float数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param value
	 */
	public static void setFloat(Context mContext, String key, float value){
		SharedPreferences sp = getSharedPreferences(mContext);
		Editor editor = sp.edit();
		editor.putFloat(key, value);
		editor.commit();
	}
	
	// =======
	
	/**
	 * 获得Int数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param defValue 默认值
	 * @return
	 */
	public static int getInt(Context mContext, String key, int defValue){
		return getSharedPreferences(mContext).getInt(key, defValue);
	}
	
	/**
	 * 设置Int数据
	 * @param mContext  上下文 -- getApplicationContext()
	 * @param key
	 * @param value
	 */
	public static void setInt(Context mContext, String key, int value){
		SharedPreferences sp = getSharedPreferences(mContext);
		Editor editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
	}
}
