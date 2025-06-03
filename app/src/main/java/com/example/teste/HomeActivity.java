package com.example.teste;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button repiracaovermais,diariobtn,homebtn ,configbtn,verdiariobtn;
    TextView nomeUsuarioText;
    DBHelper dbHelper;

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

        nomeUsuarioText = findViewById(R.id.titulohometxt);
        dbHelper = new DBHelper(this);

        SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);
        int idUsuario = prefs.getInt("id_usuario", -1);

        if (idUsuario != -1) {
            Cursor cursor = dbHelper.getUsuarioPorId(idUsuario);
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex("nome"));
                nomeUsuarioText.setText("Bem vindo, " + nome + "!");
            }
            cursor.close();
        } else {
            nomeUsuarioText.setText("Olá!");
        }
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
