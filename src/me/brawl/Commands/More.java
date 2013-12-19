package me.brawl.Commands;


import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class More implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public More(Main plugin) {
		this.plugin = plugin;
	}
	
	public void more(Player player) {
		player.getItemInHand().setAmount(64);
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("more")) {			
			Player p = (Player) sender;
			if(p.hasPermission("brawl.more")) {
			more(p);
			
			}
			
		}
		return false;
	}
}