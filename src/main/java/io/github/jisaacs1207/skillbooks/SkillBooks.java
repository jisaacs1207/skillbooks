package io.github.jisaacs1207.skillbooks;

import java.io.File;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkillBooks extends JavaPlugin implements Listener{
	public static SkillBooks plugin;
	public static HashMap<String, PlayerConfig> playerStats = new HashMap<String, PlayerConfig>();
	
	@Override
	public void onEnable() {
		plugin = this;
		
		getServer().getPluginManager().registerEvents(this, this);
		saveConfig();
		registerEvents(this, new SkillsMovement(), new Commands(), new SkillsWeapons(), new SkillsDefense(), 
				new SkillsCommands(), new SkillsZoology(), new SkillsBotany(), new SkillsMagic(), new SkillsCrafting());
		for(Player player:plugin.getServer().getOnlinePlayers())Methods.populateMapFromPFile(player.getName()); 
		getCommand("skillbooks").setExecutor(new Commands());
		getCommand("sb").setExecutor(new Commands());
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Schedules.increasePlayTimeSecond(), 20L, 20L);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Schedules.saveStats(), 20L, 6000L);
		
        
	}

	@Override
	public void onDisable() {
		for(Player player:plugin.getServer().getOnlinePlayers())Methods.saveMapToPFile(player.getName());
		saveConfig();
		playerStats=null;
		plugin = null;
        getServer().getScheduler().cancelAllTasks();
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
	}
	
	// Write a config file for each player
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerJoinEvent(PlayerJoinEvent event){

		String player = event.getPlayer().getName();
		//Create a reference to (playername).yml
		File playerfile = new File(getDataFolder()+"/players/"+player);

		//Check if file exists in the referenced location
		if(!playerfile.exists())
		{	
			// profile creation 
			Methods.generateNewPlayerFile(player);
		}	
		Methods.populateMapFromPFile(player);
		Methods.updateLastJoin(player);
	}
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerQuitEvent(PlayerQuitEvent event){
		String player = event.getPlayer().getName();
		Methods.saveMapToPFile(player);
		playerStats.put(player, null);
	}
}
