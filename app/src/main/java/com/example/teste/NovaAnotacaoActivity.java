package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NovaAnotacaoActivity extends AppCompatActivity {

    EditText campoTexto;
    Button botaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_anotacao);

        campoTexto = findViewById(R.id.campotexto);
        botaoSalvar = findViewById(R.id.botaosalvar);

        botaoSalvar.setOnClickListener(view -> {
            String texto = campoTexto.getText().toString();
            if (!texto.isEmpty()) {
                Intent intent = new Intent();
                intent.putExtra("anotacao", texto);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
