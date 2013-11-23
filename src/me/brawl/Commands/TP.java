package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public TP(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("tp") && sender.hasPermission("brawl.tp")){		    	
		    	if(args.length <= 0) {
		    		sender.sendMessage(ChatColor.RED + "Please define a player, or coords!");
		        return true;
		      }
		      if (args.length > 0) {
		    	  Player p = (Player) sender;
			    	Player target = Bukkit.getServer().getPlayer(args[0]);
		    	  if(args[0].equalsIgnoreCase(target.getName())) {
		    		  p.teleport(target.getLocation());
		    		  p.sendMessage(ChatColor.GREEN + "You have been teleported to " + target.getName() + "!");		    	  
		            return true;
		    	  }		      		      
		      }  else if (args.length > 0) {
		    		  Player p = (Player) sender;
				    	Player target = Bukkit.getServer().getPlayer(args[0]);
		    		  if(target == null) {
		    			  p.sendMessage(ChatColor.RED + "That player is offline!");
		    			  return true;
		    		  }	
		    	  }
		      }		    
			return false;
	  }
}

