package br.aulashelder.itents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LigarParaTelefoneActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.form_telefone);

		final Button button = (Button) findViewById(R.id.botaoOk);
		button.setOnClickListener(this);
	}


	public void onClick(View view) {

		EditText campoTelefone = (EditText) findViewById(R.id.campoTelefone);

		String telefone = campoTelefone.getText().toString();

		//URI do numero de um telefone
		Uri uri = Uri.parse("tel:"+telefone);

		/*Observar a permissao no manifest: <uses-permission android:name="android.permission.CALL_PHONE"/>
		 */
		Intent intent = new Intent(Intent.ACTION_DIAL,uri);

		//chama a Intent
		startActivity(intent); 


	}

}
