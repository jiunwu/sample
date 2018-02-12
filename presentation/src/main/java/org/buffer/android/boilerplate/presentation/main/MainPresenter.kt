package org.buffer.android.boilerplate.presentation.main

import io.reactivex.observers.DisposableSingleObserver
import org.buffer.android.boilerplate.domain.interactor.SingleUseCase
import org.buffer.android.boilerplate.domain.model.Bufferoo
import org.buffer.android.boilerplate.presentation.mapper.BufferooMapper
import javax.inject.Inject

class MainPresenter @Inject constructor(val mainView: MainContract.View,
                                                   val getBufferoosUseCase: SingleUseCase<List<Bufferoo>, Void>):
        MainContract.Presenter {
    override fun callResponse() {
        getBufferoosUseCase.execute(BufferooSubscriber())
    }

    init {
        mainView.setPresenter(this)
    }

    override fun start() {
        callResponse()
    }

    override fun stop() {
        getBufferoosUseCase.dispose()
    }


    internal fun handleGetBufferoosSuccess(bufferoos: List<Bufferoo>) {
        mainView.hideErrorState()

        mainView.showResult(bufferoos)

        if (bufferoos.isNotEmpty()) {
            mainView.hideEmptyState()
            //mainView.showBufferoos(bufferoos.map { bufferooMapper.mapToView(it) })


        } else {
            mainView.showEmptyState()
        }
    }

    inner class BufferooSubscriber: DisposableSingleObserver<List<Bufferoo>>() {

        override fun onSuccess(t: List<Bufferoo>) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
            mainView.hideEmptyState()
            mainView.showErrorState()
        }

    }

}