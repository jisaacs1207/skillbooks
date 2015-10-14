package io.github.jisaacs1207.skillbooks;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkillBooks extends JavaPlugin implements Listener{
	public static SkillBooks plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		saveConfig();
		registerEvents(this, new SkillsMovement(), new Commands(), new SkillsWeapons(), new SkillsDefense(), 
				new SkillsCommands(), new SkillsZoology(), new SkillsBotany(), new SkillsMagic(), new SkillsCrafting());
		getCommand("skillbooks").setExecutor(new Commands());
		getCommand("sb").setExecutor(new Commands());
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
	}
	
}
