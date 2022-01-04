package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityCovid extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CountryCodePicker countryCodePicker;
    String country;
    private List<ModelClass> modelListClass;
    private List<ModelClass> modelClassList1;
    Spinner spinner;
    PieChart mpiechart12;
    String[] types = {"deaths", "cases", "active" , "recovered"};
    TextView mfilter12;
    AdapterCovid adapter;
    private RecyclerView recyclerView12;
    TextView kactive, ktotal, krecovered, ktodayactive, ktodaytotal, ktodayrecovered, kdeaths, ktodaydeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_covid);

        countryCodePicker = findViewById(R.id.countrycodepicker11);
        ktodayactive = findViewById(R.id.todayactivecases12);
        kactive = findViewById(R.id.activecases12);
        kdeaths = findViewById(R.id.deaths1);
        ktodaydeaths = findViewById(R.id.todaydeaths12);
        krecovered = findViewById(R.id.recovered12);
        ktodayrecovered = findViewById(R.id.todayrecovered1);
        ktotal = findViewById(R.id.total);
        ktodaytotal = findViewById(R.id.totaltoday1);
        mpiechart12 = findViewById(R.id.chart_pie1);
        spinner = findViewById(R.id.spiinner1);
        mfilter12 = findViewById(R.id.filtering);
        recyclerView12 = findViewById(R.id.recyclerView);
        modelClassList1 = new ArrayList<>();
        modelListClass = new ArrayList<>();

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,types);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);


        APICovidUtilities.getAPICovidInterface().getcountrydata().enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                modelClassList1.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });

        adapter = new AdapterCovid(getApplicationContext(),modelClassList1);
        recyclerView12.setLayoutManager(new LinearLayoutManager(this));
        recyclerView12.setHasFixedSize(true);
        recyclerView12.setAdapter(adapter);

        countryCodePicker.setAutoDetectedCountry(true);
        country = countryCodePicker.getSelectedCountryName();
        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                country = countryCodePicker.getSelectedCountryName();
                datafetch();
            }
        });


        datafetch();


    }

    private void datafetch() {

        APICovidUtilities.getAPICovidInterface().getcountrydata().enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                modelListClass.addAll(response.body());
                for (int i=0; i<modelListClass.size(); i++){
                    if (modelListClass.get(i).getCountry().equals(country)){

                        int totalcovid, activecovid, deathscovid, recoveredcovid;

                        activecovid = Integer.parseInt(modelListClass.get(i).getActive());
                        totalcovid = Integer.parseInt(modelListClass.get(i).getCases());
                        recoveredcovid = Integer.parseInt(modelListClass.get(i).getRecovered());
                        deathscovid = Integer.parseInt(modelListClass.get(i).getDeaths());

                        kactive.setText(modelListClass.get(i).getActive());
                        ktodaydeaths.setText(modelListClass.get(i).getTodaydeaths());
                        ktodayrecovered.setText(modelListClass.get(i).getTodayrecovered());
                        ktodaytotal.setText(modelListClass.get(i).getTodaycases());
                        ktotal.setText(modelListClass.get(i).getCases());
                        kdeaths.setText(modelListClass.get(i).getDeaths());
                        krecovered.setText(modelListClass.get(i).getRecovered());


                        graphupdates(totalcovid, deathscovid, activecovid, recoveredcovid);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });
    }

    private void graphupdates(int totalcovid, int deathscovid, int activecovid, int recoveredcovid) {

        mpiechart12.clearChart();
        mpiechart12.addPieSlice(new PieModel("ActiveCovid", activecovid, Color.parseColor("#FF03DAC5")));
        mpiechart12.addPieSlice(new PieModel("TotalCovid", totalcovid, Color.parseColor("#fc03fc")));
        mpiechart12.addPieSlice(new PieModel("DeathCovid", deathscovid, Color.parseColor("#ff0400")));
        mpiechart12.addPieSlice(new PieModel("RecoveredCovid", recoveredcovid, Color.parseColor("#fcdb00")));
        mpiechart12.startAnimation();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = types[position];
        mfilter12.setText(item);
        adapter.filter(item);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}