package me.brawl.Commands;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class List implements CommandExecutor, Listener{

SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public List(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("list")){
			Player p = (Player)sender;
			Player[] names = Bukkit.getServer().getOnlinePlayers();
			p.sendMessage(ChatColor.GOLD + "Currently Online Players: " + "" + Bukkit.getServer().getOnlinePlayers().length + "/120");
			p.sendMessage(ChatColor.GOLD + "" + names);
			
			
		}
		return false;
	
	
	
}
}
