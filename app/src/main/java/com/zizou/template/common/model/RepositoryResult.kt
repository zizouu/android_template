package com.zizou.template.common.model

import java.io.Serializable

data class RepositoryResult<T>(
    var resultCode: Int? = null,
    var resultData: T? = null
) : Serializable {
    companion object {
        const val RESULT_SUCCESS = 200
        const val RESULT_FAIL = 500
    }
}