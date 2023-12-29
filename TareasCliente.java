package GestorTareas;

import java.util.LinkedList;

import lib20.Datos;//Libreria donde tengo mis metodos de captura de informacion

public class TareasCliente
{
	public static void main(String[] args)
	{
		Datos obd = new Datos();//objeto donde tengo metodos de captura de informacion
		Gestor gestor = new Gestor();//Creamos un objeto de Gestor para usarlo mas adelante
		LinkedList<TareasTDA> tareas = new LinkedList<TareasTDA>();//Lista que se parasara en el metodo get_tasks_completed
		String [] //lista con informacion de las tareas
			listaTitulos = new String[] {"Análisis de Requisitos","Diseño","Desarrollo","Pruebas","Gestión de Versiones y Control de Código"},
			listaDescripcion = new String[] {"Entender y clarificar los requisitos del proyecto.",
												"Crear un diseño de alto nivel del sistema.",
												"Implementar el código del software.",
												"Planificar y ejecutar pruebas de software.",
												"Utilizar sistemas de control de versiones (por ejemplo, Git)"},
			listaStatus =  new String[] {"completada","completada","progreso","progreso","pendiente"};
		
		for (int x=0;x<listaTitulos.length;x++) { // for que recorre las listas de datos y las transfiere tareas esta lista 
			//no se evalua ya que para pasar un conjunto de datos extenso deberia venir validada la informacion
			TareasTDA tarea = new TareasTDA();// empezamos la asignacion del objeto y le pasamos los datos necesarios
			tarea.setTitulo(listaTitulos[x]);
			tarea.setDescripcion(listaDescripcion[x]);
			tarea.setEstado(listaStatus[x]);
			tareas.add(tarea);//Se agrega la el objeto a la lista de tareas
		}
		
		long inicio = System.currentTimeMillis();//Empieza el cronometro en milisegundos
		gestor.get_tasks_completed(tareas);// metodo que recibe una lista de tareas del tipo LinkedList<TareasTDA> 
		// los datos ('Titulo','Descripcion') se evaluan q no vengan vacios y el Estado que sea ("completada","progreso","pendiente")
		gestor.add_task("Documentación", "Documentar el código fuente", "completada");// se agrega elementos una tarea nueva Titulo/Descripcion/Status
		gestor.get_task_by_status("pendiente");//Buscar tareas por Estado 
		long fin = System.currentTimeMillis();//Termina el cronometro en milisegundos
		obd.Println("Tiempo transcurrido:"+(fin-inicio)/1000+"seg");//Se muestra el tiempo recurrido en el proceso se divide entre 1000 para q sea en segundos
		/*
		 * La complejidad espacial -> nota: antes no lo conocia asi q lo investigue. 
		 * 		se uso "Datos" un objeto para captura de informacion lo hace variable pero solo se uso para captura de cadenas que O(1) + O(n) por cada recursion al ingresar datos erroneos
		 * 		se uso una lista Tipo Arraylist la cual seria O(n) en este ejemplo se uso 6 tareas por lo tanto seria O(6)
		 * 		En el metodo de add_task este tiene recursividad por lo tanto es O(2^n) donde n refleja la cantidad de repeticiones
		 * 			objeto de tareas declarado y asignado 0-1
		 * 			los arguementos del metodo add_task tienen O(1)
		 * 			0-1 reasignacion por ingresar al metodo O(1)
		 * 		En el metodo de get_task_by_status 
		 * 			los arguementos del metodo get_task_by_status tienen O(1)
		 * 			se uso una lista tipo SetHash la cual seria O(n) en este ejemplo se uso 6 tareas por lo tanto seria O(6)
		 * 			para mostrar el mensaje O(1)
		 * */
	}
}
