package com.zizou.template.launch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.zizou.template.common.CommonConst
import com.zizou.template.common.view.BaseActivity
import com.zizou.template.launch.model.Landing

class LaunchActivity : BaseActivity() {
    companion object {
        const val TAG = "LaunchActivity"
    }

    private var landing: Landing? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.action == Intent.ACTION_VIEW) {
            landing = makeLanding(intent.data)
        }

        showSplash(landing)
        finish()
    }

    private fun makeLanding(uri: Uri?): Landing? {
        // uri 에 맞춰 랜딩 생성
        return Landing()
    }

    private fun showSplash(landing: Landing?) {
        val intent = Intent(this, SplashActivity::class.java)

        landing?.run {
            intent.putExtra(CommonConst.KEY_LANDING, this)
        }

        startActivity(intent)
    }
}
