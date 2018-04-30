package com.example.woainikk.translator.presentation.presenter;

import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

import com.example.woainikk.translator.MainActivity;
import com.example.woainikk.translator.interactor.DoTranslateInteractor;
import com.example.woainikk.translator.model.TranslateModel;

/**
 * Created by woainikk on 29.04.18.
 */

public class TranslateOnClick {


    public void translateOnClick(TextView languageTranslatedTo, TextView languageTranslatefrom,
                                 final TextView translatedWord, final EditText wordToTranslate) {


        final String languages = languageTranslatefrom.getText() + "-" + languageTranslatedTo.getText();

        final DoTranslateInteractor doTranslate = new DoTranslateInteractor();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final TranslateModel answerTranslate = doTranslate.getAnswerTranslate(wordToTranslate.getText().toString(), languages);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        translatedWord.setText(answerTranslate.getTranslatedWord());

                    }
                });


            }
        }).start();

    }

}
