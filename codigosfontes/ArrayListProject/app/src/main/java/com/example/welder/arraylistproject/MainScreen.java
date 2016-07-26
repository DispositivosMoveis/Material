package com.example.welder.arraylistproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.welder.model.Pessoas;

public class MainScreen extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnListar;
    public static Pessoas pessoas = new Pessoas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnListar = (Button) findViewById(R.id.btnListar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                final Intent intentOne = intent.setClass(MainScreen.this, CadastroPessoa.class);
                startActivity(intentOne);
                finish();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                final Intent intentOne = intent.setClass(MainScreen.this, ListarPessoas.class);
                startActivity(intentOne);
                finish();
            }
        });

    }
}
