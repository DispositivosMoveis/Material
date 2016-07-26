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


public class MainActivityMenu extends ListActivity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		String[] opcoes = new String[] {
				"Abrir Browser",
				"Ligar para telefone",
				"Visualizar Contato num 1 ",
				"Enviar E-mail",
				"Enviar SMS",
				"Sair"};

		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opcoes));
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
				//Envio de Email
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Titulo do email");
				emailIntent.putExtra(Intent.EXTRA_TEXT, "oi tudo bem, sou Helder Aragao");
				emailIntent.putExtra(Intent.EXTRA_EMAIL, "helderaragao@gmail.com");
				emailIntent.setType("message/rfc822");
				startActivity(emailIntent);
				break;
			case 4:
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

	

}