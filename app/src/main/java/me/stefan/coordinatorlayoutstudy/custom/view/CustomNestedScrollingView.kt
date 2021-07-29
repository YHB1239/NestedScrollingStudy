package me.stefan.coordinatorlayoutstudy.custom.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.view.NestedScrollingChild3
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.ViewCompat


class CustomNestedScrollingView: View, NestedScrollingChild3 {
    private val TAG = javaClass.simpleName

    private var mScrollingChildHelper = NestedScrollingChildHelper(this)

    private val mScrollOffset = IntArray(2)
    private val mScrollConsumed = IntArray(2)

    private var rawX = 0
    private var rawY = 0
    private var mLastX = 0
    private var mLastY = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setNestedScrollingEnabled(true)
    }

    override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {
        var result = false
        when(motionEvent?.action){
            MotionEvent.ACTION_DOWN -> {
                rawX = motionEvent.rawX.toInt()
                rawY = motionEvent.rawY.toInt()
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL, ViewCompat.TYPE_TOUCH)
                result = super.onTouchEvent(motionEvent)
                Log.i(TAG, "onTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                var deltaY= (rawY - y).toInt()
                var deltaX = (rawX - x).toInt()
                if (dispatchNestedPreScroll(deltaX, deltaY, mScrollConsumed, mScrollOffset, ViewCompat.TYPE_TOUCH)) {
                    deltaX -= mScrollConsumed[0]
                    deltaY -= mScrollConsumed[1]
                    scrollTo(mScrollOffset[0], mScrollOffset[1])
                    rawX += mScrollOffset[0]
                    rawY += mScrollOffset[1]
                }
                val oldY = scrollY
                mLastY = (y - mScrollOffset[1]).toInt()
                mLastX = (x - mScrollOffset[0]).toInt()
                result = super.onTouchEvent(motionEvent)
                Log.i(TAG, "onTouchEvent: ACTION_MOVE")
            }
            MotionEvent.ACTION_UP -> {
                stopNestedScroll(ViewCompat.TYPE_TOUCH)
                result = super.onTouchEvent(motionEvent)
                Log.i(TAG, "onTouchEvent: ACTION_UP")
            }
        }
        Log.i(TAG, "onTouchEvent: result -> $result")
        return true
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        offsetInWindow: IntArray?,
        type: Int,
        consumed: IntArray
    ) {
        Log.i(TAG, "dispatchNestedScroll: ")
        mScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed)
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        offsetInWindow: IntArray?,
        type: Int
    ): Boolean {
        Log.i(TAG, "dispatchNestedScroll: ")
        return mScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type)
    }

    override fun dispatchNestedPreScroll(
        dx: Int,
        dy: Int,
        consumed: IntArray?,
        offsetInWindow: IntArray?,
        type: Int
    ): Boolean {
        Log.i(TAG, "dispatchNestedPreScroll: ")
        return mScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)
    }

    override fun stopNestedScroll(type: Int) {
        Log.i(TAG, "stopNestedScroll: ")
        mScrollingChildHelper.stopNestedScroll(type)
    }

    override fun hasNestedScrollingParent(type: Int): Boolean {
        Log.i(TAG, "hasNestedScrollingParent: ")
        return mScrollingChildHelper.hasNestedScrollingParent(type)
    }

    override fun startNestedScroll(axes: Int, type: Int): Boolean {
        Log.i(TAG, "startNestedScroll: ")
        return mScrollingChildHelper.startNestedScroll(axes, type)
    }

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        mScrollingChildHelper.isNestedScrollingEnabled = enabled
    }
}