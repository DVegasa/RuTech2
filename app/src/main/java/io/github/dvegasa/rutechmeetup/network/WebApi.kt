package io.github.dvegasa.rutechmeetup.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ed Khalturin @DVegasa
 */
interface WebApi {
    companion object {
        fun create(): WebApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://62.109.28.67:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WebApi::class.java)
        }
    }
}