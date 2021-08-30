package me.centy.zs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class BlockGrowth implements Listener {

	@EventHandler
	public void onBlockGrow(BlockGrowEvent event) {
		event.setCancelled(true);
	}

}