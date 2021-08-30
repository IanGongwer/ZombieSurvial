package me.centy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.centy.zs.game.GameManager;
import me.centy.zs.game.GameState;

public class StartCommand implements CommandExecutor {

	GameManager gm = GameManager.getInstance();

	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("start")) {
			if (!GameState.isState(GameState.Lobby)) {
				player.sendMessage("The game is not in lobby state.");
			} else {
				gm.startGame();
			}
		}
		return false;
	}

}