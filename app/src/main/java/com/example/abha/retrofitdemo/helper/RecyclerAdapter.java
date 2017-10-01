package com.example.abha.retrofitdemo.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abha.retrofitdemo.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by ABHA on 01-10-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Animals> animals = Collections.emptyList();
    private Context context;
    private final LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<Animals> animals) {
        this.context = context;
        this.animals = animals;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Animals currentAnimal = animals.get(position);

        holder.tvName.setText(animals.get(position).getName());
        holder.tvSpecies.setText(animals.get(position).getSpecies());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvSpecies;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);

        }
    }
}
