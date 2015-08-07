package com.novopay.hackathon.hackernewsclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.novopay.hackathon.hackernewsclone.Model.Collection1;
import com.novopay.hackathon.hackernewsclone.Model.OfflineNews;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by abhinava on 7/8/15.
 */
public class OfflineNewsAdapter extends BaseAdapter {

    WeakReference<Context> context;
    private List<OfflineNews> collection;

    private class ViewHolder {
        TextView newsName;
        TextView newsPoints;
        Button favouriteButton;
    }

    public OfflineNewsAdapter(Context context, List<OfflineNews> collection){
        this.context=new WeakReference<Context>(context);
        this.collection = collection;
    }




    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public OfflineNews getItem(int position) {
        return collection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context.get());
            view = layoutInflater.inflate(R.layout.news_item_view,parent,false);

            viewHolder = new ViewHolder();

            viewHolder.favouriteButton = (Button) view.findViewById(R.id.favourite_button);
            viewHolder.newsName = (TextView) view.findViewById(R.id.news_name_view);
            viewHolder.newsPoints = (TextView) view.findViewById(R.id.news_upvotes_view);

            view.setTag(viewHolder);

        }

        if(viewHolder ==null){
            viewHolder = (ViewHolder)view.getTag();
        }

        OfflineNews singleCollection = getItem(position);
        viewHolder.newsPoints.setText(singleCollection.getPoints());
        viewHolder.newsName.setText(singleCollection.getNewsName());

        //logic for showing fav button is here


        return view;
    }
}
