# BowlingGame
**Grupo 2 - Trabajo Grupal Final**
  - Guillermo Soliz Nagatoshi 
  - Patricia Cano Encinas 
  - Alvaro Cardenas Venegas 
  - Manuel Saavedra

**Diseño**   
Clase Line --> Objetivo: Gestionar la absatraccion de una linea de bolos: Nombre, Lanzamientos, Faltas y Puntuaciones (Strike, Spare, tiro regular).   
Clase Game -- > Objetivo: Gestionar a los jugadores de una partida de bolos, sus lanzamientos y las puntuaciones obtenidas.   
Clase AppGameErrorException --> Objetivo: Gestionar los errores controlados (definidos por logica de negocio) para el juego de bolos.   

Interface DisplayGame --> Objetivo: Abstraer la visualizacion del juego de la implementacion concreta.    
Clase DisplayInConsole --> Objetivo: Implementacion concreta de la visualizacion en Consola.    

Interface InitiateGame --> Objetivo: Abstraer de la fuente/origen de datos el inicio del juego.   
Clase InitiateFromFile --> Objetivo: Implementacion concreta para inicializar el juego a partir de un archivo de texto.   
Clase InitiateSingleGame --> Objetivo: Implementacion concreta para inicializar el juego desde las pruebas unitarias.   

**Principios SOLID aplicados**   
**SRP** Cada clase tiene una solo responsabilidad y razon para el cambio.  
**OCP** La implementaciones realizadas tienen poca probabilidad de cambio (modificacion) pero si pueden ser extendidas incluyendo nuevas implementaciones a partir de los comportamientos ya definidos.    
**ISP** EL diseño considera interfaces especificas con metodos abstractos (DisplayGame, InitiateGame) que se utilicen por los clientes, las interfaces estan implementadas en clases concretas para los comportamientos de visuarlizacion en consola e inicializacion desde un archivo de texto plano.   

**Patrones aplicados**   
Patron Strategy: Se ha utilizado para la implementacion de DisplayGame e InitiateGame.

**Pruebas unitarias**   
Se ha implementado pruebas unitarias representativas para validar las jugadas de Strike, Spare, Juego Perfecto, Juego con Faltas y Juego sin ningun bolo derribado.   
