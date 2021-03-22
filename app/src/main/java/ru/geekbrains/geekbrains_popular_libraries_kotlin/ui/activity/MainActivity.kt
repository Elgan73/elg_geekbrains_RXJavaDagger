package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.R
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ActivityMainBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackClickListener
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter.UsersRVAdapter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation.AndroidScreens


class MainActivity: MvpAppCompatActivity(), MainView {
    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackClickListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}





//
//class MainActivity : AppCompatActivity(), MainView {
//
//    private var vb: ActivityMainBinding? = null
//
//    val presenter = MainPresenter(this)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        vb = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(vb?.root)
//
//        vb?.btnCounter1?.setOnClickListener { presenter.counterClickOne() }
//        vb?.btnCounter2?.setOnClickListener { presenter.counterClickTwo() }
//        vb?.btnCounter3?.setOnClickListener { presenter.counterClickThree() }
//    }
//
//    override fun setButtonTextOne(text: String) {
//            vb?.btnCounter1?.text = text
//    }
//
//    override fun setButtonTextTwo(text: String) {
//            vb?.btnCounter2?.text = text
//    }
//
//    override fun setButtonTextThree(text: String) {
//            vb?.btnCounter3?.text = text
//    }
//
//}