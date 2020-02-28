package com.zizou.template.launch.model

import java.io.Serializable

data class Landing(
    var landingType: String? = null,
    var data: String? = null
) : Serializable {
}