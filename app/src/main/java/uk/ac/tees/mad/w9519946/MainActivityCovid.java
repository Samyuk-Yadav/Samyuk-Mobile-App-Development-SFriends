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
    private List<ModelClass> modelClassList;
    private List<ModelClass> modelClassList1;
    Spinner spinner;
    PieChart mpiechart;
    String[] types = {"deaths", "cases", "active" , "recovered"};
    TextView mfilter;
    AdapterCovid adapter;
    private RecyclerView recyclerView;
    TextView mactive, mtotal, mrecovered, mtodayactive, mtodaytotal, mtodayrecovered, mdeaths, mtodaydeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_covid);

//        getSupportActionBar().hide();
        countryCodePicker = findViewById(R.id.countrycodepicker);
        mtodayactive = findViewById(R.id.todayactivecases);
        mactive = findViewById(R.id.activecases);
        mdeaths = findViewById(R.id.deaths);
        mtodaydeaths = findViewById(R.id.todaydeaths);
        mrecovered = findViewById(R.id.recovered);
        mtodayrecovered = findViewById(R.id.todayrecovered);
        mtotal = findViewById(R.id.total);
        mtodaytotal = findViewById(R.id.totaltoday);
        mpiechart = findViewById(R.id.chart_pie);
        spinner = findViewById(R.id.spiinner);
        mfilter = findViewById(R.id.filtering);
        recyclerView = findViewById(R.id.recyclerView);
        modelClassList = new ArrayList<>();
        modelClassList1 = new ArrayList<>();

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

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
                modelClassList.addAll(response.body());
                for (int i=0; i<modelClassList.size(); i++){
                    if (modelClassList.get(i).getCountry().equals(country)){

                        int totalcovid, activecovid, deathscovid, recoveredcovid;

                        activecovid = Integer.parseInt(modelClassList.get(i).getActive());
                        totalcovid = Integer.parseInt(modelClassList.get(i).getCases());
                        recoveredcovid = Integer.parseInt(modelClassList.get(i).getRecovered());
                        deathscovid = Integer.parseInt(modelClassList.get(i).getDeaths());

                        mactive.setText(modelClassList.get(i).getActive());
                        mtodaydeaths.setText(modelClassList.get(i).getTodaydeaths());
                        mtodayrecovered.setText(modelClassList.get(i).getTodayrecovered());
                        mtodaytotal.setText(modelClassList.get(i).getTodaycases());
                        mtotal.setText(modelClassList.get(i).getCases());
                        mdeaths.setText(modelClassList.get(i).getDeaths());
                        mrecovered.setText(modelClassList.get(i).getRecovered());


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

        mpiechart.clearChart();
        mpiechart.addPieSlice(new PieModel("ActiveCovid", activecovid, Color.parseColor("#FF03DAC5")));
        mpiechart.addPieSlice(new PieModel("TotalCovid", totalcovid, Color.parseColor("#fc03fc")));
        mpiechart.addPieSlice(new PieModel("DeathCovid", deathscovid, Color.parseColor("#ff0400")));
        mpiechart.addPieSlice(new PieModel("RecoveredCovid", recoveredcovid, Color.parseColor("#fcdb00")));
        mpiechart.startAnimation();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = types[position];
        mfilter.setText(item);
        adapter.filter(item);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}