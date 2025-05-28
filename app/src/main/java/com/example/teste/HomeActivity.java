package com.example.teste;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ConstraintLayout menu = findViewById(R.id.menuSuspenso);
        menu.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {

    }
}
