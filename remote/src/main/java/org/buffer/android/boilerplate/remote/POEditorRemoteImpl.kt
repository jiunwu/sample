package org.buffer.android.boilerplate.remote

import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.BufferooEntity
import org.buffer.android.boilerplate.data.repository.BufferooRemote
import org.buffer.android.boilerplate.data.repository.POEditorProjectRemote
import org.buffer.android.boilerplate.remote.mapper.BufferooEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class POEditorRemoteImpl @Inject constructor(private val poeditorService: POEditorService) :
        POEditorProjectRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getProjects(): Single<String> {
        return poeditorService.getPorject()
                .map {
                    it.toString()
                }
    }

}