package br.aulashelder.apresentacao;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class PrincipalActivity extends ListActivity {

	
	
	 private static final String[] ops = new String[] { "Cadastrar Pessoa", "Listar Pessoas", "Sair" };
	 
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		

 		int layout = android.R.layout.simple_list_item_1;
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, layout, ops);
		this.setListAdapter(adaptador);

 
 	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
		case 0:
			startActivity(new Intent(this, CadastrarPessoasActivity.class));
			break;
		case 1:
			startActivity(new Intent(this, ListarPessoasActivity.class));
			break;
		default:
			finish();
		}
	}
	
}
