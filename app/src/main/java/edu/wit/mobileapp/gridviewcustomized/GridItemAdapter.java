package edu.wit.mobileapp.gridviewcustomized;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * This class extends ArrayAdapter to create a personalized adapter
 * @author Samuel Hernandez
 */
public class GridItemAdapter extends ArrayAdapter {

    //Variable to hold inflater
    private final LayoutInflater myInflater;

    //Constructor creates object and initializes inflater
    public GridItemAdapter(Context context, int rid, List<GridItem> list) {
        super(context, rid, list);
        myInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    //This method overrides method in ArrayAdapter. Needs to be written since the grid view needs
    //to get the views of each item to display them. When it is called at any position it will
    //return a View Object, in this case the view object is the grid item.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridItem item = (GridItem) getItem(position);                    //Get the current item
        View view = myInflater.inflate(R.layout.grid_item, null);   //Inflate layout

        //Get the views for image, title and date. Set content to whatever is set in each item object.
        ImageView image = view.findViewById(R.id.image);
        image.setImageBitmap(item.getImage());
        TextView title = view.findViewById(R.id.title);
        title.setText(item.getTitle());
        TextView date = view.findViewById(R.id.date);
        date.setText(item.getDate());

        return view;
    }
}
