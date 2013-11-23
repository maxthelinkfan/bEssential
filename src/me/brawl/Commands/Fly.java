package me.brawl.Commands;


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
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Fly(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fly") && sender.hasPermission("brawl.fly")){
			
			Player p = (Player) sender;
			p.setAllowFlight(true);
			p.setFlying(true);
			p.sendMessage(ChatColor.GREEN + "You can now fly!");
			return true;			
		} 
		else {		
		Player p = (Player) sender;
		p.setAllowFlight(false);
		p.setFlying(false);
		p.sendMessage(ChatColor.GREEN + "You have disabled fly!");
		return true;
	}
}
}