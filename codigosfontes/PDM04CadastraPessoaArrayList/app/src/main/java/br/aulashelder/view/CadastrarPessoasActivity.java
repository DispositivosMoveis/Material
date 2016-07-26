package br.aulashelder.view;

import br.aulashelder.model.Pessoa;
import br.aulashelder.model.Pessoas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
 
public class CadastrarPessoasActivity extends Activity {
 
 private EditText editTextNome;
 private EditText editTextIdade;

 private Button btnCadastrar;
 private Button btnCancelar;

 private String nome;
 private int idade;
 Pessoas arrayPessoas = new Pessoas();
 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 	
 		
 		setContentView(R.layout.activity_cadastrar);
 		editTextNome = (EditText) findViewById(R.id.editTextNome);
 		editTextIdade = (EditText) findViewById(R.id.editTextIdade);
 		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
 		btnCancelar = (Button) findViewById(R.id.btnVoltar);

		//evento para cadastrar uma pessoa no arraylist
 		btnCadastrar.setOnClickListener(new OnClickListener() {
			@Override
 			public void onClick(View arg0) {
				//obtendo os dados da tela
 				nome = editTextNome.getText().toString();
 				idade = Integer.parseInt(editTextIdade.getText().toString());
				//passando os dados para o objeto pessoa
  				Pessoa pessoa = new Pessoa(nome,idade);
				//adicionando  no arraylist o objeto pessoa com os dados da tela
 				PrincipalActivity.pessoas.adicionar(pessoa);
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
 	
 	
 
	
 
}
