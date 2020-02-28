package com.zizou.template.template.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "template_room_model")
data class TemplateModel(
    @PrimaryKey(autoGenerate = true) var index: Int? = null,
    @ColumnInfo(name = "created_date") var createdDate: Date = Date(System.currentTimeMillis()),
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "content") var content: String = "",
    @ColumnInfo(name = "modified_date") var modifiedDate: Date = Date(System.currentTimeMillis()),
    @Ignore var ignoreSample: MutableList<Any> = mutableListOf()
) : Serializable {
}