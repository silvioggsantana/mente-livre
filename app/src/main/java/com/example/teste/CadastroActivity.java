package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    TextView loginbtn;
    Button continuarbtn;
    EditText emailInput, senhaInput, confirmarSenhaInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        // Referência para os componentes visuais
        loginbtn = findViewById(R.id.logintxt);
        continuarbtn = findViewById(R.id.continuar);
        emailInput = findViewById(R.id.emailinput);
        senhaInput = findViewById(R.id.senhainput);
        confirmarSenhaInput = findViewById(R.id.confirmarsenhainput);

        loginbtn.setOnClickListener(this);
        continuarbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logintxt) {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }

        if (v.getId() == R.id.continuar) {
            String email = emailInput.getText().toString().trim();
            String senha = senhaInput.getText().toString().trim();
            String confirmarSenha = confirmarSenhaInput.getText().toString().trim();

            // Validação de preenchimento
            if (email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validação de formato de e-mail
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "E-mail inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validação se as senhas são iguais
            if (!senha.equals(confirmarSenha)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                return;
            }

            // Enviar dados para a próxima tela
            Intent cadastro2 = new Intent(this, Cadastro2Activity.class);
            cadastro2.putExtra("email", email);
            cadastro2.putExtra("senha", senha);
            startActivity(cadastro2);
        }
    }
}
