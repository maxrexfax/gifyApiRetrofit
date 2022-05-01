package com.example.gifslistapitestwork;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GifElementAdapter extends RecyclerView.Adapter<GifElementAdapter.ViewHolder> {

        Context _context;
        private final LayoutInflater _inflater;
        private final List<GifElement> _gifElements;

        GifElementAdapter(Context context, List<GifElement> gifElements) {
                this._gifElements = gifElements;
                this._inflater = LayoutInflater.from(context);
                this._context = context;
        }

        @Override
        public GifElementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = _inflater.inflate(R.layout.gif_element_view, parent, false);
                return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GifElementAdapter.ViewHolder holder, int position) {
                GifElement element = _gifElements.get(position);
                URL url = null;
                try {
                        url = new URL(element.getImages().getOriginal().getUrl());
                } catch (MalformedURLException e) {
                        Log.d("TAG1", "CATCH" + e.getMessage() );
                }
                holder.titleView.setText(element.getTitle());
                holder.relativeLayout.setTag(url);
                try {
                        setImageInImageView(holder, url);
                } catch (Exception e) {
                        Log.d("TAG1", "CATCH" + e.getMessage() );
                }
        }

        public void setImageInImageView(GifElementAdapter.ViewHolder holder, URL urlIn) {
                Runnable r = new Runnable()
                {
                        @Override
                        public void run()
                        {
                                try {
                                        Glide.with(_context).load(urlIn).into(new DrawableImageViewTarget(holder.gifView));
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                };

                Thread t = new Thread(r);
                t.start();
        }

        @Override
        public int getItemCount() {
                return _gifElements.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
                final ImageView gifView;
                final TextView titleView;
                final RelativeLayout relativeLayout;
                ViewHolder(View view){
                        super(view);
                        gifView = view.findViewById(R.id.gif_image_view);
                        titleView = view.findViewById(R.id.title_text_view);
                        relativeLayout = view.findViewById(R.id.relative_container);
                }
        }
}
