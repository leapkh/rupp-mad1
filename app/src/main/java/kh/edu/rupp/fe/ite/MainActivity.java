package kh.edu.rupp.fe.ite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply UI to the activity
        setContentView(R.layout.activity_main);

        // Make a reference to the views
        Button btnGetName = findViewById(R.id.btn_get_name);

        // Handle click event
        //// Method 1
        /*btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        //// Method 2
        btnGetName.setOnClickListener(view -> {
            EditText edtName = findViewById(R.id.edt_name);
            String name = edtName.getText().toString();
            Toast.makeText(this, "My name is " + name, Toast.LENGTH_SHORT).show();
        });
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