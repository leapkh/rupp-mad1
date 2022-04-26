package kh.edu.rupp.fe.ite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kh.edu.rupp.fe.ite.databinding.ActivityPlaceDetailBinding;

public class PlaceDetailActivity extends AppCompatActivity {

    private ActivityPlaceDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlaceDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Read data from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        binding.txtTest.setText(name);

        // Handle click event
        binding.btnGoBack.setOnClickListener(view -> {
            String text = binding.edtTest.getText().toString();
            Intent dataIntent = new Intent();
            dataIntent.putExtra("text", text);
            setResult(RESULT_OK, dataIntent);
            finish();
        });

    }

    // Onclick
    public void onBackButtonClick(View view){
        finish();
    }

}
