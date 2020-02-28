package com.zizou.template.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zizou.template.R
import com.zizou.template.common.CommonConst
import com.zizou.template.common.view.BaseActivity
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.launch.model.Landing
import com.zizou.template.main.view.listener.OnRequestView
import com.zizou.template.main.viewmodel.MainViewModel
import com.zizou.template.main.viewmodel.MainViewModelFactory
import com.zizou.template.template.view.TemplateFragment
import com.zizou.template.templates.view.TemplatesFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), OnRequestView {
    companion object {
        const val TAG = "MainActivity"
        private const val BACKBUTTON_PRESS_INTERVAL = 2000
    }

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private var backButtonPressTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        initializeUi()
        subscribeUi()
        subscribeViewModel(viewModel)

        val landing = intent.getSerializableExtra(CommonConst.KEY_LANDING) as? Landing?
        processLanding(landing)

        showTemplates()
    }

    override fun initializeUi() {
        super.initializeUi()
    }

    override fun subscribeUi() {
        super.subscribeUi()
    }

    override fun subscribeViewModel(viewModel: BaseViewModel) {
        super.subscribeViewModel(viewModel)
    }

    private fun processLanding(landing: Landing?) {
        landing?.run {
            // do something
        }
    }

    override fun showTemplates() {
        val fragment = TemplatesFragment()

        replaceFragment(fragment, tag = TemplatesFragment.TAG, isSlideAnim = true)
    }

    override fun showTemplate(index: Int) {
        val fragment = TemplateFragment()

        fragment.arguments = Bundle().apply {
            putInt(CommonConst.KEY_TEMPLATE_INDEX, index)
        }

        replaceFragment(fragment, tag = TemplatesFragment.TAG, isSlideAnim = true)
    }

    private fun replaceFragment(
        fragment: Fragment,
        tag: String? = null,
        isAdd: Boolean = false,
        isSlideAnim: Boolean = false,
        isVerticalAnim: Boolean = false,
        isAddToBackStack: Boolean = true
    ) {
        val transaction = supportFragmentManager.beginTransaction().apply {
            if (isSlideAnim && !isVerticalAnim) {
                setCustomAnimations(
                    R.anim.slidein_toleft,
                    R.anim.slideout_toleft,
                    R.anim.slidein_toright,
                    R.anim.slideout_toright
                )
            } else if (isSlideAnim && isVerticalAnim) {
                setCustomAnimations(
                    R.anim.slidein_toup,
                    R.anim.slideout_todown,
                    R.anim.slidein_toup,
                    R.anim.slideout_todown
                )
            }

            if (isAdd) {
                add(R.id.containerFragment, fragment, tag)
            } else {
                replace(R.id.containerFragment, fragment, tag)
            }

            if (isAddToBackStack) {
                addToBackStack(null)
            }
        }

        transaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 2) {
            processBackButtonMessage()
        } else {
            super.onBackPressed()
        }
    }

    private fun processBackButtonMessage() {
        if (System.currentTimeMillis() > backButtonPressTime + BACKBUTTON_PRESS_INTERVAL) {
            viewModel.message.onNext(getString(R.string.common_back_button_press))
            backButtonPressTime = System.currentTimeMillis()
        } else {
            finish()
        }
    }
}