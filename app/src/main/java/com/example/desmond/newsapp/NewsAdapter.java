package com.example.desmond.newsapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
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
        if (currentNews.getAuthor()!=null) {
            TextView articleAuthor = (TextView) listItemView.findViewById(R.id.author);
            articleAuthor.setText(currentNews.getAuthor());
        }
        TextView articleSection = (TextView) listItemView.findViewById(R.id.section_name);
        articleSection.setText(currentNews.getSectionName());
        if (currentNews.getTimeInMilliseconds()!=null) {
            String originalLocation = currentNews.getTimeInMilliseconds();
            String date = null;
            String time = null;
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