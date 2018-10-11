package com.example.desmond.newsapp;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
public class NewsAdapter extends ArrayAdapter<News> {
    private static final String DATETIME_SEPARATOR = "T";
    public NewsAdapter(Context context, List<News> earthquakes) {
        super(context, 0, earthquakes);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        News currentNews = getItem(position);
        TextView articleTitle = (TextView) listItemView.findViewById(R.id.title);
        articleTitle.setText(currentNews.getTitle());
        TextView firstName = (TextView) listItemView.findViewById(R.id.fistName);
        TextView lastName = (TextView) listItemView.findViewById(R.id.lastName);
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);
        imageView.setImageBitmap(currentNews.getmImageUrl());
        if (currentNews.getAuthor()!=null)
        {
            TextView articleAuthor = (TextView) listItemView.findViewById(R.id.author);
            articleAuthor.setText(currentNews.getAuthor());
            String authorName = currentNews.getAuthor();
            Character firstInitial = Character.toUpperCase(authorName.charAt(0));
            int lastIndex = authorName.lastIndexOf(" ");
            Character lastInitial = Character.toUpperCase(authorName.charAt(lastIndex + 1));
            firstName.setText(firstInitial.toString());
            lastName.setText(lastInitial.toString());
        }
        else {
            firstName.setText("N/");
            lastName.setText("A");
        }
        TextView articleSection = (TextView) listItemView.findViewById(R.id.section_name);
        articleSection.setText(currentNews.getSectionName());
        if (currentNews.getTimeInMilliseconds()!=null) {
            String originalLocation = currentNews.getTimeInMilliseconds();
            String date = null;
            String time = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            try {
                Date date2 = formatter.parse(originalLocation.replaceAll("Z$", "+0000"));
                System.out.println(date2);
                System.out.println("time zone : " + TimeZone.getDefault().getID());
                System.out.println(formatter.format(date2));
                Log.e("Date", String.valueOf(date2));

            } catch (ParseException e) {
                e.printStackTrace();
            }
                if (originalLocation.contains(DATETIME_SEPARATOR)) {

                    String[] parts = originalLocation.split(DATETIME_SEPARATOR);
                    time = parts[1];
                    date = parts[0];
                }
            TextView articleDate = (TextView) listItemView.findViewById(R.id.date);
            articleDate.setText(date);
            TextView articleTime = (TextView) listItemView.findViewById(R.id.time);
            articleTime.setText(time);
        }
        return listItemView;
    }
}