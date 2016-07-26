package mapas.aulashelder.geotecnologias;

import android.app.ListActivity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends ListActivity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		String[] mStrings = new String[] { 
				"Exemplo 1 - Mapas com Ponto (marcador), linha e poligono",
				"Exemplo 2 - Uso do GPS",
				"Exemplo 3 - Rota",
				"Exemplo 4 - GeoCoder",
				"Sair"
		};
		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
			case 0:
				startActivity(new Intent(this,ExemploMapaMarcadorLinhaPoligono.class));
				break;
			case 1:
				startActivity(new Intent(this,ExemploMapaGPS.class));
				break;
			case 2:
				String origem = "-12.9373272,-38.4058418";
				String destino = "-12.981348,-38.446262";
				String url = "http://maps.google.com/maps?f=d&saddr="+origem+"&daddr="+destino+"&hl=pt";
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				break;
			case 3:
				testeGeoCoder();
				break;
			default:
				finish();
		}
	}

	private void testeGeoCoder() {
		new Thread(){
			public void run() {
				try {
					Geocoder gc = new Geocoder(getBaseContext(), new Locale("pt","BR"));
					List<Address> list =  gc.getFromLocationName("Av. Luiz Viana Filho", 10);
					toast("enderecos: " + list);
				} catch (IOException e) {
					toast("Erro: " + e.getMessage());
				}
			}
		}.start();
	}
	
	private void toast(final String string) {
		runOnUiThread(new Runnable() {
			public void run() {
				Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
			}
		});
	};
}