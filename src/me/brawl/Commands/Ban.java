package me.brawl.Commands;


import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;

public class Ban implements CommandExecutor, Listener {
	

 	   
    

	
	private Main plugin;
	public Ban(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("ban") && sender.hasPermission("brawl.ban")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player!");
				return true;
			}
				if(args.length == 1){
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if(target == null){
						sender.sendMessage(ChatColor.RED + "That player is offline!");						
						return true;
					}
					if(args.length == 1){
						Bukkit.broadcastMessage(ChatColor.GOLD + target.getName() + " has been banned by " + sender.getName() + " for breaking the rules!");
						target.setBanned(true);
						target.kickPlayer(ChatColor.RED + "You have been banned!");
					}
				}
			}
		
		return false;
	}
}
			

		