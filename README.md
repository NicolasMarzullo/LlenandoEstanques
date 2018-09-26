# LlenandoEstanques
Ejercicio OIA obligatorio


Nivel 2 Problema 3 estanques Certamen Nacional 2008
Versión 2.5 hoja 1 de 1
Llenando estanques
Contribución de Gustavo Dejean y Laura Rivero
Descripción del problema
Un criadero de truchas ha construido un conjunto
de estanques para desarrollar sus actividades.
Los estanques tienen una forma de prisma rectangular,
siendo la superficie de su base si , y su
profundidad pi determinadas. Todos los estanques
tienen su borde superior al mismo nivel.
Los estanques están comunicados por un sistema
de cañerías horizontales cuya extensión y
volumen es completamente despreciable y no
debe considerarse para el análisis del presente
problema. Sin embargo, debe tenerse en cuenta
que las cañerías se han instalado de manera tal
que comunican siempre un estanque con otro,
uniendo la pared de uno a la pared de otro. Esto
puede verse en la siguiente ilustración.
El llenado comienza en el estanque uno. Cuando
el nivel del agua alcanza una cañería lateral,
comienza entonces el llenado del estanque
siguiente.
En el caso de que algún estanque se encuentre
vacío en un momento dado, éste siempre
comenzará a llenarse cuando el nivel del agua del
estanque anterior alcance el nivel de la cañería
lateral que los une.
Se desea saber: Dado un volumen determinado
de agua V, si el sistema de estanques es capaz de
contenerlo o habrá desbordamiento. En caso de
desbordamiento además se quiere saber el
volumen de agua excedente.
En caso de no existir desbordamiento, se quiere
saber: la cantidad de estanques con agua y el
nivel que alcanzó el agua en cada uno de ellos.
Inicialmente el sistema de estanques está vacío.
Datos de entrada
Se recibe un archivo estanques.in del
directorio actual, que contiene:
• Primera línea: La cantidad n de estanques
existentes en el sistema ( 1 ≤ n ≤ 100.000 ).
• Cada una de las siguientes n–1 líneas: la superficie
si de la base del i-ésimo estanque ( 1 ≤ si ≤
400 ) expresada en m2
, su profundidad pei ( 2 ≤
pei ≤ 100 ) expresada en metros y la profundidad
pci ( pei+1 > pci ) ( 1 ≤ pci < pei ) a la que se
encuentra su único caño de salida al estanque
siguiente, medido desde el borde superior y
expresada en metros. Los tres valores separados
por un blanco.
• Anteúltima línea: la superficie sn de la base y la
profundidad pn del último estanque.
• La última línea tiene el volumen V a ingresar al
sistema, expresado en m³ (0 < V < 1.000.000 )
Todas las medidas siempre están dadas en
números enteros.
Datos de salida
El programa debe generar el archivo
estanques.out, en el directorio actual, con:
a) En el caso de existir desborde:
• Una única línea indicando: “Hay desborde: ”
y a continuación la cantidad en metros cúbicos
que rebasarían.
b) En el caso de no existir desborde:
• Primera línea: la cantidad C de estanques que
tienen agua.
• C líneas indicando, separados por un espacio, el
número de estanque y la profundidad medida
desde el fondo del estanque hasta el nivel del
agua, expresada en metros con los decimales
truncados, para cada uno de los estanques
usados.
Puntuación
a) Caso de desborde correcto 100
b) Cantidad de estanques correcta 50 puntos,

 Valores de la profundidad del agua en
cada estanque correctos: 50 puntos
Ejemplo
Si el archivo estanques.in contiene:
4
120 7 4
80 10 2
60 5 1
50 3
2400
El archivo estanques.out será
Hay desborde: 310
En cambio si en la última línea, en vez de 2.400
se ingresase 720, el output sería:
2
1 3
2 4 
