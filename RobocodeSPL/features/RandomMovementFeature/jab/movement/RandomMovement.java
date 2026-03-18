package jab.movement;

import jab.module.Module;
import jab.module.Movement;

/**
 * A random movement strategy that changes direction and speed unpredictably.
 */
public class RandomMovement extends Movement {

	private int moveCount = 0;
	private int moveDirection = 1;
	private int turnDirection = 1;

	public RandomMovement(Module bot) {
		super(bot);
	}

	public void move() {
		if (moveCount <= 0) {
			moveDirection = (Math.random() > 0.5) ? 1 : -1;
			turnDirection = (Math.random() > 0.5) ? 1 : -1;
			moveCount = (int) (Math.random() * 20) + 10;
		}
		moveCount--;
		bot.setMaxVelocity(6);
		bot.setAhead(moveDirection * 100);
		bot.setTurnRight(turnDirection * (Math.random() * 30 + 10));
	}
}
