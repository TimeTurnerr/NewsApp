package com.example.desmond.newsapp;
public class News {
        private String mSectionName;
        private String mTilte;
        private String mAuthor;
        private String mTimeInMilliseconds;
        private String mUrl;
        public News(String sectionName, String title, String author ,String timeInMilliseconds, String url) {
            mSectionName = sectionName;
            mTilte = title;
            mAuthor = author;
            mTimeInMilliseconds = timeInMilliseconds;
            mUrl = url;
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
    }

