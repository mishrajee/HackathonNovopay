package com.novopay.hackathon.hackernewsclone.Provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by abhinava on 7/8/15.
 */
public class HackerDBHelper extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DATABASE_NAME = "myHackerDataBase";


    public HackerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public interface TABLE{
        //table to store favourite data
        String FAVOURITE = "favouriteTable";
        //table to store fetched data to be used when offline
        String OFFLINE = "offlineTable";
    }

    public interface FAVOURITE_COLOUMN {

        String NAME = "newsName";
        String POINTS = "newsPoints";
        String URL = "newsURL";
    }

    public interface OFFLINE_COLOUMN{

        String IS_FAV = "newsIsFav";
        String NAME = "newsName";
        String POINTS = "newsPoints";
        String URL = "newsURL";

    }

    final String CREATE_FAV_QUERY = "create table "+TABLE.FAVOURITE+" ("
            + BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +FAVOURITE_COLOUMN.NAME+" TEXT NOT NULL,"
            +FAVOURITE_COLOUMN.POINTS+" INTEGER,"
            +FAVOURITE_COLOUMN.URL+" TEXT NOT NULL);";

    final String CREATE_OFF_QUERY = "create table "+TABLE.OFFLINE+" ("
            +BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +OFFLINE_COLOUMN.IS_FAV+" INTEGER"
            +OFFLINE_COLOUMN.NAME+" TEXT NOT NULL,"
            +OFFLINE_COLOUMN.POINTS+" INTEGER,"
            +OFFLINE_COLOUMN.URL+" TEXT NOT NULL);";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FAV_QUERY);
        db.execSQL(CREATE_OFF_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
