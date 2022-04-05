package kh.edu.rupp.fe.ite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    // Onclick
    public void onGoToDetailClick(View view){
        // Open PlaceDetailActivity
        Intent intent = new Intent(this, PlaceDetailActivity.class);
        startActivity(intent);
    }

    public void onGetCurrentTimeClick(View view){
        Date currentDate = new Date();
        String formattedDate = currentDate.toString();

        // Reference to time TextView
        TextView txtTime = findViewById(R.id.txtTime);
        txtTime.setText(formattedDate);

    }

}