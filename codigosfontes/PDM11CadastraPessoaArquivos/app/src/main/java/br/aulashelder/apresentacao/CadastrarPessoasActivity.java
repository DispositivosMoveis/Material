package br.aulashelder.apresentacao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import br.aulashelder.model.Pessoa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class CadastrarPessoasActivity extends Activity {
 
 private static final String ARQUIVO = "arquivo.txt";
 private static final String CATEGORIA = "exemploarquivo";

 private EditText editTextNome;
 private EditText editTextIdade;

 private Button btnCadastrar;
 private Button btnCancelar;

 private String nome;
 private int idade;

 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 	
 		
 		setContentView(R.layout.activity_cadastrar);
 		editTextNome = (EditText) findViewById(R.id.editTextNome);
 		editTextIdade = (EditText) findViewById(R.id.editTextIdade);
 		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
 		btnCancelar = (Button) findViewById(R.id.btnCancelar);
 		
 		btnCadastrar.setOnClickListener(new OnClickListener() {
 		@Override
 		public void onClick(View arg0) {
 				nome = editTextNome.getText().toString();
 				idade = Integer.parseInt(editTextIdade.getText().toString());

  				Pessoa pessoa = new Pessoa(nome,idade);
  				salvar(pessoa);
 				editTextNome.setText("");
 				editTextIdade.setText("");
 				Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
 			
 			}
 		});
 		
 		
 		
		btnCancelar.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				 Intent intent = new Intent();
	 	            intent.setClass(CadastrarPessoasActivity.this,PrincipalActivity.class);

	 	            startActivity(intent);

	 	            finish();
			}
		});
 
 	}
 	
 	public void salvar(Pessoa pessoa) {
		try {
			FileOutputStream out = openFileOutput(ARQUIVO, MODE_APPEND);

			
			String dadospessoa = pessoa.toString();

			out.write("\n".getBytes());
			out.write(dadospessoa.getBytes());
			out.close();

			Log.i(CATEGORIA, dadospessoa + " - escrito com sucessso");

			//visualizarArquivo();

		} catch (FileNotFoundException e) {
			Log.e(CATEGORIA, e.getMessage(), e);
		} catch (IOException e) {
			Log.e(CATEGORIA, e.getMessage(), e);
		}
	}

	
 	
 	
 
	
 
}
