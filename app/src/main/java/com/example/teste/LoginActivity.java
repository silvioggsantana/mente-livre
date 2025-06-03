package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView cadastrobtn, loginbtn;
    EditText emailInput, senhaInput;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Inicializa o banco de dados
        dbHelper = new DBHelper(this);

        // Vinculando os objetos com a interface gráfica
        cadastrobtn = findViewById(R.id.cadastrotxt);
        loginbtn = findViewById(R.id.loginbtn);
        emailInput = findViewById(R.id.emailinput);
        senhaInput = findViewById(R.id.senhainput);

        // Setando ouvintes de clique
        cadastrobtn.setOnClickListener(this);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cadastrotxt) {
            Intent cadastro = new Intent(this, CadastroActivity.class);
            startActivity(cadastro);
        }

        if (v.getId() == R.id.loginbtn) {
            String email = emailInput.getText().toString().trim();
            String senha = senhaInput.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean loginValido = dbHelper.validarLogin(email, senha);

            if (loginValido) {
                Toast.makeText(this, "Login com sucesso", Toast.LENGTH_SHORT).show();
                Intent home = new Intent(this, HomeActivity.class);
                startActivity(home);
                finish(); // opcional: fecha a tela de login
            } else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
