package uk.ac.tees.mad.w9519946;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface
APICovidInterface {
    String URL_BASE = "https://corona.lmao.ninja/v2/";

    @GET("countries")
    Call<List<ModelClass>> getcountrydata();




}
