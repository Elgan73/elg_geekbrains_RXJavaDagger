package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}


//class MainPresenter(val mainView: MainView) {
//    val model = CountersModel()
//
//    fun counterClickOne() {
//        val nextValue = model.next(0)
//        mainView.setButtonTextOne(nextValue.toString())
//    }
//
//    fun counterClickTwo() {
//        val nextValue = model.next(1)
//        mainView.setButtonTextTwo(nextValue.toString())
//    }
//
//    fun counterClickThree() {
//        val nextValue = model.next(2)
//        mainView.setButtonTextThree(nextValue.toString())
//    }
//}