package com.example.androidoverview.fragmentExample

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.activity_fragment_example.drawerLayoutFragment

class FragmentExampleActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)

        toggle = ActionBarDrawerToggle(this@FragmentExampleActivity, drawerLayoutFragment, R.string.open, R.string.close)
        drawerLayoutFragment.addDrawerListener(toggle)
        toggle.syncState()
        replaceFragment(QuizGameMainPage(), R.string.quiz_name.toString())
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayoutFragment, fragment).commit()
        setTitle(title)
    }
}