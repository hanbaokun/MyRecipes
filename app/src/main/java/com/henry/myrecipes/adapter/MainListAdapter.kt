package com.henry.myrecipes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.henry.myrecipes.R
import com.henry.myrecipes.data.ChildsItem
import javax.inject.Inject

/**
 * Created by hanbaokun on 2018/3/24.
 */
class MainListAdapter(context: Context) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {
    private val context: Context
    var listData: List<ChildsItem> = listOf<ChildsItem>()

    init {
        this.context = context
    }

    fun setData(listData: List<ChildsItem>) {
        this.listData = listData
//        notifyDataSetChanged()
        notifyItemRangeChanged(0, this.listData.size)
    }

    @Inject
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false)
        return MainListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        val item = listData.get(position)
        holder.tvTitle!!.setText(item.categoryInfo.name)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView? = null

        init {
            tvTitle = itemView.findViewById(R.id.tv_title)
        }
    }

}