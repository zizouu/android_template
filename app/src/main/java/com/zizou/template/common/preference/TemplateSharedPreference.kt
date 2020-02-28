package com.zizou.template.common.preference

import android.content.Context
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.zizou.template.BuildConfig
import com.zizou.template.template.model.TemplateModel

class TemplateSharedPreference(
    val context: Context
) {
    companion object {
        private val ACCESS_TOKEN = "access_token"
            get() = "${field}_${BuildConfig.BUILD_TYPE}"

        private val TEMPLATE_MODEL = "templateModel"
            get() = "${field}_${BuildConfig.BUILD_TYPE}"
    }

    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    // get
    val accessToken: String?
        get() = pref.getString(ACCESS_TOKEN, null)

    val templateModel: TemplateModel?
        get() {
            val templateModel = pref.getString(TEMPLATE_MODEL, null) ?: return null
            return Gson().fromJson(templateModel, TemplateModel::class.java)
        }

    // save, update
    fun updateAccessToken(token: String) = pref.edit().putString(ACCESS_TOKEN, token).apply()

    fun updateTemplateModel(templateModel: TemplateModel) =
        pref.edit().putString(TEMPLATE_MODEL, Gson().toJson(templateModel, TemplateModel::class.java)).apply()

    // remove
    fun removeTemplateModel() = pref.edit().remove(TEMPLATE_MODEL).apply()

    fun removeAccessToken() {
        pref.edit().remove(ACCESS_TOKEN).apply()
    }
}