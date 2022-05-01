package com.example.gifslistapitestwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {
    public static final String IMAGE_MESSAGE = "com.example.IMG_MESSAGE";
    private Context _context;

    ImageView _imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        this._context = this;
    }

    @Override
    public void onStart() {
        super.onStart();
        _imageView = findViewById(R.id.image_view_big);
        Intent intent = getIntent();
        URL url = null;
        try {
            url = new URL(intent.getStringExtra(IMAGE_MESSAGE));
            setImageInImageView(url);
        } catch (Exception e) {
            Log.d("TAG1", "CATCH" + e.getMessage() );
        }
    }

    public void setImageInImageView(URL urlIn) {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    Glide.with(_context).load(urlIn).into(new DrawableImageViewTarget(_imageView));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}