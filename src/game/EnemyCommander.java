package game;
import configuration.Constants;
/*
 * 	###### SUBCLASE ENEMYCOMMANDER ######
 * 	Esta clase establece mediante su propio constructor, los atributos
 * 	de la clase super de la cual hereda.
 * 	
 * 	Tipo de enemigo definido con 'C'
 * 	Vida del enemigo = 2
 * 
 */
public class EnemyCommander extends Enemy {

	// ## CONSTRUCTOR ## \\
	public EnemyCommander(int id, int x, int y, int direction, String sprite) {
		super(id, x, y, direction, sprite, 'C', Constants.COMMANDERPOINTS, 2);
	}

}
