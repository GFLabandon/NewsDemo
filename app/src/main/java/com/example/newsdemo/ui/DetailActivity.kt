package com.example.newsdemo.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.newsdemo.R

/**
 * 新闻详情页
 * 展示标题、图片、摘要，并可跳转到原网页
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageDetail: ImageView = findViewById(R.id.imageDetail)
        val textDetailTitle: TextView = findViewById(R.id.textDetailTitle)
        val textSummary: TextView = findViewById(R.id.textSummary)
        val buttonOpenLink: Button = findViewById(R.id.buttonOpenLink)

        // 读取 MainActivity 传过来的数据
        val title = intent.getStringExtra("title") ?: "无标题"
        val summary = intent.getStringExtra("summary") ?: "无摘要"
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""
        val url = intent.getStringExtra("url") ?: ""

        textDetailTitle.text = title
        textSummary.text = summary
        imageDetail.load(imageUrl) {
            placeholder(R.drawable.bg_placeholder)
            error(R.drawable.bg_placeholder)
        }

        // 点击按钮后用浏览器打开原新闻链接
        buttonOpenLink.setOnClickListener {
            if (url.isNotBlank()) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            }
        }
    }
}
