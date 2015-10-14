package io.github.jisaacs1207.skillbooks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmnd, String string, String[] args) {
		String cmd = cmnd.getName();
		if (cmd.equalsIgnoreCase("skillbooks")){
			Player player = (Player) sender;
			player.sendMessage("Skillbooks!");
		}
		return false;
	}
}
