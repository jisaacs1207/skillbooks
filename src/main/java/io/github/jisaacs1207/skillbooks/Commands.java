package io.github.jisaacs1207.skillbooks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmnd, String string, String[] args) {
		String cmd = cmnd.getName();
		if ((cmd.equalsIgnoreCase("skillbooks"))||(cmd.equalsIgnoreCase("sb"))){
			Player player = (Player) sender;
			
			// no args
			//
			if (args.length==0){
				player.sendMessage("Chickenpotpie");
			}
			
			// help (<empty>,<all skills>,<all skills commands>,<all admin commands> )
			
			else if (args[0].equalsIgnoreCase("help") && args.length==1){
				player.sendMessage("h1");
			}
			else if (args[0].equalsIgnoreCase("help") && args.length==2){
				player.sendMessage("h2");
			}
			
			// skills (<empty>,pause,resume,stop,forget,lock,decrease,increase)
			
			else if (args[0].equalsIgnoreCase("skills") && args.length==1){
				player.sendMessage("s1");
			}
			else if (args[0].equalsIgnoreCase("skills") && args.length==2){
				player.sendMessage("s2");
			}
			
			// admin (<empty>,inspect, setskill, setskillall, reload)
			
			else if (args[0].equalsIgnoreCase("admin") && args.length==1){
				player.sendMessage("a1");
			}
			else if (args[0].equalsIgnoreCase("admin") && args.length==2){
				player.sendMessage("a2");
			}
			else if (args[0].equalsIgnoreCase("admin") && args.length==3){
				if (args[1].equalsIgnoreCase("inspect")){
					Methods.inspectPlayer(player, args[2]);
				}
			}
			else if (args[0].equalsIgnoreCase("admin") && args.length==4){
				if (args[1].equalsIgnoreCase("setskillall")){
					Methods.setSkillAll(player, args[2], args[3]);
				}
				else if (args[1].equalsIgnoreCase("inspect")){
					Methods.inspectSkill(player, args[2], args[3]);
				}
			}
			else if (args[0].equalsIgnoreCase("admin") && args.length==5){
				if (args[1].equalsIgnoreCase("setskill")){
					Methods.setSkillLevel(player, args[2], args[3], args[4], true);
				}
			}
			
			// catchall
			
			else{
				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "SB" + ChatColor.GRAY + "] " + ChatColor.WHITE +  "Unknown command.");
			}
			
		}
		return false;
	}
}
