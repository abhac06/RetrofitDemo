package com.example.abha.retrofitdemo.helper;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ABHA on 01-10-2017.
 */

public class Animals {

    @SerializedName("name")
    private String Name;

    @SerializedName("species")
    private String Species;

    public String getName() {
        return Name;
    }

    public String getSpecies() {
        return Species;
    }
}
