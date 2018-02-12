package org.buffer.android.boilerplate.ui.injection.module

import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.domain.interactor.browse.GetBufferoos
import org.buffer.android.boilerplate.presentation.browse.BrowseBufferoosContract
import org.buffer.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import org.buffer.android.boilerplate.presentation.main.MainContract
import org.buffer.android.boilerplate.presentation.main.MainPresenter
import org.buffer.android.boilerplate.presentation.mapper.BufferooMapper
import org.buffer.android.boilerplate.ui.MainActivity
import org.buffer.android.boilerplate.ui.browse.BrowseActivity
import org.buffer.android.boilerplate.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainContract.View {
        return mainActivity
    }

    @PerActivity
    @Provides
    internal fun provideMainPresenter(mainView: MainContract.View,
                                        getBufferoos: GetBufferoos):
            MainContract.Presenter {
        return MainPresenter(mainView, getBufferoos)
    }

}
