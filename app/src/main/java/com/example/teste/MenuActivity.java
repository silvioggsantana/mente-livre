package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button diariobtn,homebtn,configbtn;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        diariobtn = (Button) findViewById(R.id.diariobtn);
        homebtn = (Button) findViewById(R.id.homebtn);
        configbtn = (Button) findViewById(R.id.configbtn);

        diariobtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
        configbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.diariobtn){
            Intent diario = new Intent(this,DiarioActivity.class);
            startActivity(diario);
        }

        if (v.getId()==R.id.homebtn){
            Intent home = new Intent(this,HomeActivity.class);
            startActivity(home);
        }

        if (v.getId()==R.id.configbtn){
            Intent configuracao = new Intent(this,ConfiguracaoActivity.class);
            startActivity(configuracao);
        }
    }
}
