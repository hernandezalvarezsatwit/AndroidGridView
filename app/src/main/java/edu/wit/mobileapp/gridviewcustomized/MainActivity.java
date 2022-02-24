package edu.wit.mobileapp.gridviewcustomized;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This application runs a customized Grid View displaying Grid Items on the screen.
 * This is the MainActivity it creates the items that will be shown and calls necessary
 * classes to display them.
 * @author Samuel Hernandez
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Default code to initiate activity with main layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get placeholder default image
        Bitmap defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

        //Get current date
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String d = date.format(formatter);

        //Create and populate list with items
        List<GridItem> list = IntStream.rangeClosed(1, 24).mapToObj(i ->
                new GridItem(defaultImage, "Title-" + i, d)).collect(Collectors.toList());

        //Create the adapter, pass the list to it and set it to the gridview
        GridItemAdapter adapter = new GridItemAdapter(this, 0, list);
        GridView gridView = findViewById(R.id.myGridView);
        gridView.setAdapter(adapter);
    }
}