package me.stefan.coordinatorlayoutstudy.adapter

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val context: Context, val dataList: Array<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val textView = TextView(context)
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.setPadding(0, 40, 0, 40)
        textView.setBackgroundColor(Color.GREEN)
        textView.gravity = Gravity.CENTER
        textView.layoutParams = layoutParams
        return ItemViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        if (holder is ItemViewHolder) {
            holder.textView.text = data
            holder.textView.setOnClickListener {
                mOnItemClickListener?.onItemClick(position, data)
            }
        }
    }

    class ItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

    private var mOnItemClickListener: OnItemClickListener? = null

    fun setOnClickListener(onItemClickListener: OnItemClickListener){
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int, textContent: String)
    }

}