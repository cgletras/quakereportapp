package com.example.quakereport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quakereport.EarthQuakeReport;
import com.example.quakereport.R;

import java.util.List;

public class EarthquakeReportListItemAdapter extends ArrayAdapter<EarthQuakeReport> {
    public EarthquakeReportListItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public EarthquakeReportListItemAdapter(@NonNull Context context, @NonNull List<EarthQuakeReport> objects) {
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
        EarthQuakeReport currentItemOnList = getItem(position);

        // Select the views to be populated
        TextView magnitude = listItemView.findViewById(R.id.tv_magnitude);
        TextView city = listItemView.findViewById(R.id.tv_city);
        TextView date = listItemView.findViewById(R.id.tv_date);

        magnitude.setText(currentItemOnList.getmMagnitude().toString());
        city.setText(currentItemOnList.getmCity());
        date.setText(currentItemOnList.getDate());

        return listItemView;
    }
}
