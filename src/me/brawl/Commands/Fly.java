package me.brawl.Commands;


import java.util.ArrayList;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Fly implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
	public ArrayList<String> bfly = new ArrayList<String>();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Fly(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly") && sender.hasPermission("brawl.fly")){
			
			Player p = (Player) sender;
			if(!bfly.contains(p.getName())) {
			p.setAllowFlight(true);
			p.setFlying(true);
			p.sendMessage(ChatColor.GREEN + "You can now fly!");
			bfly.add(p.getName());
			return true;			
		} 
		else {
			if(bfly.contains(p.getName())) {
		p.setAllowFlight(false);
		p.setFlying(false);
		p.sendMessage(ChatColor.GREEN + "You have disabled fly!");
		bfly.remove(p.getName());
		return true;
	}
}
}
		return false;
}
}