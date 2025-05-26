
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teste.R;

public class MainActivity extends AppCompatActivity {

    // Declaração dos elementos da interface
    private EditText emailInput;
    private EditText senhaInput;
    private Button buttonLogar;
    private TextView cadastroTxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Conectando a activity com o layout XML
        setContentView(R.layout.activity_main); // Nome do XML: activity_main.xml

        // Ligando os componentes da tela aos objetos Java
        emailInput = findViewById(R.id.emailinput);
        senhaInput = findViewById(R.id.senhainput);
        buttonLogar = findViewById(R.id.buttonLogar);
        cadastroTxt = findViewById(R.id.cadastrotxt);

        // Ação do botão "Logar"
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String senha = senhaInput.getText().toString();

                // Aqui você pode implementar a lógica de validação/autenticação
                if (email.equals("admin@teste.com") && senha.equals("123456")) {
                    Toast.makeText(MainActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    // Aqui você poderia abrir uma nova Activity
                } else {
                    Toast.makeText(MainActivity.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ação do texto "cadastre-se"
        cadastroTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui você poderia redirecionar para uma tela de cadastro
                Toast.makeText(MainActivity.this, "Tela de cadastro (não implementada)", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}
