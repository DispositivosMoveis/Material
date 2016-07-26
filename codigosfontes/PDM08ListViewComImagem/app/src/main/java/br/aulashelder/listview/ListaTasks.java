package br.aulashelder.listview;

import java.util.ArrayList;
import java.util.List;


import android.app.ListActivity;
import android.os.Bundle;

public class ListaTasks extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_tasks);
		
		
		Task task1 = new Task("Supermercado",1,R.drawable.tarefafeita);
		Task task2 = new Task("estudar",0,R.drawable.tarefanaofeita);
		Task task3 = new Task("jogar game",1,R.drawable.tarefafeita);
		Task task4 = new Task("comprar livro",0,R.drawable.tarefanaofeita);
		
		List<Task> tasks = new ArrayList<Task>();
		
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		
		
		ListaTasksAdapter tasksAdapter = new ListaTasksAdapter(this,  tasks);
		setListAdapter(tasksAdapter);


	}
	
	
}