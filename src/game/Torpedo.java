package game;
/*
 * 	###### CLASE TORPEDO ######
 * 	La clase torpedo contiene todos los atributos y
 * 	métodos relevantes para los objetos de tipo Torpedo.
 * 	
 */

public class Torpedo {
	// ## ATRIBUTOS DEL TORPEDO ## \\
	// ~~ Identificación del torpedo, posición X e Y, Sprite y trigger de salida ~~
	// \\
	private int id;
	private int x, y;
	private String sprite;
	private boolean out; // Se activa si el torpedo ha impactado contra un enemigo / jugador o se ha
							// salido del tablero

	// ## CONSTRUCTOR ## \\
	public Torpedo(int id, int x, int y, String sprite) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	// ## GETTERS Y SETTERS GENERALES ## \\
	public int getID() {
		return this.id;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}


	public String getSprite() {
		return this.sprite;
	}

	public void shotMoveNorth() {
		this.y = this.y - 10;
	}

	public void shotMoveSouth() {
		this.y = this.y + 10;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public boolean isOut() {
		return out;
	}

}
