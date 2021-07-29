package me.stefan.coordinatorlayoutstudy.custom

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_common_list.*
import me.stefan.coordinatorlayoutstudy.BaseActivity
import me.stefan.coordinatorlayoutstudy.R
import me.stefan.coordinatorlayoutstudy.adapter.ListAdapter

class CustomActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_list)
        initView()
    }

    private fun initView() {
        val dataList = arrayOf("CustomBehaviorActivity", "CustomNestedParentActivity", "CustomNestedChildActivity")
        val adapter = ListAdapter(this, dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setOnClickListener(object : ListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, textContent: String) {
                when (textContent) {
                    dataList[0] -> {
                        goToActivity(CustomBehaviorActivity::class.java)
                    }
                    dataList[1] -> {
                        goToActivity(CustomNestedParentActivity::class.java)
                    }
                    dataList[2] -> {
                        goToActivity(CustomNestedChildActivity::class.java)
                    }
                    else -> {
                    }
                }
            }

        })
    }
}