package com.example.mymovie.ui.main;

import com.example.mymovie.data.remove.RetrofitBuilder;
import com.example.mymovie.pojo.MyMovie;
import com.example.mymovie.ui.main.MoviView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MoviView view;

    public MainPresenter(MoviView view) {
        this.view = view;
    }

    public void LoadData(){
      RetrofitBuilder.getService().getAllMovies().enqueue(new Callback<List<MyMovie>>() {
          @Override
          public void onResponse(Call<List<MyMovie>> call, Response<List<MyMovie>> response) {
                    view.showData(response.body());
          }

          @Override
          public void onFailure(Call<List<MyMovie>> call, Throwable t) {
          view.showError();
          }
      });
  }
}

