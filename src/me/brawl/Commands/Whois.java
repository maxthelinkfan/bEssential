package me.brawl.Commands;


import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Whois implements CommandExecutor, Listener {
	

 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Whois(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("whois") && sender.hasPermission("brawl.whois")){
			if(args.length <= 0){
				Player p = (Player) sender;
				p.sendMessage(ChatColor.RED + "Invalid Usage! /whois <player>");
				return true;				
			}
			if(args.length > 0){
				Player p = (Player) sender;
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if(args[0].equalsIgnoreCase(t.getName())){
					int health = (int) t.getHealth();
					int loc = (int) t.getLocation().getX();
					int loc2 = (int) t.getLocation().getY();
					int loc3 =  (int) t.getLocation().getZ();
					String w = t.getLocation().getWorld().getName();
					
					p.sendMessage(ChatColor.BLUE + "----- " + t.getName() + "'s info! -----");
					p.sendMessage(ChatColor.RED + "Health: " + health + "/20");
					p.sendMessage(ChatColor.RED + "IP: " + t.getAddress());
					p.sendMessage(ChatColor.RED + "Fly Mode: " +  t.isFlying());
					p.sendMessage(ChatColor.RED + "OP: " + t.isOp());
					p.sendMessage(ChatColor.RED + "Location: " + w + ", " + loc + ", " + loc2 + ", " + loc3);
					p.sendMessage(ChatColor.RED + "Gamemode: " + t.getGameMode());
					p.sendMessage(ChatColor.RED + "Money: $" + Main.economy.getBalance(t.getName()));
				}
			}
		}
		return false;
	}
}

		