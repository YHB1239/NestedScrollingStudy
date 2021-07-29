package me.stefan.coordinatorlayoutstudy.custom

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_custom_nested_parent.*
import kotlinx.android.synthetic.main.layout_common_toolbar.*
import me.stefan.coordinatorlayoutstudy.R
import me.stefan.coordinatorlayoutstudy.adapter.BaseFragmentItemAdapter
import java.util.*

class CustomNestedParentActivity : AppCompatActivity(){
    val FRAGMENT_COUNT = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_nested_parent)
        initData()
    }

    private fun initData() {
        viewpager.adapter = BaseFragmentItemAdapter(supportFragmentManager, initFragments(), initTitles())
        tab.setupWithViewPager(viewpager)
        sick_layout.setScrollChangeListener {
            initToolBar(R.drawable.ic_action_back_white, it)
        }
    }

    private fun initToolBar(@DrawableRes backResId: Int, moveRatio: Float) {
        iv_back.setOnClickListener { finish() }
        val argbEvaluator = ArgbEvaluator()
        val color = argbEvaluator.evaluate(moveRatio, Color.WHITE, Color.BLACK) as Int
        val wrapDrawable = ContextCompat.getDrawable(this, backResId)
        DrawableCompat.setTint(wrapDrawable!!, color)
        iv_back.setImageDrawable(wrapDrawable)
        tv_title.alpha = moveRatio
    }

    private fun initFragments(): List<Fragment>? {
        val fragments: MutableList<Fragment> = ArrayList<Fragment>()
        for (i in 0 until FRAGMENT_COUNT) {
            fragments.add(TabFragment.newInstance("NestedScrolling2Demo"))
        }
        return fragments
    }

    private fun initTitles(): List<String>? {
        val titles: MutableList<String> = ArrayList()
        titles.add("首页")
        titles.add("全部")
        titles.add("作者")
        titles.add("专辑")
        return titles
    }
}