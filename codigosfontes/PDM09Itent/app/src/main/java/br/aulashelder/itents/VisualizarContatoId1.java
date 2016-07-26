package br.aulashelder.itents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;


public class VisualizarContatoId1 extends Activity {

	protected String getTexto() {

		return "Visualizar o contato de id = 1";
	}


	public void onClick(View view) {
		//Cria a Uri com o contato 1
		Uri uri = Uri.parse("content://com.android.contacts/contacts/1");

		//passa a uri para o intent
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);

		//Chama a intent
		startActivity(intent);

	}
}