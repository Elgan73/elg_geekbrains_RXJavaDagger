package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.geekbrains.geekbrains_popular_libraries_kotlin.R
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ActivityMainBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null

    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener { presenter.counterClickOne() }
        vb?.btnCounter2?.setOnClickListener { presenter.counterClickTwo() }
        vb?.btnCounter3?.setOnClickListener { presenter.counterClickThree() }
    }

    override fun setButtonTextOne(text: String) {
            vb?.btnCounter1?.text = text
    }

    override fun setButtonTextTwo(text: String) {
            vb?.btnCounter2?.text = text
    }

    override fun setButtonTextThree(text: String) {
            vb?.btnCounter3?.text = text
    }

}