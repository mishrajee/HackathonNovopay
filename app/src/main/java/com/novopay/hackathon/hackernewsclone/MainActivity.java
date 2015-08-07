package com.novopay.hackathon.hackernewsclone;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.novopay.hackathon.hackernewsclone.Model.Collection1;
import com.novopay.hackathon.hackernewsclone.Model.HackerAPIRResponse;
import com.novopay.hackathon.hackernewsclone.Networking.HackerAPI;
import com.novopay.hackathon.hackernewsclone.Provider.HackerDBHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    ListView news_list_view;
    private List<Collection1> collection;
    private HackerDBHelper hackerDBHelper;
    private SQLiteDatabase db;
    private Cursor mainCursor;
    private HackerAPI.HackerInterface hackerInterface;
    private NewsAdapter newsAdapter;
    Button favourite_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        news_list_view=(ListView) findViewById(R.id.listView);


        collection = new ArrayList<Collection1>();


        hackerInterface = HackerAPI.getAPI();

        hackerInterface.getNewsList(new Callback<HackerAPIRResponse>() {
            @Override
            public void success(HackerAPIRResponse hackerAPIRResponse, Response response) {
                Log.d("std", "success");
                collection.addAll(hackerAPIRResponse.getResults().getCollection1());
                newsAdapter = new NewsAdapter(MainActivity.this, collection);
                news_list_view.setAdapter(newsAdapter);
                news_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.d("MainActivity", "On item clicked");
                        Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
                         intent.putExtra("UrlName",collection.get(position).getNewsName().getHref());
                        startActivity(intent);
                    }
                });


            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("std", "Failure in retrieving data from internet");

            }
        });

//        news_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("MainActivity","On item clicked");
//                Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
//                intent.putExtra("UrlName",collection.get(position).getNewsName().getHref());
//                startActivity(intent);
//            }
//        });


    }

    public void myFavouriteButtonClickHandler(View v){

        RelativeLayout r_layout=(RelativeLayout) v.getParent();
        //v.setBackgroundColor(Color.parseColor("FFD00D"));
        Button btnChild = (Button)r_layout.getChildAt(2);
        btnChild.setBackgroundColor(Color.RED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else
        {
            if(id==R.id.action_favourite_list)
            {
                Intent intent=new Intent(MainActivity.this,FavouriteActivity.class);
                startActivity(intent);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
