package jab.selectEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jab.module.BotInfo;
import jab.module.Module;
import jab.module.SelectEnemy;

public class RandomSelect extends SelectEnemy {

	private Random random = new Random();

	public RandomSelect(Module bot) {
		super(bot);
	}

	public void select() {
		List<BotInfo> enemies = new ArrayList<BotInfo>();
		for (BotInfo botInfo : bot.botsInfo.values()) {
			if (!botInfo.teammate) {
				enemies.add(botInfo);
			}
		}
		if (!enemies.isEmpty()) {
			bot.enemy = enemies.get(random.nextInt(enemies.size()));
		}
	}
}
