package jab.gun;

import jab.module.Gun;
import jab.module.Module;
import robocode.Bullet;
import robocode.Rules;

class MinimumPower extends Gun {

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
