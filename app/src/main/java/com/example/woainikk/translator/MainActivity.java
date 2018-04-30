package com.example.woainikk.translator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.woainikk.translator.presentation.presenter.TranslateOnClick;

import lombok.Data;

@Data
public class MainActivity extends AppCompatActivity {


    private TextView mTranslatedWord;
    private TextView mLanguageTranslateFrom;
    private TextView mLanguageTranslateTo;
    private EditText mWordToTranslate;
    private Button mChangeLanguagesButton;
    private Button mTranslateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMembers();

        mTranslateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TranslateOnClick getResultOnClick = new TranslateOnClick();
                getResultOnClick.translateOnClick(mLanguageTranslateTo, mLanguageTranslateFrom, mTranslatedWord, getWordToTranslate());

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);


            }
        });


        mChangeLanguagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguagesOnButtonClick();
            }
        });


    }

    private void changeLanguagesOnButtonClick() {
        if (mLanguageTranslateFrom.getText() == MainActivity.this.getString(R.string.russianLanguage)) {
            mLanguageTranslateFrom.setText(R.string.englishLanguage);
            mLanguageTranslateTo.setText(R.string.russianLanguage);

        } else {
            mLanguageTranslateFrom.setText(R.string.russianLanguage);
            mLanguageTranslateTo.setText(R.string.englishLanguage);
        }
    }

    private void initMembers() {
        mTranslatedWord = findViewById(R.id.tranclatedWord);
        mLanguageTranslateFrom = findViewById(R.id.languafeTranslateFrom);
        mLanguageTranslateTo = findViewById(R.id.languageTranslateTo);
        mWordToTranslate = findViewById(R.id.wordToTranslate);
        mChangeLanguagesButton = findViewById(R.id.changelanguageseButton);
        mTranslateButton = findViewById(R.id.translateButton);
        mLanguageTranslateFrom.setText(R.string.russianLanguage);
        mLanguageTranslateTo.setText(R.string.englishLanguage);

    }

    public TextView getLanguageTranslateFrom() {
        return mLanguageTranslateFrom;
    }

    public TextView getLanguageTranslateTo() {
        return mLanguageTranslateTo;
    }

    public TextView getTranslatedWord() {
        return mTranslatedWord;
    }

    public EditText getWordToTranslate() {
        return mWordToTranslate;
    }


}
