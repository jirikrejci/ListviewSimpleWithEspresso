package com.jksoft.listviewsimplewithespresso.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jksoft.listviewsimplewithespresso.R;
import com.jksoft.listviewsimplewithespresso.adapters.LongListAdapter;
import com.jksoft.listviewsimplewithespresso.data.DataSource;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // ziskani dat
        DataSource dataSource = new DataSource();
        List<Map<String, Object>> mData = dataSource.getData();

        // vytvoreni a aplikace adapteru
        String [] from = new String[] {DataSource.HASH_MAP_ITEM_TEXT, DataSource.HASH_MAP_ITEM_ENABLED};
        int [] to = new int[] {R.id.tvItemContent, R.id.tbItemToggleButton};
        SimpleAdapter adapter = new LongListAdapter(this, mData, R.layout.list_item, from, to);

        listView.setAdapter(adapter);


    }
}
