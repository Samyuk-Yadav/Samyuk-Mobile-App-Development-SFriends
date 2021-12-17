package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

import org.eazegraph.lib.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCovid extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CountryCodePicker countryCodePicker;
    String country;
    private List<ModelClass> modelClassList;
    private List<ModelClass> modelClassList1;
    Spinner spinner;
    PieChart mpiechart;
    String[] types = {"deaths", "cases", "active" , "recovered"};
    TextView mfilter;
    Adapter adapter;
    private RecyclerView recyclerView;
    TextView mactive, mtotal, mrecovered, mtodayactive, mtodaytotal, mtodayrecovered, mdeaths, mtodaydeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_covid);

        getSupportActionBar().hide();
        countryCodePicker = findViewById(R.id.ccp);
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
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item);







    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}