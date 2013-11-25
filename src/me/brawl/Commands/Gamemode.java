package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Gamemode(Main plugin) {
		this.plugin = plugin;
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("brawl.gamemode")){
		      if (args.length <= 0) {
		        sender.sendMessage(ChatColor.RED + "Invalid Usage! /gm <0, 1, 2>");
		        return true;
		      }
		      else  if (args.length > 0) {
		    	  if(args[0].equalsIgnoreCase("0")){
		            Player p = (Player)sender;
		            p.setGameMode(GameMode.SURVIVAL);
		            p.sendMessage(ChatColor.GREEN + "Gamemode set to Surival!");
		            return true;
		    	  }
		    	  else if (args.length > 0) {
		    		  if(args[0].equalsIgnoreCase("1")) {
		    			  Player p = (Player)sender;
		    			  p.setGameMode(GameMode.CREATIVE);
		    			  p.sendMessage(ChatColor.GREEN + "Gamemode set to Creative!");
		    			  return true;
		    		  }
		    		  else if(args.length > 0) {
		    			  if(args[0].equalsIgnoreCase("2")) {
		    				  Player p = (Player)sender;
		    				  p.setGameMode(GameMode.ADVENTURE);
		    				  p.sendMessage(ChatColor.GREEN + "Gamemode set to Adventure!");
		    				  return true;
		    			  }
		    		  }		           
		          }
		        }
		      }
		    
			return false;
	  }
	  
}