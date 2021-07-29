package me.stefan.coordinatorlayoutstudy.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_collapsing_toolbar_layout.*
import me.stefan.coordinatorlayoutstudy.R
import me.stefan.coordinatorlayoutstudy.adapter.ListAdapter

class CollapsingToolbarLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_layout)
        val dataList = arrayOf("哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈", "哈哈哈")
        val adapter = ListAdapter(this, dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}