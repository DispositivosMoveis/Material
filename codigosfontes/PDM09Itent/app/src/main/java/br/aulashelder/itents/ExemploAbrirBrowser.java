package br.aulashelder.itents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class ExemploAbrirBrowser extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.form_browser);

		final Button button = (Button) findViewById(R.id.botaoOk);
		button.setOnClickListener(this);
	}


	public void onClick(View view) {

		EditText campoEndereco = (EditText) findViewById(R.id.campoEndereco);

		String endereco = campoEndereco.getText().toString();

		//Instanciando um objeto uri para representar o endereco (a pagina web, por exemplo)
		Uri uri = Uri.parse(endereco);

		// Cria a Intent passando o endereco
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);

		//Chama a intent
		startActivity(intent);
	}
}
