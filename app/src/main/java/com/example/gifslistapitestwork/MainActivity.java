package com.example.gifslistapitestwork;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String IMAGE_MESSAGE = "com.example.IMG_MESSAGE";
    private ArrayList<GifElement> _listOfElements = null;
    RecyclerView _recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _recyclerView = findViewById(R.id.element_recycler_view);
        getDataFromApi();
    }

    public void showData(ArrayList<GifElement> listOfElements) {
        RecyclerView recyclerView = findViewById(R.id.element_recycler_view);
        GifElementAdapter gifElementAdapter = new GifElementAdapter(this, listOfElements);
        recyclerView.setAdapter(gifElementAdapter);
    }

    private void getDataFromApi() {//TODO?
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/v1/gifs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GifElementApi gifElementsApi = retrofit.create(GifElementApi.class);

        Call<Data> gifElements = gifElementsApi.getDataElements();

        gifElements.enqueue(new Callback <Data>() {

            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("TAG1","81 raw:" + response.raw());
                if (response.isSuccessful()) {
                    if( response.body().getGifElementsArray() != null ) {
                        showData(response.body().getGifElementsArray());
                    }
                } else {
                    Log.d("TAG1","ERROR! !response.isSuccessful() " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1","failure " + t);
            }
        });
    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void showOneImage(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra(IMAGE_MESSAGE, view.getTag().toString());
        startActivity(intent);
    }
}