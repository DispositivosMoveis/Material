package br.aulashelder.calculamedia;

import br.aulashelder.model.Aluno;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MediaActivity extends Activity {
 
 private EditText txtNota1;
 private EditText txtNota2;

 private Button btnCalcular;
 private TextView txtMediaFinal;
 private double nota1;
 private double nota2;

 
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_media);
 		txtNota1 = (EditText) findViewById(R.id.txtNota1);
 		txtNota2 = (EditText) findViewById(R.id.txtNota2);
 		btnCalcular = (Button) findViewById(R.id.btnCalcular);
 		txtMediaFinal = (TextView) findViewById(R.id.txtMediaFinal);
 		btnCalcular.setOnClickListener(new OnClickListener() {
 
 		@Override
 		public void onClick(View arg0) {
 				nota1 = Double.parseDouble(txtNota1.getText().toString());
 				nota2 = Double.parseDouble(txtNota2.getText().toString());
 				
 				Aluno aluno = new Aluno(nota1,nota2);
 				
 			try{	
 
 				Double resultado = aluno.calcularMedia();
 				txtMediaFinal.setText(resultado.toString());
 			}
 			catch (Exception e){
 				
 				txtMediaFinal.setText(e.getMessage());
 			}
 				
 				
 				
 				
 			}
 		});
 
 	}
 
	
 
}
