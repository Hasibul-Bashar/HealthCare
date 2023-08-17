package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailsActivit extends AppCompatActivity {
    TextView tv1;
    ImageView imp;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);

        btnBack=findViewById(R.id.buttonHAD);
        tv1=findViewById(R.id.textViewHRTitile);
        imp=findViewById(R.id.imageViewHAD);
        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if(bundle !=null){
            int resId=bundle.getInt("text2");
            imp.setImageResource(resId);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesDetailsActivit.this, HealthArticlesActivity.class));
            }
        });
    }
}