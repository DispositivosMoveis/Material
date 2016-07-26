package br.aulashelder.multimidia;


import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.ArrayList;
import java.io.*;

import java.util.List;



import android.app.Activity;

import android.app.AlertDialog;

import android.content.DialogInterface;

import android.content.Intent;

import android.content.pm.PackageManager;

import android.content.pm.ResolveInfo;

import android.os.Bundle;

import android.speech.RecognizerIntent;

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.Toast;

public class MediaPlayerActivity extends Activity 
									implements OnPreparedListener{

	private MediaPlayer player;
	private VideoView videoView;
	private EditText mEdtResult;
	private static final int REQUEST_CODE = 1;

	private static final int MAX_RESULT = 10;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media_player);
		videoView = (VideoView) findViewById(R.id.videoView);

		// Verifica se o dispositivo suporta

		// reconhecimento de voz

		PackageManager pm = getPackageManager();

		List<ResolveInfo> activities = pm.queryIntentActivities(

				new Intent(

						RecognizerIntent.ACTION_RECOGNIZE_SPEECH),
				0);

		// Nao suporta?
		if (activities.size() == 0) {


		}

	}


	public void btnMicroClick(View v) {

		reconhecerVoz();

	}

	private void reconhecerVoz() {
		// Cria a Intent

		Intent intent =

				new Intent(

						RecognizerIntent.ACTION_RECOGNIZE_SPEECH);



		// Passa os paramentros via Extra

		intent.putExtra(

				RecognizerIntent.EXTRA_LANGUAGE_MODEL,

				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);



		// Opicional: Idioma

		intent.putExtra(

				RecognizerIntent.EXTRA_LANGUAGE,

				"pt-BR");



		// Opicional: Nmero mximo de resultado

		intent.putExtra(

				RecognizerIntent.EXTRA_MAX_RESULTS,

				MAX_RESULT);



		// Texto que sera exibido no recognize speech

		intent.putExtra(

				RecognizerIntent.EXTRA_PROMPT,

				"Aguardando voce falar...");



		startActivityForResult(intent, REQUEST_CODE);

	}


	@Override

	protected void onActivityResult(int requestCode,

									int resultCode, Intent data) {



		// Verifica se o retorno teve sucesso
		if (resultCode == RESULT_OK) {



			if (requestCode == REQUEST_CODE) {



				// Recupera uma lista com os resultados

				// encontrados para o que foi "falado"

				ExibirResultado(

						data.getStringArrayListExtra(

								RecognizerIntent.EXTRA_RESULTS));



				// Tratamento de erro

			} else

			if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {

				//ExibirMsg("Audio error");

			} else

			if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {

				///ExibirMsg("Client error");

			} else

			if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {

/////				ExibirMsg("Network Error");

			} else

			if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {

///				ExibirMsg("No Match");

			} else

			if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {

	//			ExibirMsg("Server Error");

			}

		}

		super.onActivityResult(requestCode, resultCode,

				data);

	}



	private void ExibirResultado(

			ArrayList<String> resultados) {



		// Exibi a lista em um AlertDialog

		AlertDialog.Builder builderSingle =

				new AlertDialog.Builder(MediaPlayerActivity.this);



		builderSingle.setIcon(R.drawable.ic_launcher);

		builderSingle.setTitle("Selecione um Item:");



		// Cria um ArrayAdapter

		final ArrayAdapter<String> arrayAdapter =

				new ArrayAdapter<String>(

						MediaPlayerActivity.this,

						android.R.layout.select_dialog_singlechoice,

						resultados);



		// Botaao Cancelar

		builderSingle.setNegativeButton("Cancelar",

				new DialogInterface.OnClickListener() {



					@Override

					public void onClick(

							DialogInterface dialog,

							int which) {



						dialog.dismiss();

					}

				});



		// Seta o Adapter para o dialog e o

		// evento de click

		builderSingle.setAdapter(arrayAdapter,

				new DialogInterface.OnClickListener() {



					@Override
					public void onClick(

							DialogInterface dialog,

							int which) {



						// Ao clicar no item, mostra o

						// texto selecionado no EditText

					//	mEdtResult.setText(

					//			arrayAdapter.getItem(which));

						String texto  = arrayAdapter.getItem(which);

						File sdcard = android.os.Environment.getExternalStorageDirectory();
						//		Toast.makeText(getApplicationContext(), arquivo, Toast.LENGTH_LONG).show();
						File file = new File(sdcard,texto+".mp3");

						if (sdcard.exists()){
							File[] files = sdcard.listFiles();
							String[] nomes = new String[files.length];
							for (int i=0;i<files.length;i++){
								nomes[i]=files[i].getName();
								//Toast.makeText(getApplicationContext(), "arq"+nomes[i], Toast.LENGTH_LONG).show();
							}


						}

						String arquivo = file.getAbsolutePath();
				//		Toast.makeText(getApplicationContext(), arquivo, Toast.LENGTH_LONG).show();

						Toast.makeText(getApplicationContext(), arquivo, Toast.LENGTH_LONG).show();
						try {
							MediaPlayer player = new MediaPlayer();
							player.setDataSource(arquivo);
					//		Toast.makeText(getApplicationContext(), arquivo, Toast.LENGTH_LONG).show();
					//		player.setDataSource(getApplicationContext(), Uri.parse(android.os.Environment.getExternalStorageDirectory().getPath() + "/teste.mp3"));
							player.prepare();
							player.start();
						}
						catch (Exception e){
							Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
						}
						Intent send = new Intent(Intent.ACTION_SENDTO);
						String uriText = "mailto:" + Uri.encode("helderaragao@gmail.com") +
								"?subject=" + Uri.encode("the subject") +
								"&body=" + Uri.encode("the body of the message");
						Uri uri = Uri.parse(uriText);

						send.setData(uri);

					}

				});



		builderSingle.show();

	}

	public void executarVideo(View v) {
		Uri uri = Uri.parse("android.resource://"+ getPackageName() + 
							"/" + R.raw.sample);
		
		videoView.setVideoURI(uri);
		MediaController mc = new MediaController(this);
		videoView.setMediaController(mc);
		videoView.start();
	}

	public void executarMusicaArquivo(View v) {
		//player = MediaPlayer.create(this, R.raw.kalimba);
	 try {
		 MediaPlayer player = new MediaPlayer();

		 player.setDataSource("/mnt/sdcard/yourdirectory/youraudiofile.mp3");
		 player.prepare();
		 player.start();
	 }
	 catch (Exception e){

	 }

	}
	
	public void executar(View v) {
		if(!player.isPlaying()){
			player.start();
		}
	}

	public void pausar(View v) {
		if(player.isPlaying()){
			player.pause();
		}
	}
	
	public void parar(View v) {
		if(player.isPlaying()){
			player.stop();
		}
	}
	
	public void executarMusicaUrl(View v) {
		liberarPlayer();
		player = new MediaPlayer();
		try {
			Uri uri = Uri.parse("http://<alguma-url>/musica.mp3");
			player.setDataSource(this, uri);
			player.setAudioStreamType(AudioManager.STREAM_MUSIC);
			player.setOnPreparedListener(this);
			player.prepareAsync();
		} catch (Exception e) {}
	}
	
	@Override
	public void onPrepared(MediaPlayer mp) {
		player.start();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		liberarPlayer();
	}
	
	private void liberarPlayer() {
		if(player != null){
			player.release();
		}
	}
}