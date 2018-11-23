package service

import entity.PhraseResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhraseService {
    @GET("jokes/{id}")
    fun fetchRandomPhrase(@Path("id") quantity : Int) : Call<PhraseResultEntity>
}