package com.example.anshultech.miwork;

/**
 * Created by AnshulTech on 10-Dec-17.
 */

public class word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mMusicResourceID;

    public word(String defaultTranslation, String miwokTranslation ,int musicResouceID){

        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mMusicResourceID= musicResouceID;

    }

        public word(String defaultTranslation, String miwokTranslation , int imageResourceID, int musicResouceID){

                mDefaultTranslation=defaultTranslation;
                mMiwokTranslation=miwokTranslation;
                mImageResourceID=imageResourceID;
            mMusicResourceID= musicResouceID;


        }

    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceID(){
        return mImageResourceID;
    }

    public  boolean hasImage(){
        return mImageResourceID!= NO_IMAGE_PROVIDED;

    }

    public int getmMusicResourceID(){return mMusicResourceID;}

}
