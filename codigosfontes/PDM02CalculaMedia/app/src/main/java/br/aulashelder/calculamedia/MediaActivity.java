package br.aulashelder.calculamedia;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class MediaActivity extends Activity {

	 //declaracao dos objetos EditTexts
	 private EditText editTxtNota1;
	 private EditText editTxtNota2;
	 //declaracao do objeto Button
	 private Button btnCalcular;
	//declaracao de um TextView
	 private TextView txtMediaFinal;
	 private double nota1;
	 private double nota2;

 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		//definindo o arquivo de layout da activity
		setContentView(R.layout.activity_media);
		//acessando os objetos EditTexts, Button e TextView declarados no arquivo XML de layout
		editTxtNota1 = (EditText) findViewById(R.id.editTxtNota1);
		editTxtNota2 = (EditText) findViewById(R.id.editTxtNota2);
 		btnCalcular = (Button) findViewById(R.id.btnCalcular);
 		txtMediaFinal = (TextView) findViewById(R.id.txtMediaFinal);
		//definindo um evento no botao, registrando um ouvinte
 		btnCalcular.setOnClickListener(new OnClickListener() {
 		//implementando o metodo onClick
 		@Override
 		public void onClick(View arg0) {
			    //obtendo as notas digitadas
 				nota1 = Double.parseDouble(editTxtNota1.getText().toString());
 				nota2 = Double.parseDouble(editTxtNota2.getText().toString());
				//passando as notas para o metodo calcularMedia
 				Double media = calcularMedia(nota1, nota2);
				//exibindo a nota final no TextView
 				txtMediaFinal.setText(media.toString());
 			}
 		});
 
 	}
 	//metodo para calcular a media
	private double calcularMedia(double n1, double n2) {
		double mediaFinal = (n1 + n2 ) / 2;
		return mediaFinal;
	}
 
}
