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

public class Ban implements CommandExecutor, Listener {
	
	SettingsManager settings = SettingsManager.getInstance();
 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Ban(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ban") && sender.hasPermission("brawl.ban")){
			if(args.length <= 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player!");
				return true;
			}
			if(args.length > 0){
				Player target = Bukkit.getServer().getPlayer(args[0]);
						if(args[0].equalsIgnoreCase(target.getName())){
							StringBuilder message2 = new StringBuilder();
				            message2.append(args[1]);
				            for (int i = 1; i < args.length;) {
				            message2.append(" ");
				            target.kickPlayer(" " + message2);
				            Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.GOLD + " has banned " + target.getName() + " for " + message2);
				            target.setBanned(true);
				            
				            return true;
				         
						}
					}
				}
			}
				
		
		return false;
	}
}
			

		