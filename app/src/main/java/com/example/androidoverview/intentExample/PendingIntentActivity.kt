package com.example.androidoverview.intentExample

import android.app.AlarmManager
import android.app.PendingIntent.FLAG_CANCEL_CURRENT
import android.app.PendingIntent.getBroadcast
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androidoverview.R
import com.example.androidoverview.adapter.BottomNavigationAdapter
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.activity_pending_intent.bottomNavBar
import kotlinx.android.synthetic.main.activity_pending_intent.btnEnterTime
import kotlinx.android.synthetic.main.activity_pending_intent.viewPagerExercise

class PendingIntentActivity : AppCompatActivity() {
    var time: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_intent)

        btnEnterTime.setOnClickListener {
            val intent = Intent(this@PendingIntentActivity, RecieverIntentClass::class.java)
            val pendingIntent = getBroadcast(this@PendingIntentActivity, Constant.ZERO, intent, FLAG_CANCEL_CURRENT)
            val alarm = getSystemService(ALARM_SERVICE) as AlarmManager
            alarm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (Constant.THOUSAND * time), pendingIntent)
        }
        refreshViewPager()
        setBottomNavigation()
        setViewPagerAdapter()
    }

    private fun setBottomNavigation() {
        bottomNavBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.galleryMenu -> viewPagerExercise.currentItem = Constant.ZERO
                R.id.addMsgMenu -> viewPagerExercise.currentItem = Constant.ONE
                R.id.viewMsgMenu -> viewPagerExercise.currentItem = Constant.TWO
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun refreshViewPager() {
        val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    Constant.ZERO -> bottomNavBar.menu.findItem(R.id.galleryMenu).isChecked = true
                    Constant.ONE -> bottomNavBar.menu.findItem(R.id.addMsgMenu).isChecked = true
                    Constant.TWO -> bottomNavBar.menu.findItem(R.id.viewMsgMenu).isChecked = true
                }
            }
        }
        viewPagerExercise.registerOnPageChangeCallback(pageChangeCallback)
    }

    private fun setViewPagerAdapter() {
        viewPagerExercise.adapter = BottomNavigationAdapter(supportFragmentManager, lifecycle)
    }
}