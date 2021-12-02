package com.example.mymovie.data.remove;

import com.example.mymovie.pojo.MyMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
@GET("films")
    Call<List<MyMovie>>getAllMovies();
}
//https://ghibliapi.herokuapp.com/films