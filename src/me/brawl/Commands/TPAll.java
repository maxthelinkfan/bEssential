package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPAll implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public TPAll(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("tpall") && sender.hasPermission("brawl.tpall")){
		    	Player p = (Player) sender;
		    	for (Player online : Bukkit.getServer().getOnlinePlayers()){
		    		online.teleport(p.getLocation());
		    		online.sendMessage(ChatColor.GREEN + "You have been tped to " + p.getName());
		    		p.sendMessage(ChatColor.GOLD + "You have tped all players!");
		    		
		    	}
		    	
		    }
			return false;
	}
}