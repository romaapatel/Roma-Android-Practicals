package com.example.androidoverview

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.viewPager
import kotlinx.android.synthetic.main.activity_whats_app_uiactivity.tabLayout
import kotlinx.android.synthetic.main.activity_whats_app_uiactivity.whatsappViewPager

class WhatsAppUIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats_app_uiactivity)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar)
        toolbar.overflowIcon?.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
        toolbar.title = getString(R.string.whatsapp)
        setSupportActionBar(toolbar)

        val adapter = WhatsAppUIAdapter(supportFragmentManager,lifecycle)
        whatsappViewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = getString(R.string.chats_ui)
                }
                1 -> {
                    tab.text = getString(R.string.status_ui)
                }
                2 -> {
                    tab.text = getString(R.string.calls_ui)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
}