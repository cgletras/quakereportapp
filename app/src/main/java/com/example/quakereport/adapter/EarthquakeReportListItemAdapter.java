package com.example.quakereport.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.quakereport.R;
import com.example.quakereport.classes.Earthquake;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeReportListItemAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeReportListItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public EarthquakeReportListItemAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
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
        TextView km = listItemView.findViewById(R.id.tv_km);
        TextView city = listItemView.findViewById(R.id.tv_city);
        TextView date = listItemView.findViewById(R.id.tv_date);
        TextView time = listItemView.findViewById(R.id.tv_time);

        // Format MAG color
        Drawable background = magnitude.getBackground();
        ((GradientDrawable) background).setColor(getMagnitudeColor(currentItemOnList.getMag()));

        // Populate views and convert time values from milliseconds to date and time

        //Populate MAG

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String magnitudeFormatted = magnitudeFormat.format(currentItemOnList.getMag());
        magnitude.setText(magnitudeFormatted);


        // Populate Location (KM and CITY)
        String location = currentItemOnList.getPlace();
        Integer stringLoc = 0;
        String kmValueOrNear = "Not available";
        String cityName = "Not available";
        String splitStringWord = " of ";

        if (!location.contains(splitStringWord)) {
            kmValueOrNear = "Near";
        } else {
            stringLoc = (location.indexOf(splitStringWord)) + 3;
            kmValueOrNear = location.substring(0, stringLoc);
        }
        cityName = location.substring(stringLoc).trim();
        km.setText(kmValueOrNear);
        city.setText(cityName);

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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}


