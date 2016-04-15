package com.qcdn.mymvpdemo.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wsh on 2016/3/22.
 */
public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private List<String> lists;

    public WeatherAdapter(Context context, List<String> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setPadding(30, 10, 10, 10);
        textView.setTextSize(15f);
        textView.setText(lists.get(position));
        return textView;
    }
}
