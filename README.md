#Laboratorio Grafos
###Laboratorio Datos II

Crear una aplaicación en Java para construir un grafo dirigido de acuerdo a las siguientes condiciones

**PARTE 1  (1.0/5.0)**

+	La aplicación debe ser desarrollada con JFrame
+	Para crear el grafo el usuario debe ingresar inicialmente la cantidad de vértices
+	Por cada vértice el usuario debe ingresar la cantidad de aristas.
+	Por cada arista el usuario debe ingresar el vértice destino y el peso de la arista
+	A medida que se ingresa la información se guarda en memoria la matriz de adyacencia y la lista enlazada que representan el grafo
+	Al finalizar el ingreso de datos, se debe mostrar una tabla con la matriz de adyacencia.

**PARTE 2  (1.5/5.0)**

+	Crear 1 botón para guardar los archivos:
	+	C:\apps\matriz.txt: Representación en la matriz
	+	C:\apps\lista.txt : Representación en la lista
+	Crear 1 botón para cargar desde archivos:
	+	C:\apps\matriz.txt: Representación en la matriz
	+	C:\apps\lista.txt: Representación en la lista
	
_Al cargar los archivos se debe actualizar la tabla que muestra la matriz de adyacencia_

**PARTE 3  (1.5/5.0)**

+	Crear 1 botón para mostrar el recorrido DFS (con la matriz y con la lista)
+	Crear 1 botón para mostrar el recorrido BFS (con la matriz y con la lista)

**PARTE 4 (1.0/5.0)**

+	Crear un botón para implementar el algoritmo Dijkstra sobre el grafo. El desarrollador es libre de elegir sobre qué estructura lo implementa.

	+	El usuario debe ingresar el vértice origen
	+	El programa debe mostrar el costo mínimo de ir desde el vértice origen hacia cada uno de los otros vértices en el grafo.

_El formato de los archivos es:_

**C:\apps\matriz.txt**  
	
0,3,4,0,0  
0,0,4,5,0  
2,0,0,8,9  
2,3,4,0,4  
0,0,5,0,0

**C:\apps\lista.txt**  
1->2(3)->3(4)  
2->3(4)->4(5)  
3->1(2)->4 (8)->5 (9)  
4 ->1(2)->2(3)->3(4)->5(4)  
5->3(5)  

***

**Entrega: Sábado 23 de septiembre 11:30PM**
