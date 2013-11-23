package me.brawl.Commands;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Feed implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Feed(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly") && sender.hasPermission("brawl.feed")){
			Player p = (Player) sender;
			p.setFoodLevel(20);
			p.sendMessage(ChatColor.GREEN + "You have killed your apitite!");
			return true;
			
		}
		return false;
	}
}
		