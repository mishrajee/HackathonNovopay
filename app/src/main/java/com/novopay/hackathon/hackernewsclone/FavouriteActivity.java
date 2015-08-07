package com.novopay.hackathon.hackernewsclone;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import com.novopay.hackathon.hackernewsclone.Model.OfflineNews;
import com.novopay.hackathon.hackernewsclone.Provider.HackerDBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinmaykrishna on 07/08/15.
 */
public class FavouriteActivity extends ActionBarActivity{
    ListView favouritelistView;
    private List<OfflineNews> collection = new ArrayList<OfflineNews>();

    SQLiteOpenHelper hackerDBHelper;
    private SQLiteDatabase db;

    Cursor mainCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        favouritelistView=(ListView) findViewById(R.id.favourite_listView);
        hackerDBHelper = new HackerDBHelper(FavouriteActivity.this);
        db = hackerDBHelper.getReadableDatabase();

        OfflineNews offlineNews = new OfflineNews("","","",false);

        mainCursor = db.rawQuery("select * from "+ HackerDBHelper.TABLE.FAVOURITE,null);
        if(mainCursor.moveToFirst()){
            do{

                offlineNews.setNewsName(mainCursor.getString(mainCursor.getColumnIndex(HackerDBHelper.FAVOURITE_COLOUMN.NAME)));
                offlineNews.setNewsUrl(mainCursor.getString(mainCursor.getColumnIndex(HackerDBHelper.FAVOURITE_COLOUMN.URL)));
                offlineNews.setPoints(mainCursor.getString(mainCursor.getColumnIndex(HackerDBHelper.FAVOURITE_COLOUMN.POINTS)));
                offlineNews.setIsFav(true);
                collection.add(offlineNews);
                Log.d("db", "Value of name in fav is " + mainCursor.getString(mainCursor.getColumnIndex(HackerDBHelper.OFFLINE_COLOUMN.NAME)));

            }while(mainCursor.moveToNext());
        }

        OfflineNewsAdapter offlineNewsAdapter = new OfflineNewsAdapter(FavouriteActivity.this,collection);
        favouritelistView.setAdapter(offlineNewsAdapter);

        //favouritelistView.setOnItemClickListener(new );



    }
}
