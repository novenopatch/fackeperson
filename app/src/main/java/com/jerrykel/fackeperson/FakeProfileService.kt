package com.jerrykel.fackeperson

import com.jerrykel.fackeperson.models.FakeGeneratorResults
import retrofit2.Call
import retrofit2.http.GET

interface FakeProfileService {
    @GET(".")
    fun randomProfile():Call<FakeGeneratorResults>;
}