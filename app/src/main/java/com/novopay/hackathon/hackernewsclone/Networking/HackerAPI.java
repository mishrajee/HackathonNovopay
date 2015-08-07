package com.novopay.hackathon.hackernewsclone.Networking;

import com.novopay.hackathon.hackernewsclone.Model.HackerAPIRResponse;

import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by abhinava on 7/8/15.
 */
public class HackerAPI {

    private static final String URL ="https://www.kimonolabs.com/api";
    private static HackerInterface hackerInterface = null;

    public static HackerInterface getAPI(){
        if(hackerInterface==null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(URL)
                    .build();
            hackerInterface = restAdapter.create(HackerInterface.class);
        }
        return hackerInterface;
    }

    public interface HackerInterface{

        @GET("/7no4biyy?apikey=84SdVb8c8BnG2Ao8IXBSPWJIWi3sCx4f")
        HackerAPIRResponse getMusicList();

        @GET("/7no4biyy?apikey=84SdVb8c8BnG2Ao8IXBSPWJIWi3sCx4f")
        void getMusicList(retrofit.Callback<HackerAPIRResponse> hackerAPIRResponseCallback);

    }



}
