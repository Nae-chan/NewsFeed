package com.example.danae.project6;

import android.content.Context;

import java.text.ParseException;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * This {@link NewsItemAdapter} knows how to create a list item layout for each newsItem
 * in the data source (a list of {@link NewsItem} objects).
 * These list item layouts will be displayed in the list_item ListView
 */

public class NewsItemAdapter extends ArrayAdapter<NewsItem> {

    /**
     * Constructs a new {@link NewsItemAdapter}.
     *
     * @param context   of the app
     * @param newsItems is the list of newsItems, which is the data source of the adapter
     */
    public NewsItemAdapter(Context context, List<NewsItem> newsItems) {
        super(context, 0, newsItems);
    }

    /**
     * Returns a list item view that displays the news story at the given position
     * in the list of newsItems.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the newsItem at the given position in the list of newsItems
        NewsItem currentNewsItem = getItem(position);

        // Find the TextView with view ID category
        TextView categoryView = listItemView.findViewById(R.id.category);
        // Display the category of the current newsItem in that TextView
        categoryView.setText(currentNewsItem.getCategory());

        // Find the TextView with view ID title
        TextView titleView = listItemView.findViewById(R.id.title);
        // Display the title of the current newsItem in that TextView
        titleView.setText(currentNewsItem.getTitle());

        // Find the TextView with view ID Date
        TextView dateView = listItemView.findViewById(R.id.date);

        // Format the date string
        String formattedDate = formatDate(currentNewsItem.getDate());

        // Display the date of the current newsItem in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID author
        TextView authorView = listItemView.findViewById(R.id.author);

        // Display the author of the current newsItem in that TextView

        String authorFromJson = currentNewsItem.getAuthor();

        if (authorFromJson == null) {
            authorView.setVisibility(View.GONE);
        } else {
            authorView.setText(authorFromJson);
        }


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    public String formatDate(String date) {

        //Create SimpleDateFormat object matching the pattern in response
        final SimpleDateFormat dateFormatter =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
                        Locale.getDefault());
        //Set date_out to null, attempt to parse date or catch ParseException
        Date date_out = null;
        try {
            date_out = dateFormatter.parse(date);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        //Format date into abbreviated date pattern
        final SimpleDateFormat outputFormatter =
                new SimpleDateFormat("MMM dd ''yy", Locale.US);
        //Return Formatted Date
        return outputFormatter.format(date_out);
    }

}