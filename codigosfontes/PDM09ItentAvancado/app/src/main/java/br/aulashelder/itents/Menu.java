package br.aulashelder.itents;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Exemplos de Intents para abrir o browser, fazer ligações, etc
 * 
 * @author rlecheta
 * 
 */
public class Menu extends ListActivity {
	private static final String CATEGORIA = "livro";

	//Para identificar a chamada no método onActivityResult
	private static final int ACTIVITY_SIM_NAO = 1;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		String[] mStrings = new String[] {
				"Abrir Browser",
				"Ligar para telefone",
				"Visualizar Contato num 1 ",
				"Visualizar Todos Contatos",
				"Enviar E-mail",
				"Enviar SMS",
				"Sair"};

		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		try {
			switch (position) {
			case 0:
				startActivity(new Intent(this,ExemploAbrirBrowser.class));
				break;
		
			case 1:
				startActivity(new Intent(this,LigarParaTelefoneActivity.class));
				break;

			case 2:
				//Visualizar o primeiro Contato da lista de contatos
				Uri uri = Uri.parse("content://com.android.contacts/contacts/1");
				startActivity(new Intent(Intent.ACTION_VIEW,uri));
				break;

			case 3:

				startActivity(new Intent(this,VisualizarTodosContatos.class));
				break;
			case 4:
				//Envio de Email
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Título do email");
				emailIntent.putExtra(Intent.EXTRA_TEXT, "Olá");
				emailIntent.putExtra(Intent.EXTRA_EMAIL, "helderaragao@gmail.com");
				emailIntent.setType("message/rfc822");
				startActivity(emailIntent);
				break;
			case 5:
				//Envio de SMS
			  
				Intent smsIntent = new Intent(Intent.ACTION_VIEW);
		        smsIntent.putExtra("address","tel:4444");
		        smsIntent.putExtra("sms_body", "Oi tudo bem? conheca a nova promocao....");
		        smsIntent.setType("vnd.android-dir/mms-sms");
		        startActivity(smsIntent);
			
				break;
		
			default:
				finish();
			}
		} catch (Exception e) {
			Toast.makeText(this, "Erro :" + e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}

	
	
	protected void onStart() {
		super.onStart();
		Log.i(CATEGORIA, "onStart() chamado.");
	}

	protected void onRestart() {
		super.onRestart();
		Log.i(CATEGORIA, "onRestart() chamado.");
	}

	protected void onResume() {
		super.onResume();
		Log.i(CATEGORIA, "onResume() chamado.");
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(CATEGORIA, "onSaveInstanceState() chamado.");
	}

	protected void onPause() {
		super.onPause();
		Log.i(CATEGORIA, "onPause() chamado.");
	}

	protected void onStop() {
		super.onStop();
		Log.i(CATEGORIA, "onStop() chamado.");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.i(CATEGORIA, "onDestroy() chamado.");
	}
}