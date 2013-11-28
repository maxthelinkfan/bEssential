package me.brawl.Commands;


import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Warp implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Warp(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("warp")){
			if(args.length <= 0) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.RED + "bBasic Warp Commands:");
				p.sendMessage(ChatColor.GREEN + "/warp set <name> - Set's a warp!");
				p.sendMessage(ChatColor.GREEN + "/warp <name> - Teleport's you to a preset warp!");
				return true;
			}
			if(args.length > 0){
				if(args[0].equalsIgnoreCase("set")){
					if(sender.hasPermission("brawl.setwarp")){
						Player p = (Player) sender;
						return true;						
					}
					else if(args.length > 0) {
						if(args[0].equalsIgnoreCase("delete") || (args[0].equalsIgnoreCase("del"))) {
							if(sender.hasPermission("brawl.delwarp")){
								Player p = (Player) sender;								
							}
							
							
						}
					}
					
				}
				
			}
		}
		return false;
	}
}
