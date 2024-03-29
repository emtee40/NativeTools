package com.dede.nativetools.network

import com.dede.nativetools.donate.DonateInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit service class
 *
 * Created by shhu on 2022/6/27 15:34.
 * @since 2022/6/27
 */
interface Api {

    // The default instance of [Api] with Retrofit proxy.
    companion object Default : Api by proxy

    @GET("fonts/-/raw/master/{fontName}")
    suspend fun downloadFont(@Path("fontName") fontName: String): InputStream

    // @GET("http://10.103.0.157:8000/donate_list.json")
    @GET("NativeTools/-/raw/develop/apis/donate_list.json")
    suspend fun getDonateList(): List<DonateInfo>
}

private val proxy by lazy {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit =
        Retrofit.Builder()
            .baseUrl("https://gitlab.com/hushenghao/")
            .addConverterFactory(StreamConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    retrofit.create(Api::class.java)
}

private val loadingObj by lazy { Any() }

fun <T> Result.Companion.loading(): Result<T> {
    @Suppress("UNCHECKED_CAST") return success(loadingObj) as Result<T>
}

val Result<*>.isLoading: Boolean
    get() = this.getOrNull() == loadingObj
