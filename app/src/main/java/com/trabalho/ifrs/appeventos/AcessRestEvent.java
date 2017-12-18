package com.trabalho.ifrs.appeventos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marcos on 11/12/2017.
 */

public interface AcessRestEvent {

    @GET("events")
    Call<List<Event>> getEvents();
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ServicoREST/rest/")
            .addConverterFactory(GsonConverterFactory.create()).build();
}
