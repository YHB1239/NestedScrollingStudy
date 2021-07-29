package me.stefan.coordinatorlayoutstudy.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.stefan.coordinatorlayoutstudy.R

class CustomNestedChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_nested_child)
    }
}