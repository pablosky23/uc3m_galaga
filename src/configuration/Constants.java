package configuration;
/*
 * Universidad Carlos III de Madrid (UC3M)
 * Programacion 2016-2017
 */

/*
 * En la clase Constants se almacenan las constantes de las direcciones determinadas por la librería GameBoardGUI.
 * Por otra parte, se ha implementado un uso adicional: Configuración del juego.
 * Actualmente Constants almacena ciertas constantes que determinan el comportamiento del juego en determinados elementos.
 * De esta manera, pueden ser modificadas de forma unificada desde esta clase.
 * 
 * Se pueden modificar aspectos como el tamaño del tablero, el tamaño de la caja de colisión [Hitbox] de los enemigos y 
 * el jugador, la vida máxima, los torpedos máximos del jugador, los puntos obtenidos al eliminar a ciertos enemigo, los
 * puntos de activación de las medallas finales, la frase de bienvenida, el idioma del juego...
 *  
 * 
 */
public class Constants {

	// ## CONFIGURACIÓN GENERAL ## //
	public static final int WIDTH = 17; // Anchura del Tablero
	public static final int HEIGHT = 22; // Altura del Tableo
	public static final int HITBOXSIZE = 5; // Tamaño (XY) de la caja de colisión de los enemigos (Rango de colisión del
											// dardo con el enemigo)
	public static final int MAXTORPEDOS = 5; // Número de torpedos máximo [Jugador]
	public static final int MAXHEALTH = 3; // Vida máxima del jugador

	// ~~ Puntos que otorgan los enemigos ~~ \\
	public static final int ZAKOPOINTS = 100; // Puntos que se obtienen al eliminar a un Zako
	public static final int GOEIPOINTS = 250; // Puntos que se obtienen al eliminar a un Goei
	public static final int COMMANDERPOINTS = 425; // Puntos que se obtienen al eliminar a un Comandante Galaga
	public static final int ENTERPRISEPOINTS = 1000; // Puntos que se obtienen al eliminar a un Enterprise

	// ~~ Puntos a los que se obtienen las medallas { Medalla 1, Medalla 2, Medalla
	// 3} ~~ \\
	public static final int MEDALPOINTS[] = new int[] { 5000, 15000, 30000 };

	// ## TEXTOS Y JUGADOR ## //
	public static final String PLAYERNAME = "Galaga"; // Nombre del jugador | Player Name
	public static final String BOARDTITLE = "Galaga | Pablo Díaz-Heredero García"
			+ "[Universidad Carlos III de Madrid]"; // Título de la ventana del juego
	public static final String WELCOMEPHRASE = "[GALAGA | Pablo | uc3m 2018]" + "\n" + "\n"
			+ "Type help and press Enter to see the" + "\n" + "Command List"; // Mensaje de bienvenida
	public static final String PORTRAIT = "galagaLogo.png"; // Imagen del jugador [ubicada en images]

	// ## IDIOMA ## //
	// public static final String LANGUAGE = "es"; // Desmarcar para establecer
	// idioma en español
	public static final String LANGUAGE = "en"; // Desmarcar para establecer idioma en inglés

	// ## CONFIGURACIONES DE NIVEL ## \\
	// ~~ Probabilidades ~~ \\ {Nivel 1, Nivel 2, Nivel 3, Nivel Final}
	public static final double PROBJUMPLV[] = new double[] { 0.3, 0.4, 0.5, 0.6 }; // Probabilidad de salto de la
																					// formación
	public static final double PROBSHOTLV[] = new double[] { 2, 2.15, 2.20, 2.30 }; // Probabilidad de disparo

	// ~~ Formaciones ~~ \\
	/*
	 * Se establecen las posiciones de los enemigos de forma "Gráfica" en el
	 * siguiente array bidimensional o matriz.
	 * 
	 * {'.'} Espacio vacío | {'Z'} Zako | {'G'} Goei | {'C'} Comandante | {'E'}
	 * Enterprises
	 */
	public static final char LV1FORMATION[][] = new char[][] { 
			{ '.', '.', '.', '.', 'C', 'C', '.', '.', '.', '.' },
			{ 'G', '.', 'G', 'G', '.', '.', 'G', 'G', '.', 'G' }, 
			{ 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z' },
			{ '.', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', '.' }, 
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

	public static final char LV2FORMATION[][] = new char[][] { 
			{ '.', '.', 'C', 'C', '.', '.', 'C', 'C', '.', '.' },
			{ 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G' }, 
			{ 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z' },
			{ 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z' }, 
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

	public static final char LV3FORMATION[][] = new char[][] { 
			{ 'C', '.', 'C', 'C', '.', '.', 'C', 'C', '.', 'C' },
			{ 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G' }, 
			{ 'Z', '.', 'Z', 'Z', '.', '.', 'Z', 'Z', '.', 'Z' },
			{ 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z', 'Z' }, 
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

	public static final char LV4FORMATION[][] = new char[][] { 
			{ 'G', 'Z', 'G', 'E', 'C', 'C', 'E', 'G', 'Z', 'G' },
			{ 'G', 'C', 'G', 'E', 'C', 'C', 'E', 'G', 'C', 'G' }, 
			{ 'G', 'C', 'G', 'E', 'Z', 'Z', 'E', 'G', 'C', 'G' },
			{ 'G', 'E', 'G', 'E', 'C', 'C', 'E', 'G', 'E', 'G' }, 
			{ '.', 'G', '.', 'E', 'Z', 'Z', 'E', '.', 'G', '.' },
			{ '.', 'G', '.', 'E', 'Z', 'Z', 'E', '.', 'G', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

			

	// Movement directions
	public static final int DIR_N = 0;
	public static final int DIR_NNE = 1;
	public static final int DIR_NE = 2;
	public static final int DIR_ENE = 3;
	public static final int DIR_E = 4;
	public static final int DIR_ESE = 5;
	public static final int DIR_SE = 6;
	public static final int DIR_SSE = 7;
	public static final int DIR_S = 8;
	public static final int DIR_SSW = 9;
	public static final int DIR_SW = 10;
	public static final int DIR_WSW = 11;
	public static final int DIR_W = 12;
	public static final int DIR_WNW = 13;
	public static final int DIR_NW = 14;
	public static final int DIR_NNW = 15;

	// The move deltas for the directions: {dX,dY}
	public static final int[][] MOVES = { { 0, -4 }, { 1, -4 }, { 3, -3 }, { 4, -1 }, { 4, 0 }, { 4, 1 }, { 3, 3 },
			{ 1, 4 }, { 0, 4 }, { -1, 4 }, { -3, 3 }, { -4, 1 }, { -4, 0 }, { -4, -1 }, { -3, -3 }, { -1, -4 } };

	// ## CAMINOS PREESTABLECIDOS ## \\
	public static final int[][] PATHZIGZAGLEFT = { 
			{ DIR_SSE, 15 }, { DIR_S, 2 }, { DIR_SSW, 15 }, { DIR_S, 2 }, { DIR_SSE, 15 }, { DIR_S, 2 },
			{ DIR_SSW, 15 }, { DIR_S, 2 } };
	public static final int[][] PATHZIGZAGRIGHT = { 
			{ DIR_SSW, 15 }, { DIR_S, 2 }, { DIR_SSE, 15 }, { DIR_S, 2 }, { DIR_SSW, 15 }, { DIR_S, 2 },
			{ DIR_SSE, 15 }, { DIR_S, 2 } };
	public static final int[][] PATHZIGZAGLEFTBIG = { 
			{ DIR_SE, 15 }, { DIR_S, 2 }, { DIR_SW, 15 }, { DIR_S, 2 }, { DIR_SSE, 15 }, { DIR_S, 2 }, { DIR_SSW, 15 },
			{ DIR_S, 2 } };
	public static final int[][] PATHZIGZAGRIGHTBIG = { 
			{ DIR_SW, 15 }, { DIR_S, 2 }, { DIR_SE, 15 }, { DIR_S, 2 }, { DIR_SSW, 15 }, { DIR_S, 2 }, { DIR_SSE, 15 },
			{ DIR_S, 2 } };
	public static final int[][] PATHCIRCLEANTICLOCKWISE = { 
			{ DIR_S, 15 }, { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_E, 1 }, { DIR_ENE, 1 }, { DIR_NE, 1 },
			{ DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 }, { DIR_WSW, 1 },
			{ DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 15 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 },
			{ DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 } };
	public static final int[][] PATHCIRCLECLOCKWISE = { 
			{ DIR_S, 15 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 },
			{ DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 }, { DIR_ESE, 1 },
			{ DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 15 }, { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_E, 1 },
			{ DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 },
			{ DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 } };
	public static final int[][] PATHCIRCLE = { 
			{ DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 },
			{ DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 }, { DIR_ESE, 1 },
			{ DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_E, 1 },
			{ DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 },
			{ DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 } };
	public static final int[][] PATHENTERPRISELEFT = { 
			{ DIR_SE, 15 }, { DIR_S, 15 }, { DIR_S, 15 }, { DIR_S, 15 } };
	public static final int[][] PATHENTERPRISERIGHT = { 
			{ DIR_SW, 15 }, { DIR_S, 15 }, { DIR_S, 15 }, { DIR_S, 15 } };

}
