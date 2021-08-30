package me.centy.zs.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.centy.zs.game.GameManager;

public class PlayerDeath implements Listener {

	GameManager gm = GameManager.getInstance();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		event.setDeathMessage(player.getDisplayName() + " has been killed.");
		event.setKeepInventory(true);
	}

}