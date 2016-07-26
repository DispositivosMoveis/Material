package br.aulashelder.menucheckradiospinner;




import br.aulashelder.menucheckradiospinner.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MenuActivity extends Activity {
	/** Called when the activity is first created. */

	public static final int MENU1 = 0;
	public static final int MENU2 = 1;
	private String[] times = new String[] { "Flamengo", "Bahia", "Vitoria", "Palmeiras", "Cruzeiro"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		final EditText textNome = (EditText) findViewById(R.id.textNome);

		//obtendo um radio grupo
		final RadioGroup group = (RadioGroup) findViewById(R.id.group1);

		//definindo um evento para obter qual opcao foi escolhida
		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				boolean sim = R.id.radioSim == checkedId;
				boolean nao = R.id.radioNao == checkedId;
				if (sim) {
					Toast.makeText(MenuActivity.this, "Tocou no sim", Toast.LENGTH_SHORT)
					.show();
				} else if (nao) {
					Toast.makeText(MenuActivity.this, "Tocou na opcao nao", Toast.LENGTH_SHORT)
					.show();
				}
			}
		});

		final CheckBox check = (CheckBox) findViewById(R.id.checkReceberEmail);
		// define um listener para executar quando alterar o check
		check.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(MenuActivity.this, "Estado do check alterado", Toast.LENGTH_SHORT)
				.show();
			}
		});
		
		
		final Spinner combo = (Spinner) findViewById(R.id.comboTimes);

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, times);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
		// adaptador.setDropDownViewResource(android.R.layout.
		// simple_spinner_dropdown_item);
		combo.setAdapter(adaptador);
		

	
		/*combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				// Atualiza a imagem
				//imagem.setImageResource(imagens[posicao]);
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	*/


		Button b = (Button) findViewById(R.id.buttonEnviar);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MenuActivity.this, "OK", Toast.LENGTH_SHORT).show();

				// compara o id do radioSim
				boolean concorda = R.id.radioSim == group.getCheckedRadioButtonId();
				boolean receberEmail = check.isChecked();

				StringBuffer sb = new StringBuffer();
				sb.append("Nome: ");
				sb.append(textNome.getText());
				sb.append("\nReceber Email: ");
				if (receberEmail) {
					sb.append("Sim");
				}
				else {
					sb.append("Nao");
				}
				sb.append("\nConcorda: ");
				if (concorda) {
					sb.append("Sim");
				}
				else {
					sb.append("Nao");
				}


				Toast.makeText(MenuActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}



	//adicionando as opcoes no menu
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU1, 0, "Inserir Novo").setIcon(R.drawable.novo);
		menu.add(0, MENU2, 0, "Salvar").setIcon(R.drawable.salvar);

		return super.onCreateOptionsMenu(menu);

	}
	//metodo para verificar o item do menu selecionado
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case MENU1:
			Toast.makeText(MenuActivity.this, "Menu1 Selecionado", Toast.LENGTH_SHORT)
					.show();
			return true;

		case MENU2:
			Toast.makeText(MenuActivity.this, "Menu2 Selecionado", Toast.LENGTH_SHORT)
					.show();
			return true;

		}

		return false;
	}
}