package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.CountersModel
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainPresenter(val mainView: MainView) {
    val model = CountersModel()

    fun counterClickOne() {
        val nextValue = model.next(0)
        mainView.setButtonTextOne(nextValue.toString())
    }

    fun counterClickTwo() {
        val nextValue = model.next(1)
        mainView.setButtonTextTwo(nextValue.toString())
    }

    fun counterClickThree() {
        val nextValue = model.next(2)
        mainView.setButtonTextThree(nextValue.toString())
    }
}