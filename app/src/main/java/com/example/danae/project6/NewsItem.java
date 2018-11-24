package com.example.danae.project6;

/**
 * A {@link NewsItem} object contains information related to a single news story.
 */
public class NewsItem {

    /**
     * Category of the newsItem
     */
    private String mCategory;

    /**
     * Title of the newsItem
     */
    private String mTitle;

    /**
     * Date of the newsItem
     */
    private String mDate;

    /**
     * Website URL of the newsItem
     */
    private String mUrl;

    /**
     * Author of the newsItem
     */
    private String mAuthor;

    /**
     * Constructs a new {@link NewsItem} object.
     *
     * @param category is the type of news story
     * @param title    is the Title of the news story
     * @param date     is the first line in the story
     * @param url      is the website URL to the full story
     * @param author   is the author of the news story
     */
    public NewsItem(String category, String title, String date, String url, String author) {
        mCategory = category;
        mTitle = title;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }

    /**
     * Returns the category of the story.
     */
    public String getCategory() {
        return mCategory;
    }

    /**
     * Returns the title of the story.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the headline of the story.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the website URL to find the rest of the story.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the author of the story.
     */
    public String getAuthor() {
        return mAuthor;
    }
}
