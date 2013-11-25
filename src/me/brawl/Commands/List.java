package me.brawl.Commands;

import java.util.ArrayList;

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
 ArrayList<String> blist = new ArrayList<String>();
 	   
    
	
	@SuppressWarnings("unused")
	private Main plugin;
	public List(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("list")){
                Player p = (Player) sender;                                             
                p.sendMessage(ChatColor.GOLD + "Currently Online Players: " + "" + Bukkit.getServer().getOnlinePlayers().length + "/120");
                StringBuilder str = new StringBuilder();
    for(Player ps : Bukkit.getOnlinePlayers()){
        if(str.length() > 0){
            str.append(", ");
        }
        if(ps.isOp()) {
            str.append("§c" + ps.getName() + "§7");
        } else {
        	
        str.append("§f" + ps.getName() + "§7");
        
        
        }
    }
    p.sendMessage(str.toString()); // s = CommandSende
    return true;


}
		return false;
}
}