@file:JvmName("PrefsUtils")

package diplom.time.utils

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.Delegates

private var mPrefs by Delegates.notNull<SharedPreferences>()

fun initPrefs(context: Context) {
            mPrefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
}

fun getNotesSortMethodName(defaultValue: String): String = mPrefs.getString("sort_method", defaultValue)

fun setNotesSortMethod(sortMethod: String) {
            mPrefs.edit().putString("sort_method", sortMethod).commit()
}

fun getPasSortMethodName(defaultValue: String): String = mPrefs.getString("sort_method", defaultValue)

fun setPasSortMethod(sortMethod: String) {
    mPrefs.edit().putString("sort_method", sortMethod).commit()
}