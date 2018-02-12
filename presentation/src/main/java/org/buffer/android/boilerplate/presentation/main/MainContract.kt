package org.buffer.android.boilerplate.presentation.main

import org.buffer.android.boilerplate.domain.model.Bufferoo
import org.buffer.android.boilerplate.presentation.BasePresenter
import org.buffer.android.boilerplate.presentation.BaseView
import org.buffer.android.boilerplate.presentation.model.BufferooView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

        fun showResult(bufferoo: List<Bufferoo>)

    }

    interface Presenter : BasePresenter {

        fun callResponse()

    }

}