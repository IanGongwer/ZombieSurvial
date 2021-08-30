package me.centy.zs.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GameManager {

	private static GameManager single_instance = null;

	private int waveCount = 0;
	private int totalZombies = 0;
	private Location spawnPoint = new Location(Bukkit.getWorld("world"), -385.5, 84.0, 372.5);
	private Location zombieSpawnPoint1 = new Location(Bukkit.getWorld("world"), -341.5, 72.0, 330.5);
	private Location zombieSpawnPoint2 = new Location(Bukkit.getWorld("world"), -387.5, 76.0, 305.5);
	private Location zombieSpawnPoint3 = new Location(Bukkit.getWorld("world"), -348.5, 72.0, 377.5);

	public static GameManager getInstance() {
		if (single_instance == null) {
			single_instance = new GameManager();
		}
		return single_instance;
	}

	public int createWave(int wavenumber) {
		int numberofzombies = ((5 * wavenumber) / 2) + wavenumber;
		return numberofzombies;
	}

	public void spawnWave() {
		if (waveCount > 0) {
			totalZombies = createWave(waveCount) * 3;
			for (int i = 0; i < createWave(waveCount); i++) {
				zombieSpawnPoint1.getWorld().spawnEntity(zombieSpawnPoint1, EntityType.ZOMBIE);
				zombieSpawnPoint2.getWorld().spawnEntity(zombieSpawnPoint2, EntityType.ZOMBIE);
				zombieSpawnPoint3.getWorld().spawnEntity(zombieSpawnPoint3, EntityType.ZOMBIE);
			}
		} else {
			totalZombies = 3;
			zombieSpawnPoint1.getWorld().spawnEntity(zombieSpawnPoint1, EntityType.ZOMBIE);
			zombieSpawnPoint2.getWorld().spawnEntity(zombieSpawnPoint2, EntityType.ZOMBIE);
			zombieSpawnPoint3.getWorld().spawnEntity(zombieSpawnPoint3, EntityType.ZOMBIE);
		}
	}

	public Location getSpawnPoint() {
		return spawnPoint;
	}

	public int getWaveCount() {
		return waveCount;
	}

	public void setWaveCount(int waveNumber) {
		waveCount = waveNumber;
	}

	public int getTotalZombies() {
		return totalZombies;
	}

	public void setTotalZombiesCount(int totalZombieCount) {
		totalZombies = totalZombieCount;
	}

	public void startGame() {
		Bukkit.broadcastMessage("The game has started. Good luck and have fun.");
		Bukkit.broadcastMessage("Now on Wave #0");
		spawnWave();
		GameState.setState(GameState.Ingame);
		ItemStack starter_sword = new ItemStack(Material.STONE_SWORD);
		for (Player allPlayers : Bukkit.getOnlinePlayers()) {
			allPlayers.getInventory().addItem(starter_sword);
		}
	}

	public void stopGame() {
		Bukkit.broadcastMessage("You have beat the zombie apocalypse. Nice work!");
		GameState.setState(GameState.End);
	}

	public void incrementWave() {
		setWaveCount(getWaveCount() + 1);
		Bukkit.broadcastMessage("Now on Wave # " + getWaveCount());
		spawnWave();
	}

	public void upgradeSword() {
		ItemStack upgrade_sword = new ItemStack(Material.IRON_SWORD);
		for (Player allPlayers : Bukkit.getOnlinePlayers()) {
			allPlayers.getInventory().clear();
			allPlayers.getInventory().addItem(upgrade_sword);
		}
		Bukkit.broadcastMessage("All swords upgraded to Iron!");
	}

}