package me.stefan.coordinatorlayoutstudy.custom

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_custom_behavior.*
import me.stefan.coordinatorlayoutstudy.R

class CustomBehaviorActivity : AppCompatActivity(), View.OnTouchListener {
    private var rawX = 0
    private var rawY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_behavior)
        tv_observed.setOnTouchListener(this)
    }

    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
        when(view?.id){
            R.id.tv_observed -> {
                when(motionEvent?.action){
                    MotionEvent.ACTION_DOWN -> {
                        rawX = motionEvent.rawX.toInt()
                        rawY = motionEvent.rawY.toInt()
                    }
                    MotionEvent.ACTION_MOVE -> {
                        val x = motionEvent.rawX.toInt()
                        val y = motionEvent.rawY.toInt()
                        val dx = x - rawX
                        val dy = y - rawY
                        val l: Int = tv_observed.left
                        val r: Int = tv_observed.right
                        val t: Int = tv_observed.top
                        val b: Int = tv_observed.bottom
                        tv_observed.layout(l + dx, t + dy, r + dx, b + dy)
                        rawX = motionEvent.rawX.toInt()
                        rawY = motionEvent.rawY.toInt()
                    }
                    MotionEvent.ACTION_UP -> {}
                }
            }
        }
        return true
    }

}