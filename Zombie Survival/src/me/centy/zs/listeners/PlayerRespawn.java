package me.centy.zs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.centy.zs.game.GameManager;

public class PlayerRespawn implements Listener {

	GameManager gm = GameManager.getInstance();

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		event.setRespawnLocation(gm.getSpawnPoint());
	}

}