package com.example.intencjedomniemane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button wwwButton = findViewById(R.id.buttonWWW);
        wwwButton.setOnClickListener(view -> {
            EditText www = findViewById(R.id.www);
            String address = www.getText().toString();
            Uri uri = Uri.parse("http://"+address);

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button cityButton = findViewById(R.id.buttonCity);
        cityButton.setOnClickListener(view -> {
            EditText city = findViewById(R.id.city);
            String cityString = city.getText().toString();

            Uri uri = Uri.parse("geo:0,0?q="+cityString);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button cordsButton = findViewById(R.id.buttonCords);
        cordsButton.setOnClickListener(view -> {
            EditText longitudeEdit = findViewById(R.id.longitude);
            EditText latitudeEdit = findViewById(R.id.latitude);
            String latitude = latitudeEdit.getText().toString();
            String longitude = longitudeEdit.getText().toString();

            // sprawdzam, czy podano prawidłowe dane
            try{
                Double.parseDouble(latitude);
                Double.parseDouble(longitude);
            }catch (NumberFormatException e){
                return;
            }




            String uriString = String.format("geo:%s,%s", latitude, longitude);
            Uri uri = Uri.parse(uriString);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button alarmButton = findViewById(R.id.buttonAlarm);
        alarmButton.setOnClickListener(view -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, 12);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, 43);
            startActivity(intent);
        });

        Button timerButton = findViewById(R.id.buttonTimer);
        timerButton.setOnClickListener(view -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Odliczanie")
                    .putExtra(AlarmClock.EXTRA_LENGTH, 60)
                            .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
            startActivity(intent);
        });

    }
}