package org.buffer.android.boilerplate.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import org.buffer.android.boilerplate.domain.model.Bufferoo

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 */
interface POEditorRepository {

    fun clearBufferoos(): Completable

    fun saveBufferoos(bufferoos: List<Bufferoo>): Completable

    fun getProject(): Single<String>

}