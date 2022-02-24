package edu.wit.mobileapp.gridviewcustomized;

import android.graphics.Bitmap;

/**
 * This object represents each individual grid item
 * @author Samuel Hernandez
 */
public class GridItem {

    private final Bitmap image;
    private final String title;
    private final String date;

    public GridItem(Bitmap image, String title, String date) {
        this.image = image;
        this.title = title;
        this.date = date;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
