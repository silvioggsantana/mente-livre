package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView cadastrobtn,loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // vinculando os objetos com a interface gráfica
        cadastrobtn = (TextView) findViewById(R.id.cadastrotxt);
        loginbtn = (TextView) findViewById(R.id.loginbtn);


        // quando ouvir o click nos botões irá chamar os código do onClick
        cadastrobtn.setOnClickListener(this);
        loginbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //se a origem do click foi o botão tela1
        if (v.getId()==R.id.cadastrotxt){
            Intent cadastro = new Intent(this,CadastroActivity.class);
            startActivity(cadastro);
        }

        if (v.getId()==R.id.loginbtn){
            Toast.makeText(this, "Login com sucesso", Toast.LENGTH_SHORT).show();

            Intent home = new Intent(this,HomeActivity.class);
            startActivity(home);
        }


    }
}
