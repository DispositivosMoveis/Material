package com.example.welder.arraylistproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.welder.model.Pessoa;
import com.example.welder.model.Pessoas;

/**
 * Created by welder on 17/07/16.
 */
public class CadastroPessoa extends Activity{

    private Button btnSalvar;
    private Button btnVoltar;
    private EditText editNome;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        editNome = (EditText) findViewById(R.id.editNome);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);
                MainScreen.pessoas.adicionar(pessoa);
                editNome.setText("");
                Toast.makeText(getApplicationContext(),"Cadastrado com sucesso!!",Toast.LENGTH_LONG).show();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                final Intent intentOne = intent.setClass(CadastroPessoa.this,MainScreen.class);
                startActivity(intentOne);
                finish();
            }
        });

    }

}
