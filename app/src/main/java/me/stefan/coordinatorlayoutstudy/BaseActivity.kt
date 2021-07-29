package me.stefan.coordinatorlayoutstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    protected fun goToActivity(targetPage: Class<*>) {
        startActivity(Intent(this, targetPage))
    }
}