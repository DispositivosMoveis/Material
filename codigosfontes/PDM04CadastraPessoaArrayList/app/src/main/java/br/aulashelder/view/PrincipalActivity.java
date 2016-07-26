package br.aulashelder.view;

import java.util.ArrayList;

import br.aulashelder.model.Pessoa;
import br.aulashelder.model.Pessoas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class PrincipalActivity extends Activity {

	
	 private Button btnCadastrar;
	 private Button btnListar;
	 public static Pessoas pessoas = new Pessoas();
	 
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		
 		
 		setContentView(R.layout.activity_tela_principal);
 		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
 		btnListar = (Button) findViewById(R.id.btnListar);
 		//Associando um ouvinte ao botao para implementacao de um evento
 		btnCadastrar.setOnClickListener(new OnClickListener() {
 
 		@Override
 		public void onClick(View arg0) {
			//utilizando a classe intent para chamar a outra tela (Tela CadastrarPessoasActivity)
            Intent intent = new Intent();
            intent.setClass(PrincipalActivity.this,CadastrarPessoasActivity.class);

            startActivity(intent);

            finish();
 			
 			}
 		});
 		
 		btnListar.setOnClickListener(new OnClickListener() {
 			 
 	 		@Override
 	 		public void onClick(View arg0) {

 	            Intent intent = new Intent();
 	            intent.setClass(PrincipalActivity.this,ListarPessoasActivity.class);

 	            startActivity(intent);

 	            finish();
 	 			
 	 			}
 	 		});
 	 
 
 	}

}
