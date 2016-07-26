package mapas.aulashelder.geotecnologias;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;

public class ExemploMapaGPS extends ExemploMapaMarcadorLinhaPoligono implements LocationListener {
	@Override
	protected void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		
	}

	@Override
	protected void onResume() {
		super.onResume();

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			// GPS esta ligado
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 100, this);
		} else {
			// Solicita ao usuario para ligar o GPS
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			alertDialogBuilder.setMessage("O GPS esta desligado! Deseja ligar agora?")
					.setCancelable(false).setPositiveButton(
							"Sim",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									// Intent para entrar nas configuras de localiza
									Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
									startActivity(callGPSSettingIntent);
								}
							});
			alertDialogBuilder.setNegativeButton("Nao",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			AlertDialog alert = alertDialogBuilder.create();
			alert.show();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();

		// Desliga o GPS
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		locationManager.removeUpdates(this);
	}
	//Metodo chamado quando altera a posicao
	@Override
	public void onLocationChanged(Location location) {
		Toast.makeText(this, "Location: " + location, Toast.LENGTH_SHORT).show();

		// Centraliza o mapa nesta coordenada
		LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));

		
		// Atualiza o ponto azul para a nova coordenada
		this.locationSource.setLocation(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// Provedor do GPS foi desabilitado
	}

	@Override
	public void onProviderEnabled(String provider) {
		// Provedor do GPS foi habilitado
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// Status do provedor do GPS mudou
	}
}