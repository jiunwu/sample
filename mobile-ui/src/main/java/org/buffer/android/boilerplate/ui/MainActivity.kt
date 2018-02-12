package org.buffer.android.boilerplate.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.intro_text
import kotlinx.android.synthetic.main.activity_main.text_input
import org.buffer.android.boilerplate.domain.model.Bufferoo
import org.buffer.android.boilerplate.presentation.browse.BrowseBufferoosContract
import org.buffer.android.boilerplate.presentation.main.MainContract
import org.buffer.android.boilerplate.presentation.main.MainContract.Presenter
import org.buffer.android.boilerplate.presentation.model.BufferooView
import org.buffer.android.boilerplate.ui.display.DisplayActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun showResult(bufferoo: List<Bufferoo>) {
        Log.i("result: " , "Size is " + bufferoo.size)
    }

    @Inject
    lateinit var onboardingPresenter: MainContract.Presenter

    override fun showProgress() {
        Log.i("State", "Show Progress")
    }

    override fun hideProgress() {
        Log.i("State", "Hide Progress")
    }

    override fun showErrorState() {
        Log.i("ERROR", "Show Error State")
    }

    override fun hideErrorState() {
        Log.i("ERROR", "Hide Error State")
    }

    override fun showEmptyState() {
        Log.i("State", "Show Empty State")
    }

    override fun hideEmptyState() {
        Log.i("State", "Hide Empty State")
    }

    override fun setPresenter(presenter: Presenter) {
        onboardingPresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        onboardingPresenter.start()
        val actionBar = getSupportActionBar()
        actionBar?.hide()

        intro_text.text = "POEditor Saga"

        button.setOnClickListener{
            if(text_input.text.toString().isBlank()){
                Log.i("get text", "empty")
            }else{
                Log.i("get text", text_input.text.toString())
                val intent = Intent(this, DisplayActivity::class.java)
                startActivity(intent)
            }
        }

    }

}
