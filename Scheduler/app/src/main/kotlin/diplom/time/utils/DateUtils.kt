@file:JvmName("DateUtils")

package diplom.time.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: Date?): String {
    var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm");
    return dateFormat.format(date)
}