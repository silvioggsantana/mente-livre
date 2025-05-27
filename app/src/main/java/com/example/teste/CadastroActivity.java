package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {
    TextView loginbtn;
    Button continuarbtn;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        loginbtn = (TextView) findViewById(R.id.logintxt);
        continuarbtn = (Button) findViewById(R.id.continuar);
        loginbtn.setOnClickListener(this);
        continuarbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.logintxt){
            Intent login = new Intent(this,LoginActivity.class);
            startActivity(login);
        }

        if (v.getId()==R.id.continuar){
            Intent cadastro2 = new Intent(this,Cadastro2Activity.class);
            startActivity(cadastro2);
        }
    }
}
