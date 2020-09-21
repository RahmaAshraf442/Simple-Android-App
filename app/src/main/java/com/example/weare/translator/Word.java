package com.example.weare.translator;

public class Word {
    private String english_word;
    private String arabic_word;
    private int image_source;
    private int audio_source;

    public Word(String english , String arabic , int image_source ,int audio_source){
        this.english_word = english;
        this.arabic_word = arabic;
        this.image_source=image_source;
        this.audio_source= audio_source;
    }

    public Word(String english , int image_source ,String arabic ){
        this.english_word = english;
        this.arabic_word = arabic;
        this.image_source=image_source;
    }

    public int getAudio_source() {
        return audio_source;
    }

    public Word(String english_word, String arabic_word , int audio_source ) {
        this.english_word = english_word;
        this.arabic_word = arabic_word;
        this.audio_source= audio_source;
    }

    public String getEnglish_word(){
        return  english_word;
    }

    public void setEnglish_word(String english_word) {
        this.english_word = english_word;
    }

    public void setArabic_word(String arabic_word) {
        this.arabic_word = arabic_word;
    }

    public int getImage_source() {
        return image_source;
    }


    public String getArabic_word(){
        return arabic_word;
    }
}
