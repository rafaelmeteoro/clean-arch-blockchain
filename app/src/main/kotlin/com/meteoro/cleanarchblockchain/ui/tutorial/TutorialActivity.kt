package com.meteoro.cleanarchblockchain.ui.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meteoro.cleanarchblockchain.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
    }
}
