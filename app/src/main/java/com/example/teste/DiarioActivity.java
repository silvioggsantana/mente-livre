package com.example.teste;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class DiarioActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diario);
        LinearLayout diario = findViewById(R.id.diariocomponent);
//        diario.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {

    }
}
