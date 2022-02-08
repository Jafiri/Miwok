package Classes;

import android.media.MediaPlayer;

public class WordClass {

     private String mDefaultLanguage;
    private String mMiwokLanguage;
    private int mImageResource = NO_IMAGE_PROVIDED;
    private int mMediaResource;
    private static final int NO_IMAGE_PROVIDED =-1;

    public WordClass(String mDefaultLanguage, String mMiwokLanguage, int mImageResource, int mMediaResource) {
        this.mDefaultLanguage = mDefaultLanguage;
        this.mMiwokLanguage = mMiwokLanguage;
        this.mImageResource = mImageResource;
        this.mMediaResource = mMediaResource;
    }

    public WordClass(String mDefaultLanguage, String mMiwokLanguage, int mMediaResource) {
        this.mDefaultLanguage = mDefaultLanguage;
        this.mMiwokLanguage = mMiwokLanguage;
        this.mMediaResource = mMediaResource;
    }

    public String getmDefaultLanguage() {
        return mDefaultLanguage;
    }

    public String getmMiwokLanguage() {
        return mMiwokLanguage;
    }

    public int getmImageResource() {
        return mImageResource;
    }
    public int getmMediaResource() {
        return mMediaResource;
    }

    public boolean hasImage(){
        return mImageResource != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "WordClass{" +
                "mDefaultLanguage='" + mDefaultLanguage + '\'' +
                ", mMiwokLanguage='" + mMiwokLanguage + '\'' +
                ", mImageResource=" + mImageResource +
                ", mMediaResource=" + mMediaResource +
                '}';
    }
}
