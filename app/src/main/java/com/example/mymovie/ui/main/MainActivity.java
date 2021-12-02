package com.example.mymovie.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mymovie.R;
import com.example.mymovie.adapter.MovieAdapter;
import com.example.mymovie.pojo.MyMovie;
import com.example.mymovie.ui.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MoviView {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    List<MyMovie> list;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        presenter = new MainPresenter(this);
        presenter.LoadData();
    }

    public void showData(List<MyMovie> myMovies) {
        adapter.setList(myMovies);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"You have some errors",Toast.LENGTH_SHORT).show();
    }


    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();
        adapter = new MovieAdapter(list, this);
    }


}