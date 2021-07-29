package me.stefan.coordinatorlayoutstudy.custom.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class CustomBehavior2: CoordinatorLayout.Behavior<View> {
    private val TAG = javaClass.simpleName

    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        Log.i(TAG, "layoutDependsOn: ")
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        // 根据要依赖的x坐标，更改当前控件的X坐标
        child.x = (parent.width / 2 - child.width / 2).toFloat()
        child.y = (parent.height / 2 - child.height / 2).toFloat()
        Log.i(TAG, "onDependentViewChanged: dependencyView: height -> ${dependency.height} width -> ${dependency.width} left -> ${dependency.left} top -> ${dependency.top} right -> ${dependency.right} bottom -> ${dependency.bottom}")
        Log.i(TAG, "onDependentViewChanged: child: height -> ${child.height} width -> ${child.width} left -> ${child.left} top -> ${child.top} right -> ${child.right} bottom -> ${child.bottom}")
        return super.onDependentViewChanged(parent, child, dependency)
    }

    override fun onNestedScrollAccepted(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int) {
        Log.i(TAG, "onNestedScrollAccepted: ")
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        Log.i(TAG, "onStartNestedScroll: ")
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Log.i(TAG, "onNestedPreScroll: ")
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        Log.i(TAG, "onNestedScroll: ")
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, type: Int) {
        Log.i(TAG, "onStopNestedScroll: ")
        super.onStopNestedScroll(coordinatorLayout, child, target, type)
    }
}