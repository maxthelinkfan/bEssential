package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class I implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	public I(Main plugin) {
		this.plugin = plugin;
	}
	

	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("i") && sender.hasPermission("brawl.i")){
		    	if(args.length <= 0) {
		    		Player p = (Player) sender;
		    		p.sendMessage(ChatColor.RED + "Invalid Usage! /i <item>");
		    		return true;
		    	}
		    	if(args.length > 0) {
		    		Player p = (Player) sender;
		    			Material mat = Material.getMaterial(args[0].toUpperCase());
		    			if(mat == null) {
		    			} else {
		    				ItemStack mat2 = new ItemStack(mat);
		    				p.getInventory().addItem(mat2);
		    				p.sendMessage(ChatColor.GREEN + "Added " + mat.toString().toUpperCase() + " to your inventory!");
		    			}	    					    				
		    			}
		    		}	    	
			return false;		    	
		    }
	  }

		    