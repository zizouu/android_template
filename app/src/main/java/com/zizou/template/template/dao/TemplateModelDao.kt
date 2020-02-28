package com.zizou.template.template.dao

import androidx.room.*
import com.zizou.template.template.model.TemplateModel
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface TemplateModelDao {
    @Query("SELECT * FROM template_room_model")
    fun getAll(): Flowable<List<TemplateModel>>

    @Query("SELECT * FROM template_room_model WHERE `index` = :index")
    fun findByIndex(index: Int): Flowable<TemplateModel>

    @Update
    fun updateOne(templateRoomModel: TemplateModel): Maybe<Int>

    @Insert
    fun insertOne(templateRoomModel: TemplateModel): Maybe<Long>

    @Delete
    fun deleteOne(templateRoomModel: TemplateModel): Maybe<Int>
}