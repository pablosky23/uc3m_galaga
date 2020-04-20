package game;
import configuration.Constants;
/*
 * 	###### SUBCLASE ENEMYGOEI ######
 * 	Esta clase establece mediante su propio constructor, los atributos
 * 	de la clase super de la cual hereda.
 * 	
 * 	Tipo de enemigo definido con 'G'
 * 	Vida del enemigo = 1
 * 
 */
public class EnemyGoei extends Enemy {

	// ## CONSTRUCTOR ## \\
	public EnemyGoei(int id, int x, int y, int direction, String sprite) {
		super(id, x, y, direction, sprite, 'G', Constants.GOEIPOINTS, 1);
	}
}