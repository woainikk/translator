package com.example.woainikk.translator.repository;

import com.example.woainikk.translator.model.TranslateModelJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by woainikk on 29.04.18.
 */

public interface TranslatorApi {
    @GET("/api/v1.5/tr.json/translate")
    Call<TranslateModelJson> getData(@Query("key") String key, @Query("text") String text, @Query("lang") String lang);
}
