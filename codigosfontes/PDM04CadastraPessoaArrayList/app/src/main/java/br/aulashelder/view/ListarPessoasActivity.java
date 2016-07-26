package br.aulashelder.view;

import br.aulashelder.model.Pessoa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ListarPessoasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		//listando os objetos do arraylist pessoas
		for (int i =0; i < PrincipalActivity.pessoas.tamanho();i++){
			Pessoa p = (Pessoa) PrincipalActivity.pessoas.obter(i);
			Toast.makeText(getApplicationContext(), ""+ p.getNome(), Toast.LENGTH_LONG).show();
			
		}
		setContentView(R.layout.activity_listar);
	}
}
