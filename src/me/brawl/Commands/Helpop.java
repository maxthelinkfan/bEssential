package me.brawl.Commands;


import me.brawl.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Helpop implements CommandExecutor, Listener {
	

 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Helpop(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("helpop") && sender.hasPermission("brawl.helpop")){
			}
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "Please enter a message!");
			return true;
		}
		if(args.length == 1){
            StringBuilder message2 = new StringBuilder();
            message2.append(args[0]);
            for (int i = 1; i < args.length; i++) {
            message2.append(" ");
            }
           
		
		}
		return false;
		}
}

			