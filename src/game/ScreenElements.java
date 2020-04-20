package game;

import configuration.Constants;
import edu.uc3m.game.GameBoardGUI;
/*
 * 	###### CLASE SCREENELEMENTS ######
 * 	Esta clase contiene todos los elementos auxiliares
 * 	que se muestran por pantalla (textos, bonus, menús, imágenes...)
 * 	con el fin de unificar todos estos elementos en un mismo objeto para facilitar
 * 	su acceso, uso y comprensión.
 * 	
 */

public class ScreenElements {
	// ## ATRIBUTOS ## \\
	// ~~ Tablero de la libreria ~~ \\
	private GameBoardGUI board;
	
	// ~~ Contadores ~~ \\
	private int counter[] = new int[5]; // Contador interno
	private int animPhase[] = new int[25]; // Fases de animaciones de los textos / imagenes
	
	// ## CONSTRUCTOR ## \\
	public ScreenElements(GameBoardGUI board) {
		this.board = board;
	}

	// #### MÉTODOS #### \\
	// ~~ MÉTODO DE ADICIÓN DE TODOS LOS SPRITES DE IMÁGENES AL TABLERO ~~ \\
	public void addAllImageSprites() {
		/*
		 * Nota: el orden de adición de los sprites dictamina su orden de capa, es
		 * decir, los sprites añadidos en el tablero antes que otros se encuentran en
		 * capas inferiores por lo que los sprites que se han añadido después se podrán
		 * superponer.
		 * 
		 * Es por esto que nos interesa añadir el contador de puntuación junto a otros
		 * elementos en primera instancia ya que si no lo hiciésemos, en las pantallas
		 * de menus, pausa etc... el contador se vería por encima.
		 *
		 * ID's RESERVADAS [600 Thru 620] 
		 * 600 - Textos generales 
		 * 601 - Imágenes Bonus Pequeños 
		 * 602 - Menús [Inicial, pausa]
		 * 603 - Logo del juego con animación 
		 * 604 - Pantalla final [Victoria] 
		 * 605 - Fuego artificial 1 [Victoria] 
		 * 606 - Fuego artificial 2 [Victoria] 
		 * 607 - Fuego artificial 3 [Victoria]
		 * 608 - Texto de daño recibido
		 * 610 Thru 614 - CONTADOR -
	     *		610 - Dígito Unidades 
		 *		611 - Dígito Decenas
		 *		612 - Dígito Centenas
		 *      613 - Dígito Millares 
		 *      614 - Dígito MilMillares
		 * 615 - Degradado de los bordes
		 * 640 - Planeta 1
		 * 641 - Planeta 2
		 * 
		 */

		// ~~ SPRITE DE MARCO CON DEGRADADO ~~ \\
		// Este sprite aporta un efecto de "desvanecimiento" a los enemigos
		// cuando salen por los bordes
		board.gb_addSprite(615, "img_gradientBorders.png", true);
		board.gb_setSpriteImage(615, "img_gradientBorders.png", 505, 652);
		board.gb_moveSpriteCoord(615, 86, 112);
		board.gb_setSpriteVisible(615, true);

		
		// ## SPRITES DE FUEGOS ARTIFICIALES [VICTORIA] ## \\
		for (int i = 0; i < 3; i++) {
			board.gb_addSprite(605 + i, "end_firework" + i + "0.png", true);
			board.gb_setSpriteImage(605 + i, "end_firework" + i + "0.png", 300, 300);
			board.gb_moveSpriteCoord(605 + i, -10 * (-190 * i), -20);

		}

		// ## SPRITE DE PANTALLA FINAL [VICTORIA y DERROTA] ## \\
		board.gb_addSprite(604, "img_victory0.png", true);
		board.gb_setSpriteImage(604, "img_victory0.png", 487, 640); // Debe estar en una de las primeras capas
																	// para que el contador
																	// aparezca por encima de esta imagen
		board.gb_moveSpriteCoord(604, 84, 110);
		// ## SPRITES DEL CONTADOR DE PUNTUACIÓN ## \\
		// ~~ Sprite de Unidades ~~ \\
		board.gb_addSprite(610, "scoreNumber_0.png", true);
		board.gb_setSpriteImage(610, "scoreNumber_0.png", 40, 40);
		board.gb_moveSpriteCoord(610, 105, 210);
		// ~~ Sprite de Decenes ~~ \\
		board.gb_addSprite(611, "scoreNumber_0.png", true);
		board.gb_setSpriteImage(611, "scoreNumber_0.png", 40, 40);
		board.gb_moveSpriteCoord(611, 95, 210);
		// ~~ Sprite de Centenas ~~ \\
		board.gb_addSprite(612, "scoreNumber_0.png", true);
		board.gb_setSpriteImage(612, "scoreNumber_0.png", 40, 40);
		board.gb_moveSpriteCoord(612, 85, 210);
		// ~~ Sprite de Millares ~~ \\
		board.gb_addSprite(613, "scoreNumber_0.png", true);
		board.gb_setSpriteImage(613, "scoreNumber_0.png", 40, 40);
		board.gb_moveSpriteCoord(613, 75, 210);
		// ~~ Sprite de MilMillares ~~ \\
		board.gb_addSprite(614, "scoreNumber_0.png", true);
		board.gb_setSpriteImage(614, "scoreNumber_0.png", 40, 40);
		board.gb_moveSpriteCoord(614, 65, 210);
		// ~~ Hacer los dígitos visibles ~~ \\
		for (int i = 610; i < 615; i++) {
			board.gb_setSpriteVisible(i, true);
		}

		// ~~ SPRITE DE TEXTO / AVISOS ~~ \\
		board.gb_addSprite(600, "txt_Welcome.png", true);
		board.gb_setSpriteImage(600, "txt_Welcome.png", 400, 201);
		board.gb_moveSpriteCoord(600, 84, 95);

		board.gb_addSprite(608, "txt_Damaged.png", true);
		board.gb_setSpriteImage(608, "txt_Damaged.png", 400, 201);
		board.gb_moveSpriteCoord(608, 84, 95);

		// ~~ SPRITES DE MENÚS [Inicial, pausa] ~~ \\
		board.gb_addSprite(602, "img_menuSound.png", true);
		board.gb_setSpriteImage(602, "img_menuSound.png", 487, 640);
		board.gb_moveSpriteCoord(602, 84, 110);

		// ## SPRITE DE LOGO ANIMADO ## \\
		board.gb_addSprite(603, "img_logo0.png", true);
		board.gb_setSpriteImage(603, "img_logo0.png", 400, 201);
		board.gb_moveSpriteCoord(603, 85, 48);

	}

	// ## MÉTODOS ESPECÍFICOS ## \\
	// ~~ Mostrar los textos/imágenes (<nombre del texto>, mostrar) ~~ \\
	public void showText(String textName, boolean show) {
		if (show) {
			board.gb_setSpriteVisible(608, false);
			board.gb_setSpriteVisible(600, true);
			board.gb_setSpriteImage(600, "txt_" + textName + ".png", 400, 201);
		} else {
			board.gb_setSpriteVisible(600, false);
		}
	}
	// ~~ Esconder los textos (Método genera) ~~ \\
		public void hideText() {
			board.gb_setSpriteVisible(600, false);
			board.gb_setSpriteVisible(608, false);

		}
		
	// ~~ Mostrar el texto de daño recibido ~~ \\
	public void showTextDamage(boolean show) {
		if (show) {
			hideText();
			board.gb_setSpriteVisible(608, true);
			board.gb_setSpriteImage(608, "txt_Damaged.png", 400, 201);
		} else {
			board.gb_setSpriteVisible(608, false);
		}
	}

	// ~~ Método para mostrar las imágenes inferiores de bonus (<nombre del bonus>,
	// mostrar) ~~ \\
	public void showBonusImage(String imageName, boolean show) {
		if (show) {
			board.gb_setSpriteImage(601, "img_" + imageName + ".png", 60, 60);
		} else {
			board.gb_setSpriteImage(601, "img_bonusEmpty.png", 60, 60);
		}
	}

	// ~~ Mostrar las imágenes del menú principal (<Menu>, mostrar) ~~ \\
	public void showMenu(String menuName, boolean show) {
		if (show) {
			board.gb_setSpriteVisible(602, true);
			board.gb_setSpriteImage(602, "img_" + menuName + ".png", 487, 640);
		} else {
			board.gb_setSpriteVisible(602, false);
		}
	}

	// ~~ Animar el logo inicial ~~ \\
	public void animateInitialLogo(int logoAnimPhase, boolean animate) {
		if (animate) {
			board.gb_setSpriteImage(603, "img_logo" + logoAnimPhase + ".png", 400, 201);
			board.gb_setSpriteVisible(603, true);
		} else {
			board.gb_setSpriteVisible(603, false);
		}

	}

	// ~~ Animar la pantalla de pausa ~~ \\
	public void animatePauseScreen(int pauseAnimPhase, boolean animate) {
		if (animate) {
			board.gb_setSpriteVisible(602, true);
			board.gb_setSpriteImage(602, "img_gamePaused" + pauseAnimPhase + ".png", 487, 640);
		} else {
			board.gb_setSpriteVisible(602, false);

		}
	}

	// ## MÉTODOS DEL CONTADOR DE PUNTUACIÓN ## \\
	// ~~ Método para mostrar los números en el contador (número, <Posición>,
	// mostrar ~~ \\
	public void showScoreNumber(int number, String position) {
		switch (position) {
		case "Units":
			board.gb_setSpriteImage(610, "scoreNumber_" + number + ".png", 40, 40);
			break;
		case "Tens":
			board.gb_setSpriteImage(611, "scoreNumber_" + number + ".png", 40, 40);
			break;
		case "Hundreds":
			board.gb_setSpriteImage(612, "scoreNumber_" + number + ".png", 40, 40);
			break;
		case "Thousands":
			board.gb_setSpriteImage(613, "scoreNumber_" + number + ".png", 40, 40);
			break;
		case "TenThousands":
			board.gb_setSpriteImage(614, "scoreNumber_" + number + ".png", 40, 40);
			break;
		}

	}

	// ~~ Método para obtener los dígitos del contador (puntuación) ~~ \\
	public void getDigits(int playerScore) {
		if (playerScore <= 99999) { // El límite es 99999, si se supera, el contador no se mostrará más
			// El método showScoreNumber(número, Posición en el número, show) establece las
			// imágenes a los sprites (divididos por dígitos) dependiendo del número que
			// esté
			// en esa posición teniendo en cuenta la puntuación del jugador, obteniendo las
			// cifras mediante el módulo
			showScoreNumber(playerScore % 10, "Units");
			showScoreNumber(playerScore % 100 / 10, "Tens");
			showScoreNumber(playerScore % 1000 / 100, "Hundreds");
			showScoreNumber(playerScore % 10000 / 1000, "Thousands");
			showScoreNumber(playerScore % 100000 / 10000, "TenThousands");

		}
	}

	// ~~ Método para obtener los dígitos del contador con animación ~~ \\
	public boolean getDigitsAnimation(int playerScore) {
		if (playerScore <= 99999) { // El límite es 99999, si se supera, el contador no se mostrará más
			// El método showScoreNumber(número, Posición en el número, show) hace visibles
			// los sprites del contador teniendo
			// en cuenta la puntuación del jugador, obteniendo las cifras mediante el módulo
			switch (animPhase[0]) {
			case 0:
				if (counter[0] != playerScore % 10) {
					showScoreNumber(counter[0], "Units");
					counter[0]++;
				} else {
					showScoreNumber(playerScore % 10, "Units");
					counter[0] = 0;
					animPhase[0] = 1;
				}
				break;
			case 1:
				if (counter[0] != playerScore % 100 / 10) {
					showScoreNumber(counter[0], "Tens");
					counter[0]++;
				} else {
					showScoreNumber(playerScore % 100 / 10, "Tens");
					counter[0] = 0;
					animPhase[0] = 2;
				}
				break;
			case 2:
				if (counter[0] != playerScore % 1000 / 100) {
					showScoreNumber(counter[0], "Hundreds");
					counter[0]++;
				} else {
					showScoreNumber(playerScore % 1000 / 100, "Hundreds");
					counter[0] = 0;
					animPhase[0] = 3;
				}
				break;
			case 3:
				if (counter[0] != playerScore % 10000 / 1000) {
					showScoreNumber(counter[0], "Thousands");
					counter[0]++;
				} else {
					showScoreNumber(playerScore % 10000 / 1000, "Thousands");
					counter[0] = 0;
					animPhase[0] = 4;
				}
				break;
			case 4:
				if (counter[0] != playerScore % 100000 / 10000) {
					showScoreNumber(counter[0], "TenThousands");
					counter[0]++;
				} else {
					showScoreNumber(playerScore % 100000 / 10000, "TenThousands");
					counter[0] = 0;
					animPhase[0] = 5;
				}
				break;
			case 5:
				return true;
			}
		}
		return false;
	}

	// ~~ Método para mover el Scoreboard a la posición final en la pantalla de
	// victoria ~~ \\
	public void moveScoreBoardEnd() {
		for (int i = 0; i < 5; i++) {
			board.gb_moveSpriteCoord(614 - i, 100 + (i * 10), 105);
		}
	}
	
	// ~~ Método para añadir las vidas finales [pantalla de victoria] ~~ \\
	public void addEndLives() {
		for (int i = 0; i < Constants.MAXHEALTH; i++) {
			board.gb_addSprite(20 + i, "heartOut.png", true);
			board.gb_setSpriteImage(20 + i, "heartOut.png", 40, 40);
			board.gb_moveSpriteCoord(20 + i, 108 + i * 12, 120);
			board.gb_setSpriteVisible(20 + i, true);
		}
	}

	// ~~ Animar las vidas finales [pantalla de victoria] ~~ \\
	public void getLivesAnimation(int playersHealth) {
		if (animPhase[1] < playersHealth) {
			new sound.SoundLib("sound/sound_heartUp.wav").start();
			switch (animPhase[1]) {
			case 0:
				board.gb_setSpriteImage(20, "heart.png", 40, 40);
				animPhase[1]++;
				break;
			case 1:
				board.gb_setSpriteImage(21, "heart.png", 40, 40);
				animPhase[1]++;
				break;
			case 2:
				board.gb_setSpriteImage(22, "heart.png", 40, 40);
				animPhase[1]++;
				break;
			}
		}

	}

	// ## FUEGOS ARTIFICIALES FINALES ## \\
	public void getFireworkEndEffect(int fireworkNumber) {
		board.gb_moveSpriteCoord(605 + fireworkNumber, animPhase[12 + fireworkNumber],
				animPhase[6 + fireworkNumber]);
		board.gb_setSpriteVisible(605 + fireworkNumber, true);
		board.gb_setSpriteImage(605 + fireworkNumber,
				"end_firework" + fireworkNumber + animPhase[15 + fireworkNumber] + ".png", 300, 300);
		if (animPhase[15 + fireworkNumber] < 7) {
			animPhase[15 + fireworkNumber]++;
		} else {
			animPhase[15 + fireworkNumber] = 0;
			animPhase[12 + fireworkNumber] = (int) (Math.random() * (140 - (30 + 10 * fireworkNumber)) + 1) + 30;
			animPhase[6 + fireworkNumber] = (int) (Math.random() * (190 - (40 + 10 * fireworkNumber)) + 1) + 40;
		}

	}
	public void setCounter(int[] counter) {
		this.counter = counter;
	}
	
	public int[] getCounter() {
		return counter;
	}



}
