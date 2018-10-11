package com.example.desmond.newsapp;

import android.graphics.Bitmap;

public class News {
        private String mSectionName;
        private String mTilte;
        private String mAuthor;
        private String mTimeInMilliseconds;
        private String mUrl;
        private Bitmap mImageUrl;
        public News(String sectionName, String title, String author , String timeInMilliseconds, String url, Bitmap imageUrl) {
            mSectionName = sectionName;
            mTilte = title;
            mAuthor = author;
            mTimeInMilliseconds = timeInMilliseconds;
            mUrl = url;
            mImageUrl = imageUrl;
        }
        public String getSectionName() {
            return mSectionName;
        }
        public String getTitle() {
            return mTilte;
        }
        public String getAuthor() {
            return mAuthor;
        }
        public String getTimeInMilliseconds() {
            return mTimeInMilliseconds;
        }
        public String getUrl() {
            return mUrl;
        }
        public Bitmap getmImageUrl(){
            return mImageUrl;
        }
    }

