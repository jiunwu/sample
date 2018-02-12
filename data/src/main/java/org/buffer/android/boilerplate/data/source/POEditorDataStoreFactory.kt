package org.buffer.android.boilerplate.data.source

import org.buffer.android.boilerplate.data.repository.BufferooCache
import org.buffer.android.boilerplate.data.repository.BufferooDataStore
import org.buffer.android.boilerplate.data.repository.POEditorDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class POEditorDataStoreFactory @Inject constructor(
        private val poEditorRemoteDataStore: POEditorRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): POEditorDataStore {
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): POEditorDataStore {
        return poEditorRemoteDataStore
    }

}