package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro2Activity extends AppCompatActivity implements View.OnClickListener {

    Button cadastrarbtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro2);

        cadastrarbtn = (Button) findViewById(R.id.cadastrar);

        cadastrarbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cadastrar) {
            Toast.makeText(this, "Cadastro concluído", Toast.LENGTH_SHORT).show();

            Intent login = new Intent(this,LoginActivity.class);
            startActivity(login);
        }
    }
}
