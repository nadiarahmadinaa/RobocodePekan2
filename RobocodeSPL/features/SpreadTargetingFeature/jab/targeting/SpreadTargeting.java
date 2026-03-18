package jab.targeting;

import jab.module.Module;
import jab.module.Targeting;
import robocode.util.Utils;

/**
 * Spread targeting - alternates gun offset direction to counter dodging enemies.
 */
public class SpreadTargeting extends Targeting {

	private int spreadDirection = 1;
	private int shotCount = 0;

	public SpreadTargeting(Module bot) {
		super(bot);
	}

	public void target() {
		if (bot.enemy != null) {
			double absoluteBearing = bot.getHeadingRadians() + bot.enemy.bearingRadians;
			double spreadOffset = 0.1 * spreadDirection;
			if (shotCount % 5 == 0) {
				spreadDirection *= -1;
			}
			shotCount++;
			double gunAdjust = Utils.normalRelativeAngle(
				absoluteBearing + spreadOffset - bot.getGunHeadingRadians());
			bot.setTurnGunRightRadians(gunAdjust);
		}
	}
}
