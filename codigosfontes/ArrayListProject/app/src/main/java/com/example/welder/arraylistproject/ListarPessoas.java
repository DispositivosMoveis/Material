package com.example.welder.arraylistproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.welder.model.Pessoa;

/**
 * Created by welder on 17/07/16.
 */
public class ListarPessoas extends Activity {

    private Button btnListarVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pessoas);

        btnListarVoltar = (Button) findViewById(R.id.btnListarVoltar);

        for (int i=0; i < MainScreen.pessoas.tamanho();i++){
            Pessoa p = (Pessoa) MainScreen.pessoas.obter(i);
            Toast.makeText(getApplicationContext()," "+p.getNome(),Toast.LENGTH_LONG).show();
        }

        btnListarVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                final Intent intentOne = intent.setClass(ListarPessoas.this,MainScreen.class);
                startActivity(intentOne);
                finish();
            }
        });


    }
}
