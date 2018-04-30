package com.example.woainikk.translator.interactor;

import com.example.woainikk.translator.model.TranslateModel;
import com.example.woainikk.translator.model.TranslateModelJson;
import com.example.woainikk.translator.repository.TranslatorApi;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by woainikk on 29.04.18.
 */

public class DoTranslateInteractor {

    private static TranslatorApi sTranslatorApi;
    private Retrofit retrofit;

    public DoTranslateInteractor() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sTranslatorApi = retrofit.create(TranslatorApi.class);
    }


    public TranslateModel getAnswerTranslate(String word, String languages) {
        try {
            TranslateModel translationInfo = new TranslateModel();
            Response<TranslateModelJson> response = sTranslatorApi
                    .getData("trnsl.1.1.20180324T165001Z.898f85a4f411b333.ea8deb61604ca18ca90d6dd7fe5acda46980f77b"
                            , word, languages)
                    .execute();

            translationInfo.setWord(word);
            translationInfo.setLanguageFrom(response.body().getLang().split("-")[0]);
            translationInfo.setLanguageTo(response.body().getLang().split("-")[1]);
            translationInfo.setTranslatedWord(response.body().getText()[0]);
            return translationInfo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
