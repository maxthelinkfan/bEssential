package me.brawl.Commands;


import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Day implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Day(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("day") && sender.hasPermission("brawl.time")){
			Player p = (Player) sender;
			p.getLocation().getWorld().setTime(0);
			p.sendMessage(ChatColor.GREEN + "You have set the time to" + ChatColor.RED + " Day " + ChatColor.GREEN + "in world " + ChatColor.RED + p.getLocation().getWorld().getName() + "!");
		}
		return true;
	}
}

		