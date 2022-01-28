package com.jerrykel.fackeperson

import com.jerrykel.fackeperson.models.FakeGeneratorResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeProfileService {
    @GET(".")
    fun randomProfile(@Query("nat") lang:String):Call<FakeGeneratorResults>;
}