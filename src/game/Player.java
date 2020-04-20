package game;

import configuration.Constants;
/*
 * 	###### CLASE PLAYER ######
 * 	La clase player contiene todos los atributos y
 * 	métodos relevantes para el objeto jugador.
 * 	
 * 	En esta clase se incluye el array de disparos del
 * 	jugador
 */

public class Player {

	// ## ATRIBUTOS DEL JUGADOR ## \\
	// ~~ Identificación del jugador, características generales ~~ \\
	private int id; // ID del jugador
	private int health; // Vida del jugador
	private int score; // Puntuación del jugador
	private int speed = 3; // Velocidad del juego [Almacenada en el jugador]
	private boolean invencible; // Trigger de invencibilidad / modo dios

	// ~~ Posición, dirección y movimiento ~~ \\
	private int x, y;
	private int direction;

	// ~~ Aspecto visual ~~ \\
	private String sprite;
	private boolean deadAnimation; // Trigger que activa la animación de muerte del jugador-
	private int animationCounter = 0; // Contador para la animación de muerte

	// ~~ Disparos ~~ \\
	private int enemyHits; // Disparos acertados
	private int shotCount; // Contador de disparos emitidos
	Torpedo shot[] = new Torpedo[Constants.MAXTORPEDOS]; // Array de torpedos [Límitados al valor de Constants]

	// ## CONSTRUCTOR ## \\
	public Player(int id, int x, int y, int direction, int health, int score, String sprite) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.health = health;
		this.sprite = sprite;
		this.score = score;
		if (direction >= 0 && direction < 16) {
			this.direction = direction;
		}
		this.sprite = sprite;
	}

	// ## MÉTODOS ## \\

	// ~~ Método de aumento de la puntuación ~~ \\
	public void upScore(int points) { // Aumenta la puntuación en los puntos introducidos
		setScore(getScore() + points);
	}

	// ~~ Método de animación del sprite en función del daño recibido ~~ \\
	public String animateDamage() {
		if (this.health < Constants.MAXHEALTH && this.health != 1) {
			if (this.sprite.equals("player.png")) {
				this.sprite = "playerDamaged0.png";
			} else {
				this.sprite = "player.png";
			}
		} else if (this.health == 1) {
			if (this.sprite.equals("player.png")) {
				this.sprite = "playerDamaged.png";
			} else {
				this.sprite = "player.png";
			}
		}
		return this.sprite;

	}

	// ~~ Método de movimiento del jugador ~~ \\
	public boolean move(int direction, int steps) {
		if (direction < 0 || direction > 16 || steps < 1) {
			// Si la dirección es menor que 0 o la dirección mayor que 16 o los pasos
			// menores que 1, devolvemos falso, no se puede mover.
			return false;
		} else {
			this.direction = direction; // Se establece la dirección del enemigo
			// Cálculo de la X e Y a partir de los deltas
			this.x = this.x + Constants.MOVES[this.direction][0] * steps;
			this.y = this.y + Constants.MOVES[this.direction][1] * steps;
			return true;
		}
	}

	// ~~ Método de reinicio de los atributos del jugador ~~ \\
	public void resetAttributes() {
		this.health = Constants.MAXHEALTH;
		this.score = 0;
		this.enemyHits = 0;
		this.shotCount = 0;
	}

	// ## GETTERS Y SETTERS GENERALES ## \\
	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public String getSprite() {
		return sprite;
	}

	public int getID() {
		return this.id;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setInvencible(boolean invencible) {
		this.invencible = invencible;
	}

	public boolean isInvencible() {
		return invencible;
	}

	public void setDeadAnimation(boolean deadAnimation) {
		this.deadAnimation = deadAnimation;
	}

	public boolean isDeadAnimation() {
		return deadAnimation;
	}

	public void setAnimationCounter(int animationCounter) {
		this.animationCounter = animationCounter;
	}

	public int getAnimationCounter() {
		return animationCounter;
	}

	public void setEnemyHit(int enemyHit) {
		this.enemyHits = enemyHit;
	}

	public int getEnemyHit() {
		return enemyHits;
	}

	public void setShotCount(int shotCount) {
		this.shotCount = shotCount;
	}

	public int getShotCount() {
		return shotCount;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

}
