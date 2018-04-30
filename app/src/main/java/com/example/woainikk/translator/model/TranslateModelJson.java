package com.example.woainikk.translator.model;

/**
 * Created by woainikk on 29.04.18.
 */


public class TranslateModelJson {
    private String[] text;

    private String code;

    private String lang;

    public String[] getText ()
    {
        return text;
    }

    public void setText (String[] text)
    {
        this.text = text;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    @Override
    public String toString()
    {
        return "TranslateModelJson [text = "+text+", code = "+code+", lang = "+lang+"]";
    }
}
