package com.example.newsdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsdemo.R
import com.example.newsdemo.model.NewsItem

/**
 * RecyclerView 适配器：把新闻数据绑定到每一行 item 布局
 */
class NewsAdapter(
    private val newsList: MutableList<NewsItem>,
    private val onItemClick: (NewsItem) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    /**
     * ViewHolder：缓存每个 item 的控件引用，避免重复 findViewById
     */
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageNews: ImageView = itemView.findViewById(R.id.imageNews)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]

        // 绑定标题
        holder.textTitle.text = item.title

        // 使用 Coil 加载网络图片
        holder.imageNews.load(item.imageUrl) {
            placeholder(R.drawable.bg_placeholder)
            error(R.drawable.bg_placeholder)
        }

        // 点击 item 后，把当前新闻回调给页面
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = newsList.size

    /**
     * 更新列表数据（用于下拉刷新或重新加载）
     */
    fun updateData(newList: List<NewsItem>) {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }
}
