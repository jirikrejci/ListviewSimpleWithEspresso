package com.jksoft.listviewsimplewithespresso.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.jksoft.listviewsimplewithespresso.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Jirka on 18.10.2016.
 */

public class LongListAdapter extends SimpleAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    public LongListAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }




/**
*
     * @param position pozice prvku
     * @param convertView viewGroup jedné položky
     * @param parent parent view
     * @see Adapter#getView(int, View, ViewGroup)
*/

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        final ToggleButton btnToggleButton = (ToggleButton) convertView.findViewById(R.id.tbItemToggleButton);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) v.findViewById (R.id.tvItemContent)).setText(String.valueOf(position));

            }
        });

        btnToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton toggleButton = (ToggleButton) v;
                if (toggleButton.getText().toString().equalsIgnoreCase("on")) {
                    toggleButton.setText("off");
                } else {
                    toggleButton.setText("on");
                }

            }
        });

        return super.getView(position, convertView, parent);
    }
}
