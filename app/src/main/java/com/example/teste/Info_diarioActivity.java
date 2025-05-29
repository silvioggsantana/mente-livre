package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Info_diarioActivity extends AppCompatActivity implements View.OnClickListener {

    Button continuarbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_diario);

        continuarbtn = (Button) findViewById(R.id.continuar);

        continuarbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.continuar){
            Intent respiracao = new Intent(this,DiarioActivity.class);
            startActivity(respiracao);
        }
    }
}