# BowlingGame
**Grupo 2 - Trabajo Grupal Final**
  - Guillermo Soliz Nagatoshi 
  - Patricia Cano Encinas 
  - Alvaro Cardenas Venegas 
  - Manuel Saavedra

**Diseño**
Clase Line --> Objetivo: Gestionar la absatraccion de una linea de bolos: Nombre, Lanzamientos, Faltas y Puntuaciones (Strike, Spare, tiro regular)
Clase Game -- > Objetivo: Gestionar a los jugadores de una partida de bolos, sus lanzamientos y las puntuaciones obtenidas.
Clase AppGameErrorException --> Objetivo: Gestionar los errores controlados (definidos por logica de negocio) para el juego de bolos.

Interface DisplayGame --> Objetivo: Abstraer la visualizacion del juego de la implementacion concreta. 
Clase DisplayInConsole --> Objetivo: Implementacion concreta de la visualizacion en Consola.

Interface InitiateGame --> Objetivo: Abstraer de la fuente/origen de datos el inicio del juego
Clase InitiateFromFile --> Objetivo: Implementacion concreta para inicializar el juego a partir de un archivo de texto.
Clase InitiateSingleGame --> Objetivo: Implementacion concreta para inicializar el juego desde las pruebas unitarias.

**Principios SOLID aplicados**


**Patrones aplicados**
Patron Str

**Pruebas unitarias**
