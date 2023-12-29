package GestorTareas;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lib20.*;//Libreria donde tengo mis metodos de captura de informacion

public class Gestor
{
	private Datos obd = new Datos();//objeto donde tengo metodos de captura de informacion 
	private List<TareasTDA> tareas = new ArrayList<TareasTDA>();//usa una arraylist por ser mas veloz al insertar en ella 
	private String status = ("pendiente|progreso|completada");//Expresion regular que se usara para evaluar status
	
	public void get_tasks_completed(LinkedList<TareasTDA> lista) {
		tareas.addAll(lista);//Se pasa la informacion de lista a tareas 
	}
	
	public void add_task(String title,String descripcion,String status)
	{
		TareasTDA tarea = null; //creo un objeto del tipo TDA y lo inicializo en null 
		if(status.matches(this.status)){ //evaluo con un matches si el status es valido
			if(!title.isBlank()) {//evaluo que titulo no venga vacio
				if(!descripcion.isBlank()) {//evaluo que descripcion no venga vacio
					tarea = new TareasTDA(); //una ves pasando todas las validaciones podemos proceder a asignar, empezamos inicializando tarea
					tarea.setTitulo(title); //pasamos la informacion a la tarea
					tarea.setDescripcion(descripcion);
					tarea.setEstado(status);
					tareas.add(tarea);// la agregamos a la lista de tareas
				}
				else {
					obd.Println("El campo ('Descripcion') esta vacio porfavor corrige");//de estar vacia corregir el dato descripcion
					descripcion = obd.Cadena("Ingresa la Descripcion:");//reasignamos la descripcion
				}
			}
			else {
				obd.Println("El campo ('Titulo') esta vacio porfavor corrige");//de estar vacia corregir el dato Titulo
				title = obd.Cadena("Ingresa el Titulo:");//reasignamos el titulo
			}
		}else {
			obd.Println("El campo ('status') es incorrecto valores aceptados ('pendiente','progreso','completada')");//en caso no ser validado se debe corregir la informacion
			status = obd.Cadena("Ingresa el Estado de la tarea:");//reasignamos la informacion del Estado
		}
		if(tarea==null)
			this.add_task(title, descripcion, status);
	}
	
	public void get_task_by_status(String status) {
		Set<TareasTDA> tareas = new HashSet<TareasTDA>(this.tareas);//se usa un hashSet por q es mas rapido para obetener la informacion pero mueve el orden 
		for (TareasTDA item:tareas) { //for each para recorrer la lista
			if (item.getEstado().equals(status))//un if para compara el contenido de item en estado al estado buscado
				obd.Println("Titulo:"+item.getTitulo()+", Descripcion:"+item.getDescripcion()+", Estado:"+item.getEstado());//Imprime en consola los elementos q coincidan
		}
	}	
}
