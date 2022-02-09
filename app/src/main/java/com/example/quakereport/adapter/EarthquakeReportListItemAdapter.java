package com.example.quakereport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quakereport.R;
import com.example.quakereport.classes.Earthquake;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeReportListItemAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeReportListItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public EarthquakeReportListItemAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if view is being reused
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false
            );
        }

        // get current item on list
        Earthquake currentItemOnList = getItem(position);

        // Select the views to be populated
        TextView magnitude = listItemView.findViewById(R.id.tv_magnitude);
        TextView city = listItemView.findViewById(R.id.tv_city);
        TextView date = listItemView.findViewById(R.id.tv_date);
        TextView time = listItemView.findViewById(R.id.tv_time);

        // Populate views and convert time values from milliseconds to date and time
        //Populate MAG
        magnitude.setText(currentItemOnList.getMag()+"");

        // Populate Location
        city.setText(currentItemOnList.getPlace());

        // Populate and convert DATE
        Date dateObject = new Date(currentItemOnList.getTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        date.setText(dateToDisplay);

        // Populate and convert TIME
        SimpleDateFormat timeFormatter = new SimpleDateFormat("KK:mm aa");
        String timeToDisplay = timeFormatter.format(dateObject);
        time.setText(timeToDisplay);

        return listItemView;
    }
}
