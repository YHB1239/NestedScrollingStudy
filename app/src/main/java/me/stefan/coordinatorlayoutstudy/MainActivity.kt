package me.stefan.coordinatorlayoutstudy

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.stefan.coordinatorlayoutstudy.basic.BasicUseActivity
import me.stefan.coordinatorlayoutstudy.custom.CustomActivity
import me.stefan.coordinatorlayoutstudy.custom.CustomBehaviorActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        bt_basic_use.setOnClickListener {
            goToActivity(BasicUseActivity::class.java)
        }
        bt_custom.setOnClickListener {
            goToActivity(CustomActivity::class.java)
        }
    }


}