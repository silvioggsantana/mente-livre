package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro2Activity extends AppCompatActivity implements View.OnClickListener {

    Button cadastrarbtn;
    EditText nomeInput, nascimentoInput;
    String email, senha;
    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro2);

        // Recupera os dados da tela anterior
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        senha = intent.getStringExtra("senha");

        // Inicializa o banco
        dbHelper = new DBHelper(this);

        // Referência para os campos
        nomeInput = findViewById(R.id.nomeinput);
        nascimentoInput = findViewById(R.id.nascimentoinput);
        cadastrarbtn = findViewById(R.id.cadastrar);

        cadastrarbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cadastrar) {
            String nome = nomeInput.getText().toString().trim();
            String nascimento = nascimentoInput.getText().toString().trim();

            if (nome.isEmpty() || nascimento.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Insere no banco apenas nome, email e senha (o nascimento é ignorado no banco atual)
            boolean sucesso = dbHelper.inserirUsuario(nome, email, senha);

            if (sucesso) {
                Toast.makeText(this, "Cadastro concluído com sucesso!", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                finish();
            } else {
                Toast.makeText(this, "Erro: E-mail já cadastrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
