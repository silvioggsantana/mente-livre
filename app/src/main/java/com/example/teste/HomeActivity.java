package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button repiracaovermais;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ConstraintLayout menu = findViewById(R.id.menuSuspenso);
        menu.setVisibility(View.VISIBLE);

        repiracaovermais = (Button) findViewById(R.id.respiracabtn);

        repiracaovermais.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.respiracabtn){
            Intent info = new Intent(this,Info_respiracaoActivity.class);
            startActivity(info);
        }
    }
}
