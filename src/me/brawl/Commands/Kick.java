package me.brawl.Commands;


import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Kick implements CommandExecutor, Listener {
	
	
 	   
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Kick(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("kick") && sender.hasPermission("brawl.kick")){
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Please specify a player!");
				return true;
			}
			if(args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null) {
					sender.sendMessage(ChatColor.RED + "That player is currently offline!");
					return true;
				}
		            
				if(args.length == 1) {
					Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " has kicked " + target.getName() + " for " + "breaking the rules!");
				target.kickPlayer(ChatColor.RED + "You have been kicked for breaking the rules!");
				}
			}
			}
	
		return true;
}
}

		