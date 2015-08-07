package com.novopay.hackathon.hackernewsclone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by chinmaykrishna on 07/08/15.
 */
public class FavouriteActivity extends ActionBarActivity{
    ListView favouritelistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        favouritelistView=(ListView) findViewById(R.id.favourite_listView);
    }
}
