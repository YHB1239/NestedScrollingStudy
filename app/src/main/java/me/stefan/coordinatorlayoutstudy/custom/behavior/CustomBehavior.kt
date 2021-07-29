package me.stefan.coordinatorlayoutstudy.custom.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class CustomBehavior: CoordinatorLayout.Behavior<View> {
    private val TAG = javaClass.simpleName

    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is TextView || super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        // 根据要依赖的x坐标，更改当前控件的X坐标
        child.x = parent.width - dependency.x - dependency.width
        child.y = dependency.y
        Log.i(TAG, "onDependentViewChanged: dependencyView: height -> ${dependency.height} width -> ${dependency.width} left -> ${dependency.left} top -> ${dependency.top} right -> ${dependency.right} bottom -> ${dependency.bottom}")
        Log.i(TAG, "onDependentViewChanged: child: height -> ${child.height} width -> ${child.width} left -> ${child.left} top -> ${child.top} right -> ${child.right} bottom -> ${child.bottom}")
        return super.onDependentViewChanged(parent, child, dependency)
    }
}