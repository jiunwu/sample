package org.buffer.android.boilerplate.data

import io.reactivex.Completable
import io.reactivex.Single
import org.buffer.android.boilerplate.data.mapper.BufferooMapper
import org.buffer.android.boilerplate.data.model.BufferooEntity
import org.buffer.android.boilerplate.data.source.BufferooDataStoreFactory
import org.buffer.android.boilerplate.data.source.BufferooRemoteDataStore
import org.buffer.android.boilerplate.data.source.POEditorDataStoreFactory
import org.buffer.android.boilerplate.domain.model.Bufferoo
import org.buffer.android.boilerplate.domain.repository.BufferooRepository
import org.buffer.android.boilerplate.domain.repository.POEditorRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
 * data sources
 */
class POEditorDataRepository @Inject constructor(private val factory: POEditorDataStoreFactory) :
        POEditorRepository {
    override fun getProject(): Single<String> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getPorject().map {
            it
        }
    }

    override fun clearBufferoos(): Completable {
        return Completable.complete()
    }

    override fun saveBufferoos(bufferoos: List<Bufferoo>): Completable {
        return Completable.complete()
    }

    private fun saveBufferooEntities(bufferoos: List<BufferooEntity>): Completable {
        return Completable.complete()
    }


}