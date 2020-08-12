package com.instoriestest.task.ui.base

import android.view.View
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<V: MvpView>: MvpPresenter<V>() {

}