package com.zizou.template.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zizou.template.template.model.TemplateModel
import com.zizou.template.template.dao.TemplateModelDao

@Database(entities = arrayOf(TemplateModel::class), version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun templateModelDao(): TemplateModelDao
}