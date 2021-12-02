package com.example.mymovie.ui.main;

import android.widget.Toast;

import com.example.mymovie.pojo.MyMovie;

import java.util.List;

public interface MoviView {
 void showData(List<MyMovie>myMovies);
  void showError();
}
