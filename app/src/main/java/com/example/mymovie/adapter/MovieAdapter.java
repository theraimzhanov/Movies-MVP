package com.example.mymovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymovie.R;
import com.example.mymovie.databinding.ListMovieBinding;
import com.example.mymovie.pojo.MyMovie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

List<MyMovie>list;
Context context;
ListMovieBinding binding;
Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setList(List<MyMovie> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public MovieAdapter(List<MyMovie> list,Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     binding = ListMovieBinding.inflate(LayoutInflater.from(context),parent,false);

        return new MovieViewHolder(binding.getRoot());


    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
  holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
       public MovieViewHolder(@NonNull View itemView) {
           super(itemView);
        imageView = itemView.findViewById(R.id.imageMovie);
      itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              listener.onClickListener(getAdapterPosition());
          }
      });
       }

        public void bind(MyMovie myMovie) {
            Glide.with(context).load(myMovie.getImage()).into(imageView);
            binding.movieTitle.setText(myMovie.getTitle());
            binding.movieDescribtion.setText(myMovie.getDescription());
            binding.movieDirector.setText(myMovie.getDirector());
            binding.movieProducer.setText(myMovie.getProducer());
            binding.movieReleaseDate.setText(myMovie.getReleaseDate());
        }
    }
}
