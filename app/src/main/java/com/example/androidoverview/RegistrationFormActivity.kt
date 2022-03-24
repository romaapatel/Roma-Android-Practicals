package com.example.androidoverview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_registration_form.btnCustomToast
import kotlinx.android.synthetic.main.activity_registration_form.btnSubmit
import kotlinx.android.synthetic.main.activity_registration_form.cbDancing
import kotlinx.android.synthetic.main.activity_registration_form.cbPainting
import kotlinx.android.synthetic.main.activity_registration_form.cbReading
import kotlinx.android.synthetic.main.activity_registration_form.cbSinging
import kotlinx.android.synthetic.main.activity_registration_form.etEmail
import kotlinx.android.synthetic.main.activity_registration_form.etName
import kotlinx.android.synthetic.main.activity_registration_form.imageButtonGender
import kotlinx.android.synthetic.main.activity_registration_form.rgGender
import kotlinx.android.synthetic.main.activity_registration_form.toggleButton

class RegistrationFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)
        var userDetail: String
        toggleButton.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        btnSubmit.setOnClickListener {
            when (rgGender.checkedRadioButtonId) {
                R.id.rbMale -> {
                    imageButtonGender.setImageResource(R.drawable.male)
                }
                R.id.rbFemale -> {
                    imageButtonGender.setImageResource(R.drawable.female)
                }
            }
            if (cbDancing.isChecked) {
                Toast.makeText(this, cbDancing.text, Toast.LENGTH_SHORT).show()
            }
            if (cbPainting.isChecked) {
                Toast.makeText(this, cbPainting.text, Toast.LENGTH_SHORT).show()
            }
            if (cbReading.isChecked) {
                Toast.makeText(this, cbReading.text, Toast.LENGTH_SHORT).show()
            }
            if (cbSinging.isChecked) {
                Toast.makeText(this, cbSinging.text, Toast.LENGTH_SHORT).show()
            }
          userDetail = String.format(getString(R.string.welcome_to_simform, etName.text.toString() ))+ "\n" +
                    String.format(getString(R.string.your_email_is), etEmail.text.toString())
        }
        val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast))
        btnCustomToast.setOnClickListener {
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                view = layout
            }.show()
        }
    }
}