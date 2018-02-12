package org.buffer.android.boilerplate.ui.display

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.buffer.android.boilerplate.ui.R
import android.content.Intent



class DisplayActivity : AppCompatActivity() {

    fun newIntent(context: Context): Intent {
        val intent = Intent(context, DisplayActivity::class.java)
        return intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
    }
}
