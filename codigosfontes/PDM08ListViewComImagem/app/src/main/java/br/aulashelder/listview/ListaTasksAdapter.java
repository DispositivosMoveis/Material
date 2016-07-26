package br.aulashelder.listview;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaTasksAdapter extends ArrayAdapter<Task> {

	private Context context;
	private List<Task> tasks = null;

	public ListaTasksAdapter(Context context,  List<Task> tasks) {
		super(context,0, tasks);
		this.tasks = tasks;
		this.context = context;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Task task = tasks.get(position);
		
		if(view == null)
			view = LayoutInflater.from(context).inflate(R.layout.item_list_task, null);

		ImageView imageViewTask = (ImageView) view.findViewById(R.id.image_view_task);
		imageViewTask.setImageResource(task.getImagem());
		
		TextView textViewNomeTask = (TextView) view.findViewById(R.id.text_view_nome_task);
		textViewNomeTask.setText(task.getNome());
		
		TextView textViewStatus = (TextView)view.findViewById(R.id.text_view_status_task);
		String textoStatus = String.valueOf(context.getString(R.string.status)+" "+ task.getStatus());
		textViewStatus.setText(textoStatus);

		return view;
	}
}