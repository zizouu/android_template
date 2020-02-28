package com.zizou.template.launch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.zizou.template.common.CommonConst
import com.zizou.template.common.view.BaseActivity
import com.zizou.template.launch.model.Landing
import com.zizou.template.main.view.MainActivity

class SplashActivity : BaseActivity() {
    companion object {
        const val TAG = "SplashActivity"
        const val DELAY_TIME = 2000L
    }

    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val landing = intent.getSerializableExtra(CommonConst.KEY_LANDING) as? Landing?
        showMain(landing)
    }

    private fun showMain(landing: Landing?) {
        handler = Handler()
        handler?.postDelayed({
            val intent = Intent(this, MainActivity::class.java)

            landing?.run {
                intent.putExtra(CommonConst.KEY_LANDING, landing)
            }

            startActivity(intent)
            finish()
        }, DELAY_TIME)
    }

    override fun onDestroy() {
        handler?.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}