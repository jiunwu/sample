package org.buffer.android.boilerplate.data.source

import io.reactivex.Completable
import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.BufferooEntity
import org.buffer.android.boilerplate.data.repository.BufferooDataStore
import org.buffer.android.boilerplate.data.repository.BufferooRemote
import org.buffer.android.boilerplate.data.repository.POEditorDataStore
import org.buffer.android.boilerplate.data.repository.POEditorProjectRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class POEditorRemoteDataStore @Inject constructor(private val poeditorRemote: POEditorProjectRemote) :
        POEditorDataStore {
    override fun getPorject(): Single<String> {
        return poeditorRemote.getProjects()
    }

    override fun clearBufferoos(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        throw UnsupportedOperationException()
    }


}