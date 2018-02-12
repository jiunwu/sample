package org.buffer.android.boilerplate.remote

import io.reactivex.Single
import okhttp3.ResponseBody
import org.buffer.android.boilerplate.remote.model.BufferooModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the POEditor API
 */
interface POEditorService {

    @GET("projects/list")
    fun getPorject(): Single<Response<ResponseBody>>

    class BufferooResponse { //TODO change to project Response
        lateinit var team: List<BufferooModel>
    }

}
