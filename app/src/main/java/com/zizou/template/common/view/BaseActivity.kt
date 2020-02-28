package com.zizou.template.common.view

import android.widget.Toast
import com.zizou.template.BuildConfig
import com.zizou.template.R
import com.zizou.template.TemplateApplication
import com.zizou.template.common.viewmodel.BaseViewModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity : DaggerAppCompatActivity() {
    val disposables = CompositeDisposable()

    open fun initializeUi() {

    }

    open fun subscribeUi() {

    }

    open fun subscribeViewModel(viewModel: BaseViewModel) {
        subscribeBaseViewModel(viewModel)
    }

    private fun subscribeBaseViewModel(viewModel: BaseViewModel) {
        disposables.add(
            viewModel.message
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showToast(it)
                }) {
                    viewModel.error.onNext("${it.message}")
                }
        )

        disposables.add(
            viewModel.error
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (BuildConfig.DEBUG) {
                        showToast(it)
                    } else {
                        showToast(getString(R.string.common_error))
                    }
                }) {
                    if (BuildConfig.DEBUG) {
                        showToast("${it.message}")
                    } else {
                        showToast(getString(R.string.common_error))
                    }
                }
        )
    }

    fun showToast(message: String) {
        Toast.makeText(TemplateApplication.application, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}