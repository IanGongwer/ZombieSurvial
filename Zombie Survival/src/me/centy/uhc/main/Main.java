package me.centy.uhc.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.centy.commands.StartCommand;
import me.centy.zs.game.GameState;
import me.centy.zs.listeners.BlockGrowth;
import me.centy.zs.listeners.Break;
import me.centy.zs.listeners.Join;
import me.centy.zs.listeners.Place;
import me.centy.zs.listeners.PlayerDeath;
import me.centy.zs.listeners.PlayerRespawn;
import me.centy.zs.listeners.Quit;
import me.centy.zs.listeners.ZombieDeath;

public class Main extends JavaPlugin {

	public void registerRunnables() {
	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new BlockGrowth(), this);
		getServer().getPluginManager().registerEvents(new Break(), this);
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Place(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
		getServer().getPluginManager().registerEvents(new Quit(), this);
		getServer().getPluginManager().registerEvents(new ZombieDeath(), this);
	}

	public void registerCommands() {
		getCommand("start").setExecutor(new StartCommand());
	}

	public void onEnable() {
		registerRunnables();
		registerListeners();
		registerCommands();
		GameState.setState(GameState.Lobby);
	}

	public void onDisable() {

	}

}