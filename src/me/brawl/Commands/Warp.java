package me.brawl.Commands;


import java.util.ArrayList;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class Warp implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
	ArrayList<String> warp = new ArrayList<String>();

	
	private Main plugin;
	public Warp(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, final String[] args) {
		if(cmd.getName().equalsIgnoreCase("warp")){
			if(args.length <= 0) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.RED + "bBasic Warp Commands:");
				p.sendMessage(ChatColor.GREEN + "/warp <ID> - Teleports you to a pre-set warp!");
				p.sendMessage(ChatColor.GREEN + "/warp set <ID> - Sets a warp!");
				p.sendMessage(ChatColor.GREEN + "/warp del <ID> - Deletes a warp!");
		
				return true;
			}
			if(args.length > 0){
				if(args[0].equalsIgnoreCase("set")){
					if(sender instanceof Player) {
					if(sender.hasPermission("brawl.setwarp")){
						Player p = (Player) sender;
						settings.getData().set("warps." + "" + args[0] + ".x", p.getLocation().getX());
						settings.getData().set("warps." + "" + args[0] + ".y", p.getLocation().getY());
						settings.getData().set("warps." + "" + args[0] + ".z", p.getLocation().getZ());
						settings.getData().set("warps." + "" + args[0] + ".world", p.getLocation().getWorld().getName());
						settings.saveConfig();
						
						return true;						
					}
					else if(args.length > 0) {
						if(args[0].equalsIgnoreCase("delete") || (args[0].equalsIgnoreCase("del"))) {
							if(sender.hasPermission("brawl.delwarp")){
								Player p = (Player) sender;		
								p.sendMessage(ChatColor.GREEN + "Warp deleted!");
								return true;
							}
							else if (args.length > 0) { 
								if(args[0].equals(settings.getData().contains("warps." + args[0]))) {
									if(sender instanceof Player) {
										final Player p = (Player) sender;
										warp.add(p.getName());
										final double x = settings.getData().getDouble("warps." + "" + args[0] + ".x");
										final double y = settings.getData().getDouble("warps." + "" + args[0] + ".y");
										final double z = settings.getData().getDouble("warps." + "" + args[0] + ".z");
										final World w = Bukkit.getServer().getWorld(settings.getData().getString("warps." + "" + args[0] + ".world"));
										p.sendMessage(ChatColor.GREEN + "Teleporting in 3 seconds, stand still!");
										new BukkitRunnable() {
								          	  public void run() {
								          		  if(p.getLocation().getX() == settings.getData().getDouble("warps." + "" + p.getName()  + ".location" + ".x")){
								          				if(p.getLocation().getZ() == settings.getData().getDouble("warps." + "" + args[0] + ".x")){		          			
								          			  p.sendMessage(ChatColor.GREEN + "Teleporting!");
								          			  p.teleport(new Location(w, x, y, z));
								          				} else {
								          					p.sendMessage(ChatColor.RED + "Teleport canceled!");
								          				
								          		  }
								          		  }
								          	  }
								          	}.runTaskLater(plugin, 60);
									
										return true;
									}
									
								}
							}
							
							
						}
					}
					
				}
				
			}
		}
	}
		return false;
}
}
