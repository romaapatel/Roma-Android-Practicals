package com.example.androidoverview

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_layout_example.btnConstraintLayout
import kotlinx.android.synthetic.main.activity_layout_example.btnFrameLayout
import kotlinx.android.synthetic.main.activity_layout_example.btnGridLayout
import kotlinx.android.synthetic.main.activity_layout_example.btnLinearExample
import kotlinx.android.synthetic.main.activity_layout_example.btnRelativeLayout
import kotlinx.android.synthetic.main.activity_layout_example.btnTableLayout

class LayoutExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_example)
        btnLinearExample.setOnClickListener {
            val linearIntent = Intent(this, SignInActivity::class.java)
            startActivity(linearIntent)
        }
        btnFrameLayout.setOnClickListener {
            makeDialog(R.layout.dialog_frame)
        }
        btnRelativeLayout.setOnClickListener {
            makeDialog(R.layout.dialog_relativelayout)
        }
        btnTableLayout.setOnClickListener{
            makeDialog(R.layout.dialog_tablelayout)
        }
        btnGridLayout.setOnClickListener{
            makeDialog(R.layout.dialog_gridlayoutexample)
        }
        btnConstraintLayout.setOnClickListener {
            makeDialog(R.layout.dialog_constrainlayoutexample)
        }
    }

    private fun makeDialog(layout: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(layout)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog.show()
    }
}