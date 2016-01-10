package io.github.jisaacs1207.skillbooks;

import org.bukkit.entity.Player;

public class Schedules{
	public static class increasePlayTimeSecond implements Runnable {
		@Override
		public void run() {
        	for(Player player:SkillBooks.plugin.getServer().getOnlinePlayers()){
        		String playerName=player.getName();
        		Methods.addToPlaytime(playerName);
        	}
        }
	}
	 
	public static class saveStats implements Runnable {

		@Override
		public void run() {
			for(Player player:SkillBooks.plugin.getServer().getOnlinePlayers()){
				String playerName=player.getName();
				Methods.saveMapToPFile(playerName);
			}
		}
	}
}