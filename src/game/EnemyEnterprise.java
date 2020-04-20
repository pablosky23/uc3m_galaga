package game;
import configuration.Constants;
/*
 * 	###### SUBCLASE ENEMYCENTERPRISE######
 * 	Esta clase establece mediante su propio constructor, los atributos
 * 	de la clase super de la cual hereda.
 * 	
 * 	Tipo de enemigo definido con 'E'
 * 	Vida del enemigo = 3
 * 
 */
public class EnemyEnterprise extends Enemy {

	// ## CONSTRUCTOR ## \\
	public EnemyEnterprise(int id, int x, int y, int direction, String sprite) {
		super(id, x, y, direction, sprite, 'E', Constants.ENTERPRISEPOINTS, 3);
	}

}
