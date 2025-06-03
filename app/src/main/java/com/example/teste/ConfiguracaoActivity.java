package com.example.teste;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfiguracaoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nomeInput, nascimentoInput, senhaInput, confirmarSenhaInput;
    Button atualizarBtn;
    DBHelper dbHelper;
    int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes);

        dbHelper = new DBHelper(this);

        // Recupera ID do usuário logado
        SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);
        idUsuario = prefs.getInt("id_usuario", -1);

        if (idUsuario == -1) {
            Toast.makeText(this, "Erro ao carregar usuário", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Referência aos campos
        nomeInput = findViewById(R.id.emailinput); // nome está no campo "emailinput"
        nascimentoInput = findViewById(R.id.nascimentoinput);
        senhaInput = findViewById(R.id.senhainput);
        confirmarSenhaInput = findViewById(R.id.confirmarsenhainput);
        atualizarBtn = findViewById(R.id.atualizarbtn);

        atualizarBtn.setOnClickListener(this);

        // Carrega dados atuais do usuário
        carregarDadosUsuario();
    }

    private void carregarDadosUsuario() {
        Cursor c = dbHelper.getUsuarioPorId(idUsuario);
        if (c != null && c.moveToFirst()) {
            @SuppressLint("Range") String nome = c.getString(c.getColumnIndex("nome"));
            @SuppressLint("Range") String senha = c.getString(c.getColumnIndex("senha"));

            nomeInput.setText(nome);
            senhaInput.setText(senha);
            confirmarSenhaInput.setText(senha); // opcional
        }
        if (c != null) c.close();
    }

    @Override
    public void onClick(View v) {
        String novoNome = nomeInput.getText().toString().trim();
        String novaSenha = senhaInput.getText().toString().trim();
        String confirmarSenha = confirmarSenhaInput.getText().toString().trim();

        if (novoNome.isEmpty() || novaSenha.isEmpty() || confirmarSenha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!novaSenha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean atualizado = dbHelper.atualizarUsuario(idUsuario, novoNome, novaSenha);

        if (atualizado) {
            Toast.makeText(this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao atualizar", Toast.LENGTH_SHORT).show();
        }
    }
}
