package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button repiracaovermais,diariobtn,homebtn ,configbtn,verdiariobtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ConstraintLayout menu = findViewById(R.id.menuSuspenso);
        menu.setVisibility(View.VISIBLE);

        repiracaovermais = (Button) findViewById(R.id.respiracabtn);
        verdiariobtn = (Button) findViewById(R.id.verdiariobtn);
        diariobtn = (Button) findViewById(R.id.diariobtn);
        homebtn = (Button) findViewById(R.id.homebtn);
        configbtn = (Button) findViewById(R.id.configbtn);

        verdiariobtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
        configbtn.setOnClickListener(this);
        repiracaovermais.setOnClickListener(this);
        diariobtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.respiracabtn){
            Intent info = new Intent(this,Info_respiracaoActivity.class);
            startActivity(info);
        }

        if (v.getId()==R.id.verdiariobtn){
            Intent infodiario = new Intent(this,Info_diarioActivity.class);
            startActivity(infodiario);
        }

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
