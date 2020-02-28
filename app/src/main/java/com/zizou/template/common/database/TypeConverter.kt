package com.zizou.template.common.database

import androidx.room.TypeConverter
import java.util.*

class TypeConverter {
    @TypeConverter
    fun convertTimeStampToDate(timeStamp: Long?): Date? {
        return timeStamp?.let { Date(it) }
    }

    @TypeConverter
    fun convertDateToTimeStamp(date: Date?): Long? {
        return date?.time
    }
}