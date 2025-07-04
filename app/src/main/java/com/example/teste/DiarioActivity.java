package com.example.teste;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DiarioActivity extends AppCompatActivity {

    ArrayList<String> anotacoes;
    AnotacaoAdapter adapter;
    ListView listaAnotacoes;
    FloatingActionButton botaoAdicionar;
    int contador = 1;

    // Launcher para nova anotação
    ActivityResultLauncher<Intent> novaAnotacaoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String texto = result.getData().getStringExtra("anotacao");
                    if (texto != null && !texto.isEmpty()) {
                        SharedPreferences prefs = getSharedPreferences("DiarioPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();

                        Gson gson = new Gson();
                        String json = gson.toJson(anotacoes);

                        editor.putString("lista_anotacoes", json);
                        editor.putInt("contador", contador);
                        editor.apply();


                        String dataAtual = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                        anotacoes.add("Dia " + contador + "\n" + dataAtual + "\n\n" + texto);
                        contador++;
                        adapter.notifyDataSetChanged();
                    }
                }
            });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diario);

        anotacoes = new ArrayList<>();
        listaAnotacoes = findViewById(R.id.listaAnotacoes);
        botaoAdicionar = findViewById(R.id.botaoAdicionar);

        adapter = new AnotacaoAdapter(anotacoes);
        listaAnotacoes.setAdapter(adapter);

        botaoAdicionar.setOnClickListener(view -> {
            Intent intent = new Intent(DiarioActivity.this, NovaAnotacaoActivity.class);
            novaAnotacaoLauncher.launch(intent);
        });
    }

    private class AnotacaoAdapter extends ArrayAdapter<String> {
        AnotacaoAdapter(ArrayList<String> anotacoes) {
            super(DiarioActivity.this, 0, anotacoes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_anotacao, parent, false);
            }

            String[] partes = getItem(position).split("\n");

            TextView titulo = convertView.findViewById(R.id.tituloAnotacao);
            TextView data = convertView.findViewById(R.id.dataAnotacao);
            TextView texto = convertView.findViewById(R.id.textoAnotacao);

            titulo.setText(partes[0]); // Dia X
            if (partes.length > 1) {
                data.setText(partes[1]); // Data
            }
            if (partes.length > 3) {
                texto.setText(partes[3]); // Texto da anotação
            }

            return convertView;
        }
    }
}
