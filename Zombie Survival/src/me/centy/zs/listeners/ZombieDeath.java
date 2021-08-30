package me.centy.zs.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.centy.zs.game.GameManager;

public class ZombieDeath implements Listener {

	GameManager gm = GameManager.getInstance();

	@EventHandler
	public void onZombieDeath(EntityDeathEvent event) {
		if (event.getEntityType() == EntityType.ZOMBIE) {
			gm.setTotalZombiesCount(gm.getTotalZombies() - 1);
			if (gm.getTotalZombies() == 0) {
				if (gm.getWaveCount() == 5) {
					gm.upgradeSword();
				}
				if (gm.getWaveCount() == 10) {
					gm.stopGame();
				} else {
					gm.incrementWave();
				}
			}
		}
	}

}