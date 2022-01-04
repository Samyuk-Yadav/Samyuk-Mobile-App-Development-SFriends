package uk.ac.tees.mad.w9519946;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class
APICovidUtilities {

    public static Retrofit retrofit = null;
    public static APICovidInterface getAPICovidInterface()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(APICovidInterface.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APICovidInterface.class);
    }




}
