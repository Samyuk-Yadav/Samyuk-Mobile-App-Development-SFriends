package uk.ac.tees.mad.w9519946;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.text.HtmlCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity_Complete_location extends AppCompatActivity {

    Button locationMe;
    TextView latitude4Current, text5View5,longitude6Current, text7View7, text8View8;
    FusedLocationProviderClient fusedLocationProvider12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_complete_location);

        locationMe = findViewById(R.id.Get_my_complete_location);
        latitude4Current = findViewById(R.id.text4View4);
        text5View5 = findViewById(R.id.text5View5);
        text8View8 = findViewById(R.id.text8View8);
        longitude6Current = findViewById(R.id.text6View6);
        text7View7 = findViewById(R.id.text7View7);



        fusedLocationProvider12 = LocationServices.getFusedLocationProviderClient(this);

        locationMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity_Complete_location.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(MainActivity_Complete_location.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //  Todo: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProvider12.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geo = new Geocoder(MainActivity_Complete_location.this, Locale.getDefault());
                        List<Address> addresses = geo.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        latitude4Current.setText(HtmlCompat.fromHtml(
                                "<font color = #6200EE><b>Latitude: </b><br><?font>" +addresses.get(0).getLatitude(), HtmlCompat.FROM_HTML_MODE_LEGACY
                        ));
                        longitude6Current.setText(HtmlCompat.fromHtml("<font color = '#6200EE'><b>Longitude: </b><br></font>"+addresses.get(0).getLongitude(), HtmlCompat.FROM_HTML_MODE_LEGACY));
                        text5View5.setText(HtmlCompat.fromHtml("<font color = '#6200EE'><b>Country Name: </b><br></font>"+addresses.get(0).getCountryName(), HtmlCompat.FROM_HTML_MODE_LEGACY));
                        text7View7.setText(HtmlCompat.fromHtml("<font color = '#6200EE'><b>Locality: </b><br></font>"+addresses.get(0).getLocality(), HtmlCompat.FROM_HTML_MODE_LEGACY));
                        text8View8.setText(HtmlCompat.fromHtml("<font color = '#6200EE'><b>Address Line: </b><br></font>"+addresses.get(0).getAddressLine(0),HtmlCompat.FROM_HTML_MODE_LEGACY));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}