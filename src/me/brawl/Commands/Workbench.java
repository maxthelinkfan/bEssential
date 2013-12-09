package me.brawl.Commands;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Workbench implements CommandExecutor {
	
SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Workbench(Main plugin) {
		this.plugin = plugin;
	}
	 
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("workbench") || cmd.getName().equalsIgnoreCase("wb")) {
			Player p = (Player) sender;
			Inventory inv = Bukkit.createInventory(p, InventoryType.WORKBENCH);
			if(args.length <= 0) {
				p.openInventory(inv);
				return true;			
			}
			if(args.length > 0) {
				p.sendMessage(ChatColor.RED + "Invalid arguements for /workbench!");
			
				
				
			}
		}

		return false;
	}

}
