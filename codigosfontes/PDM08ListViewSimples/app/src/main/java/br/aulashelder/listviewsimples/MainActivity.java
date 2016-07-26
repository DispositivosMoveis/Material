package br.aulashelder.listviewsimples;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private String[] listaEstados;

    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        //Array com os dados que aparecerão na ListView
        listaEstados = new String[] {"Sao Paulo", "Rio de Janeiro", "Minas Gerais", "Bahia",
                "Santa Catarina", "Parana", "Sergipe", "Alagoas"};

        //Cria um ArrayAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaEstados));

    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        //Obtendo o item selecionado
        Object itemSelecionado = this.getListAdapter().getItem(position);
        String estadoSelecionado = itemSelecionado.toString();

        Toast.makeText(this, "Voce selecionou o estado : " + estadoSelecionado, Toast.LENGTH_LONG).show();

    }

}


