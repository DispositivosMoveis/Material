package br.aulashelder.webview;






import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.activity_web_view);
		//instanciando um objeto navegador do tipo WebView
		WebView navegador = (WebView) findViewById(R.id.webview);

		
		//definindo as configura��es do navegador
		WebSettings webSettings = navegador.getSettings();

		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(false);
		
		navegador.loadUrl("http://www.google.com");
		
//exemplo com a url apontando para um arquivo
		/*String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
		navegador.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);*/
		//navegador.loadUrl("http://drive.google.com/viewerng/viewer?url="+pdf);
		navegador.loadData("http://files.parsetfss.com/1ea5c64c-fe04-4e28-974e-a226edb02ba5/tfss-2db6bced-e95b-4eba-8930-e3d908ddb4dd-audio-1450387397959.mp3");
		

	}
}