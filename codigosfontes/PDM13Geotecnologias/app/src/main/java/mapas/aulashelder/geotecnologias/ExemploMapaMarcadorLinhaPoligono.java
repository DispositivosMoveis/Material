package mapas.aulashelder.geotecnologias;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;




public class ExemploMapaMarcadorLinhaPoligono extends android.support.v4.app.FragmentActivity implements OnMapClickListener, OnCameraChangeListener {

	protected GoogleMap map;
	private SupportMapFragment mapFragment;
	protected ImplementacaoLocationSource locationSource;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.exemplo_mapa_v2);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		configureMap();
	}

	protected void configureMap() {
		if(map == null) {
			mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
			
			// Recupera o objeto GoogleMap
			map = mapFragment.getMap();

			if(map != null) {
				// Configura o tipo do mapa
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

				// Localizacao do mapa
				LatLng latLng = new LatLng(-13.0091221,-38.5104147);
				LatLng latLng2 = new LatLng(-13.0089184,-38.5303298);
			
				final CameraPosition position = new CameraPosition.Builder()
						.target(latLng) 	// Localizacao
						.bearing(0)	 	// Direcao em que a camera esta apontando em graus
						.tilt(0) 			// angulo que a camera esta posicionada em graus (0 a 90)
						.zoom(17) 			// Zoom
						.build();

				CameraUpdate update = CameraUpdateFactory.newCameraPosition(position);


				map.animateCamera(update);

				//Associa Eventos ao mapa
				map.setOnMapClickListener(this);

				// Adiciona os marcadores, poligono e a linha
				adicionarMarcador(map, latLng);
				adicionarMarcador(map, latLng2);
				adicionaPoligono(map);
				adicionaLinha(map);


				// Localizacao
				locationSource = new ImplementacaoLocationSource();
				map.setMyLocationEnabled(true);
				map.setLocationSource(locationSource);
				locationSource.setLocation(latLng);
			}
		}
	}

	
	
	protected void adicionaPoligono(GoogleMap map) {
		PolygonOptions p = new PolygonOptions();

		//contornando uma quadra
		p.add(new LatLng(-13.008547, -38.528205));
		p.add(new LatLng(-13.008312, -38.526974));
		p.add(new LatLng(-13.008869, -38.527497));
		p.add(new LatLng(-13.008992, -38.528146));
		p.strokeColor(Color.RED);
		Polygon polygon = map.addPolygon(p);
	}

	protected void adicionaLinha(GoogleMap map) {

		// Desenha uma linha entre dois pontos
		PolylineOptions line = new PolylineOptions();
		line.add(new LatLng(-13.008949, -38.517211));
		line.add(new LatLng(-13.007945, -38.513735));
		line.color(Color.BLUE);

		Polyline polyline = map.addPolyline(line);
		polyline.setGeodesic(true);
	}

	// Adiciona um marcador
	private void adicionarMarcador(GoogleMap map, LatLng latLng) {

		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.position(latLng).title("Meu Marcador").snippet("Aulas Helder Android");
		markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador));

		Marker marker = map.addMarker(markerOptions);


		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			@Override
			public void onInfoWindowClick(Marker marker) {
				LatLng lartLng = marker.getPosition();
				Toast.makeText(getBaseContext(), "Clicou no: " + marker.getTitle() + " > " + lartLng, Toast.LENGTH_SHORT).show();
			}
		});

		// Customiza a janela ao clicar em um marcador
		map.setInfoWindowAdapter(new InfoWindowAdapter() {
			@Override
			public View getInfoWindow(Marker marker) {
				LinearLayout linear = (LinearLayout) this.getInfoContents(marker);
				linear.setBackgroundResource(R.drawable.janela_marker);
				return linear;
			}
			@Override
			public View getInfoContents(Marker marker) {
				// View com o conteudo
				LinearLayout linear = new LinearLayout(getBaseContext());
				linear.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				linear.setOrientation(LinearLayout.VERTICAL);

				TextView t = new TextView(getBaseContext());
				t.setText("Janela");
				t.setTextColor(Color.BLACK);
				t.setGravity(Gravity.CENTER);
				linear.addView(t);
				
				TextView tTitle = new TextView(getBaseContext());
				tTitle.setText(marker.getTitle());
				tTitle.setTextColor(Color.RED);
				linear.addView(tTitle);
				
				TextView tSnippet = new TextView(getBaseContext());
				tSnippet.setText(marker.getSnippet());
				tSnippet.setTextColor(Color.BLUE);
				linear.addView(tSnippet);

				return linear;
			}
		});
	}

	@Override
	public void onCameraChange(CameraPosition position) {
		TextView tDebug = (TextView) findViewById(R.id.tDebug);
		tDebug.setText("Posicao: " + position);
	}

	@Override
	public void onMapClick(LatLng latLng) {
		TextView tDebug = (TextView) findViewById(R.id.tDebug);
		CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
		tDebug.setText("Posicao: " + latLng);

	}
}