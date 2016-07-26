package br.aulashelder.apresentacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.aulashelder.model.Pessoa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ListarPessoasActivity extends Activity {

	 private static final String ARQUIVO = "arquivo.txt";
	 private static final String CATEGORIA = "livro";
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_listar);
		visualizarArquivo();
	}
	
	private void visualizarArquivo() {
		TextView text = (TextView) findViewById(R.id.arquivo);
		try {
			File f = getFileStreamPath(ARQUIVO);

			Log.i(CATEGORIA, "Abrindo arquivo: " + f.getAbsolutePath());

			if (f.exists()) {
				FileInputStream in = openFileInput(ARQUIVO);
				int tamanho = in.available();
				byte bytes[] = new byte[tamanho];
				in.read(bytes);
				String s = new String(bytes);
				text.setText(s);
			} else {
				Log.i(CATEGORIA, "Arquivo não existe ou excluído");
				text.setText("");
			}
		} catch (FileNotFoundException e) {
			Log.e(CATEGORIA, "Arquivo não encontrado: " + e.getMessage(), e);
		} catch (IOException e) {
			Log.e(CATEGORIA, e.getMessage(), e);
		}

	}
}
