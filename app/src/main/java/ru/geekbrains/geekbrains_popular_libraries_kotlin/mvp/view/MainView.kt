package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView



//interface MainView {
//    fun setButtonTextOne(text: String)
//    fun setButtonTextTwo(text: String)
//    fun setButtonTextThree(text: String)
//}