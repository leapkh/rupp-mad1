package kh.edu.rupp.fe.ite;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

import kh.edu.rupp.fe.ite.databinding.ActivityMainBinding;

public class Main2Activity extends AppCompatActivity {

    //private final int PLACE_DETAIL_REQUEST_CODE = 1;

    private ActivityMainBinding binding;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK){
                    Intent dataIntent = result.getData();
                    if(dataIntent != null){
                        String text = dataIntent.getStringExtra("text");
                        binding.edtName.setText(text);
                    }
                }
            }
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Apply UI to the activity
        setContentView(binding.getRoot());

        // Handle click event
        //// Method 1
        /*binding.btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        //// Method 2
        binding.btnGetName.setOnClickListener(view -> {
            String name = binding.edtName.getText().toString();
            Toast.makeText(this, "My name is " + name, Toast.LENGTH_SHORT).show();
        });

        binding.btnDetail.setOnClickListener(view -> {
            String name = binding.edtName.getText().toString();

            // Open and pass data to PlaceDetailActivity
            Intent intent = new Intent(this, PlaceDetailActivity.class);
            intent.putExtra("name", name);
            //startActivityForResult(intent, PLACE_DETAIL_REQUEST_CODE);

            activityResultLauncher.launch(intent);
        });

        binding.btnGetCurrentTime.setOnClickListener(view -> {
            Date currentDate = new Date();
            String formattedDate = currentDate.toString();

            // Reference to time TextView
            TextView txtTime = findViewById(R.id.txtTime);
            txtTime.setText(formattedDate);
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == PLACE_DETAIL_REQUEST_CODE){
                if(data != null){
                    String text = data.getStringExtra("text");
                    binding.edtName.setText(text);
                }
            }
        }
    }*/
}