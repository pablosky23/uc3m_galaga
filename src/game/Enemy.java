package game;

import configuration.Constants;
import edu.uc3m.game.GameBoardGUI;
/*
 * 	###### CLASE ENEMY ######
 * 	La clase enemy contiene todos los atributos y
 * 	métodos relevantes para los objetos de tipo Enemy.
 * 	Esta clase es una clase super mediante la cual se ha establecido
 * 	la relación de herencia para los 3 tipos de enemigos principales
 * 	
 */

public class Enemy {

	// ## ATRIBUTOS DEL ENEMIGO ## \\
	// ~~ Tablero de la libreria ~~ \\
	protected GameBoardGUI board;

	// ~~ Identificación del enemigo, vida y puntos~~ \\
	protected int id; // ID del enemigo
	protected char type; // Tipo de enemigo
	protected int health; // Vida del enemigo
	public final int POINTS; // Puntos que otorga al ser eliminado

	// ~~ Posición y movimiento ~~ \\
	protected int x, y; // Posiciones X e Y del enemigo
	protected int formationX, formationY; // Posiciones X e Y del enemigo en la formación (enjambre)
	protected int direction; // Dirección hacia la que apunta el enemigo

	// ~~ Animación de entrada ~~ \\
	protected int entryPhase; // Fase en la que se encuentra en la animación de entrada
	protected int entryCircle; // Contador de movimientos (Utilizado para el número de loopings)

	// ~~ Aspecto visual [Sprites] ~~ \\
	protected String sprite;
	protected int animationCounter; // Contador de animación utilizado para las animaciones de muerte

	// ~~ Formación y caminos ~~ \\
	protected boolean inFormation = true; // Trigger del enemigo. Se activa si ha vuelto a la formación tras haber
											// saltado aleatoriamente.
	protected int counterPath; // Contador de pasos
	protected int indexPath; // Dirección en el camino actual
	protected int randomPath; // Almacena un número aletario generado que determina el camino a seguir
	protected int probabilityCounter; // Contador que controla los intervalos de generación de caminos aleatorios.
	protected boolean outBoard; // Boolean que se activa si el enemigo se sale por el tablero.

	// ~~ Muerte | Trigger de animación de muerte | Triggers de bonificaciones ~~ \\
	protected boolean deadAnimation; // Se activa cuando el enemigo muere. Activa la animación de muerte del enemigo
	protected boolean freezed; // Se activa si el enemigo está congelado.

	// ~~ Disparos ~~ \\
	protected int shotCount; // Contador del número de disparos
	protected Torpedo shot[] = new Torpedo[4];

	// ## CONSTRUCTOR ## \\
	public Enemy(int id, int x, int y, int direction, String sprite, char type, int points, int health) {
		this.id = id;
		this.x = x;
		this.y = y;
		if (direction >= 0 && direction < 16) {
			this.direction = direction;
		}
		this.sprite = sprite;
		this.type = type;
		this.POINTS = points;
		this.health = health;
	}

	// ## MÉTODOS ## \\
	// ~~ Método de disminución de vida ~~ \\
	public void decreaseHealth() {
		if (this.health > 0) {
			this.health -= 1;
		}
	}

	// ~~ Getter de obtención del sprite teniendo en cuenta la dirección ~~ \\
	public String getSprite() {

		if (!this.sprite.contains("explosion")) {
			// Solo devolverá el sprite junto a su dirección si no están aplicándose los
			// sprites de la explosión
			String directionCode;
			if (!this.isFreezed()) { // Si no está congelado el enemigo, devuelve el sprite normal

				if (direction <= 9) {
					directionCode = "0" + direction;
				} else {
					directionCode = "" + direction;
				}
				String[] fileName = sprite.split("\\.");

				return fileName[0] + directionCode + "." + fileName[1];

			} else {
				if (direction <= 9) { // Si el enemigo está congelado, devuelve el sprite congelado
					directionCode = "0" + direction;
				} else {
					directionCode = "" + direction;
				}
				String[] fileName = sprite.split("\\.");

				return fileName[0] + directionCode + "Freezed" + "." + fileName[1];
			}
		} else {
			return this.sprite;
		}

	}

	// ~~ Método de movimiento (DIRECCIÓN, PASOS) ~~ \\
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

	// ~~ Método de disparo ~~ \\
	public boolean startShot(GameBoardGUI board) {
		if (this.shotCount < this.shot.length && this.health != 0 && !isOutPath()) {
			this.shot[this.shotCount] = new Torpedo(2000 + this.id * 10 + this.shotCount, this.getX(), this.getY(),
					"torpedo200.png");
			board.gb_addSprite(this.shot[this.shotCount].getID(), "torpedo200.png", true);
			if (this.type != 'E') {
				board.gb_setSpriteImage(this.shot[this.shotCount].getID(), "torpedo200.png");
			} else {
				board.gb_setSpriteImage(this.shot[this.shotCount].getID(), "torpedoEnterprise.png");
			}
			board.gb_moveSprite(this.shot[this.shotCount].getID(), this.shot[this.shotCount].getX(),
					this.shot[this.shotCount].getY());
			board.gb_setSpriteVisible(this.shot[this.shotCount].getID(), true);
			this.shotCount += 1;
			return true;
		} else {
			return false;
		}
	}

	// ~~ Método de seguimiento de caminos ~~ \\
	public void followPath(int[][] matrixPath) {
		if (indexPath >= matrixPath.length) {
			indexPath = 0;
		}
		if (counterPath == matrixPath[indexPath][1]) {
			indexPath++;
			counterPath = 0;
		}
		if (indexPath < matrixPath.length) {
			move(matrixPath[indexPath][0], 1);
		} else {
			indexPath = 0;
		}
		if (indexPath == matrixPath.length - 1) {
			counterPath = 0;
			indexPath = 0;
		}
		counterPath++;
	}

	// ~~ Método para reiniciar los contadores de los caminos cuando se ha empezado
	// uno nuevo ~~ \\
	public void resetPath() {
		this.counterPath = 0;
		this.indexPath = 0;
	}

	// ~~ Contador de control de generación de números aleatorios ~~ \\
	public void upProbCounter() { // Aumenta en una unidad el contador
		this.setProbabilityCounter(this.getProbabilityCounter() + 1);
	}

	public void resetProbCounter() { // Establece a 0 el contador
		this.setProbabilityCounter(0);
	}

	// ## GETTERS Y SETTERS GENERALES ## \\
	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public int getFormationX() {
		return formationX;
	}

	public void setFormationX(int formationX) {
		this.formationX = formationX;
	}

	public int getFormationY() {
		return formationY;
	}

	public void setFormationY(int formationY) {
		this.formationY = formationY;
	}

	public int getID() {
		return this.id;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public void setDeadAnimation(boolean deadAnimation) {
		this.deadAnimation = deadAnimation;
	}

	public boolean isDeadAnimation() {
		return deadAnimation;
	}

	public void setAnimationCounter(int AnimationCounter) {
		this.animationCounter = AnimationCounter;
	}

	public int getAnimationCounter() {
		return animationCounter;
	}

	public char getType() {
		return type;
	}

	public void setFreezed(boolean Freezed) {
		this.freezed = Freezed;
	}

	public boolean isFreezed() {
		return freezed;
	}

	

	public void setInFormation(boolean InFormation) {
		this.inFormation = InFormation;
	}

	public boolean isInFormation() {
		return inFormation;
	}

	public void setOutPath(boolean outPath) {
		this.outBoard = outPath;
	}

	public boolean isOutPath() {
		return outBoard;
	}

	public void setRandomPath(int randomPath) {
		this.randomPath = randomPath;
	}

	public int getRandomPath() {
		return randomPath;
	}

	public void setProbabilityCounter(int probabilityCounter) {
		this.probabilityCounter = probabilityCounter;
	}

	public int getProbabilityCounter() {
		return probabilityCounter;
	}

	public void setEntryPhase(int entryPhase) {
		this.entryPhase = entryPhase;
	}
	public void setEntryCircle(int entryCircle) {
		this.entryCircle = entryCircle;
	}
	public int getEntryPhase() {
		return entryPhase;
	}

	public int getEntryCircle() {
		return entryCircle;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setShotCount(int shotCount) {
		this.shotCount = shotCount;
	}

	public int getShotCount() {
		return shotCount;
	}

}
