package com.example.ecomerceshoppe.retrofix;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    private static Retrofit instance;
     public static Retrofit getInstance(String url) {
          if(instance==null) {
              instance = new Retrofit.Builder()
                      .baseUrl(url)
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                      .build();


          }

          return instance;
    }
}
