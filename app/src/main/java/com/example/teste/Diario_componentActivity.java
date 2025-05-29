package com.example.teste;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.teste.R;

public class Diario_componentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diario_component);

    }

    @Override
    public void onClick(View v) {

    }
}