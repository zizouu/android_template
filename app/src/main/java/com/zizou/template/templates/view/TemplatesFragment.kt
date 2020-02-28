package com.zizou.template.templates.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zizou.template.R
import com.zizou.template.common.view.BaseFragment
import com.zizou.template.common.viewmodel.BaseViewModel
import com.zizou.template.main.view.MainBaseFragment
import com.zizou.template.template.model.TemplateModel
import com.zizou.template.templates.view.adapter.TemplatesAdapter
import com.zizou.template.templates.view.listener.OnTemplateClickListener
import com.zizou.template.templates.viewmodel.TemplatesViewModel
import com.zizou.template.templates.viewmodel.TemplatesViewModelFactory
import kotlinx.android.synthetic.main.fragment_templates.*
import javax.inject.Inject

class TemplatesFragment : MainBaseFragment(), OnTemplateClickListener {
    companion object {
        const val TAG = "TemplatesFragment"
    }

    @Inject
    lateinit var viewModelFactory: TemplatesViewModelFactory
    private lateinit var viewModel: TemplatesViewModel
    private lateinit var recyclerViewAdapter: TemplatesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[TemplatesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_templates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
        subscribeUi()
        subscribeViewModel(viewModel)
        requestTemplates()
    }

    override fun initializeUi() {
        super.initializeUi()
        initializeRecyclerView()
    }

    override fun subscribeUi() {
        super.subscribeUi()
    }

    override fun subscribeViewModel(baseViewModel: BaseViewModel) {
        super.subscribeViewModel(baseViewModel)
        disposables.add(
            viewModel.templates
                .subscribe({
                    recyclerViewAdapter.addData(it.toMutableList())
                }) {
                    viewModel.error.onNext("${it.message}")
                }
        )
    }

    private fun initializeRecyclerView() {
        recyclerViewAdapter = TemplatesAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.itemAnimator = null
        recyclerView.addItemDecoration(
            RecyclerViewDecoration(
                resources.getDimension(
                    R.dimen.common_list_divide_margin
                ).toInt()
            )
        )
    }

    private fun requestTemplates() {
        viewModel.getTemplates()
    }

    override fun onTemplateClick(template: TemplateModel) {
        template.index?.run {
            onRequestViewListener?.showTemplate(this)
        }
    }
}