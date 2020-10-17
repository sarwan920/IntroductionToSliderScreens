package com.thefuturestic.introslider.FragmentsCclass

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroPageTransformerType
import com.thefuturestic.introslider.HomeActivity
import com.thefuturestic.introslider.ScreenOne
import com.thefuturestic.introslider.ScreenTwo
import com.thefuturestic.introslider.ScreenThree

class CustomIntro : AppIntro2() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE)
        if (pref.getBoolean("activity_executed", false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val ed: SharedPreferences.Editor = pref.edit()
            ed.putBoolean("activity_executed", true)
            ed.commit()
        }

        setTransformer(AppIntroPageTransformerType.Fade)
        isIndicatorEnabled = true
        setProgressIndicator()

        addSlide(ScreenOne())
        addSlide(ScreenTwo())
        addSlide(ScreenThree())
    }

    //skip button code , this code help you to skip rest of screens
    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }

    //this is when all screens are done and you are good to go for home screem
    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }
}