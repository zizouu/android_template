package com.zizou.template.template.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zizou.template.template.repository.TemplateRepository

class TemplateViewModelFactory(
    val templateRepository: TemplateRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return TemplateViewModel(templateRepository) as T
    }
}