package me.brawl.Commands;


import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Message implements CommandExecutor, Listener {
	

 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Message(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("ban") && sender.hasPermission("brawl.ban")){
		}
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "Please specify a player!");
			return true;
		}
		if(args.length == 1){
			sender.sendMessage(ChatColor.RED + "Please enter a message!");
			return true;
		}
		if(args.length == 2){
			Player t = Bukkit.getServer().getPlayer(args[0]);
			
			if(t == null){
				sender.sendMessage(ChatColor.RED + "That player is offline!");
				return true;
			}
			if(args.length == 2){
	            StringBuilder message2 = new StringBuilder();
	            message2.append(args[1]);
	            for (int i = 1; i < args.length; i++) {
	            message2.append(" ");
	            message2.append(args[i]);
	            }
	            t.sendMessage(ChatColor.GRAY + "[" + sender.getName() + " -> me] " + " " + message2);
	            return true;
		
		
		}
		
	}
		return false;
}
}
		