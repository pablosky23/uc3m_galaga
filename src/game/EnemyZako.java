package game;
import configuration.Constants;
/*
 * 	###### SUBCLASE ENEMYZAKO ######
 * 	Esta clase establece mediante su propio constructor, los atributos
 * 	de la clase super de la cual hereda.
 * 	
 * 	Tipo de enemigo definido con 'Z'
 * 	Vida del enemigo = 1
 * 
 */
public class EnemyZako extends Enemy {

	// ## CONSTRUCTOR ## \\
	public EnemyZako(int id, int x, int y, int direction, String sprite) {
		super (id, x, y, direction, sprite, 'Z', Constants.ZAKOPOINTS, 1);
	}


	
}