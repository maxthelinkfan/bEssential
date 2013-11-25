package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Gm(Main plugin) {
		this.plugin = plugin;
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("brawl.gm")){
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + "Invalid Usage! /gm <0, 1, 2>");
		        return true;
		      }
		    }
			return false;
	  }
}
