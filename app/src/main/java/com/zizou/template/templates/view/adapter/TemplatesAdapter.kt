package com.zizou.template.templates.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.zizou.template.R
import com.zizou.template.template.model.TemplateModel
import com.zizou.template.templates.view.listener.OnTemplateClickListener

class TemplatesAdapter(
    val listener: OnTemplateClickListener
) : RecyclerView.Adapter<TemplatesAdapter.TemplateViewHolder>() {
    var templates: MutableList<TemplateModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_template, parent, false)
        return TemplateViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return templates.size
    }

    override fun onBindViewHolder(holder: TemplateViewHolder, position: Int) {
        with(holder) {
            if (getItemViewType(position) == 0) {
                val params = containerRoot.layoutParams as RecyclerView.LayoutParams
                params.topMargin = context.resources.getDimension(R.dimen.templates_first_item_margin).toInt()
            }

            val template = templates[position]
            showTempalte(this, template)
        }
    }

    private fun showTempalte(holder: TemplateViewHolder, template: TemplateModel) {
        with(holder) {
            textViewTitle.text = template.title

            containerRoot.setOnClickListener {
                listener.onTemplateClick(template)
            }
        }
    }

    override fun onViewAttachedToWindow(holder: TemplateViewHolder) {
        super.onViewAttachedToWindow(holder)
        with(holder) {
            // 다시 보여질때 처리할 것들
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setData(templates: MutableList<TemplateModel>) {
        this.templates = templates
    }

    fun addData(additionalItems: MutableList<TemplateModel>) {
        val addIndex = this.templates.size
        this.templates.addAll(this.templates.size, additionalItems)
        notifyItemRangeInserted(addIndex, additionalItems.size)
    }

    fun removeData(index: Int) {
        this.templates.removeAt(index)
        notifyItemRemoved(index)
    }

    class TemplateViewHolder(
        view: View,
        val context: Context
    ) : RecyclerView.ViewHolder(view) {
        var template: TemplateModel? = null
        val containerRoot by lazy { view.findViewById<ConstraintLayout>(R.id.containerRoot) }
        val cardView by lazy { view.findViewById<CardView>(R.id.cardView) }
        val textViewTitle by lazy { view.findViewById<TextView>(R.id.textViewTitle) }
    }
}