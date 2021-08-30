package me.centy.zs.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.centy.zs.game.GameManager;

public class Join implements Listener {

	GameManager gm = GameManager.getInstance();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage("");
		Player joinedPlayer = event.getPlayer();
		joinedPlayer.sendMessage("Welcome to Zombie Survival. Use /start to begin the game.");
		joinedPlayer.teleport(gm.getSpawnPoint());
	}

}