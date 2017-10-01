package com.example.abha.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.abha.retrofitdemo.helper.Animals;
import com.example.abha.retrofitdemo.helper.ApiClient;
import com.example.abha.retrofitdemo.helper.ApiInterface;
import com.example.abha.retrofitdemo.helper.RecyclerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Animals> animals;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // making a retrofit request for retrieving data
        // first get the instance of retrofit
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // now that we have the interface instance, call the appropriate method from the interface
        // save the method return type in a Call class instance
        Call<List<Animals>> call = apiInterface.getAnimals();

        // retrieve the retrofit data in the onResponse method
        call.enqueue(new Callback<List<Animals>>() {
            @Override
            public void onResponse(Call<List<Animals>> call, Response<List<Animals>> response) {

                Log.d(TAG, "onResponse: " + response.toString());
                // result is stored in a list of type Animals
                animals = response.body();
                if (animals != null) {
                    Log.d(TAG, "onResponse: " + animals.toString());
                }
                // set data in the recyclerview
                adapter = new RecyclerAdapter(MainActivity.this, animals);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Animals>> call, Throwable t) {

            }
        });
    }
}
