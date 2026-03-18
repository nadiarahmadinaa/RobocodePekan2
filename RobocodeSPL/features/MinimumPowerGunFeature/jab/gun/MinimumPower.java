package jab.gun;

import jab.module.Gun;
import jab.module.Module;
import robocode.Bullet;
import robocode.Rules;

/**
 * A gun that always fires at minimum bullet power.
 * Fires very rapidly with low energy cost per shot.
 */
public class MinimumPower extends Gun {

	public MinimumPower(Module bot) {
		super(bot);
	}

	public void fire() {
		if (bot.enemy != null) {
			double bulletPower = Rules.MIN_BULLET_POWER;
			bot.bulletPower = bulletPower;
			if (bot.getGunHeat() == 0) {
				Bullet b = bot.setFireBullet(bulletPower);
				bot.registerBullet(b);
			}
		}
	}
}
