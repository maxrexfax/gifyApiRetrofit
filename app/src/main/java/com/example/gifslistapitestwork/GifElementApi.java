package com.example.gifslistapitestwork;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GifElementApi {
    @GET("search?api_key=YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL&q=deadpool&limit=25&offset=0&rating=g&lang=en")
    Call<Data> getDataElements();
}
