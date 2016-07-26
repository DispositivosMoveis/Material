package br.aulashelder.exemplo1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Criando um objeto alerta para exibir a mensagem na tela
		Toast alerta = Toast.makeText(getApplicationContext(), "Primeiro exemplo", Toast.LENGTH_LONG);

		//exibindo a mensagem com o metodo show
		alerta.show();

		//associando a Activity a um layout
		setContentView(R.layout.activity_main);
	}
}
