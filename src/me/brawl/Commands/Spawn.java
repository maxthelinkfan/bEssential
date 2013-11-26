package me.brawl.Commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

public class Spawn implements CommandExecutor, Listener {
	

	 SettingsManager settings = SettingsManager.getInstance();
	ArrayList<String> spawn = new ArrayList<String>();

	
	private Main plugin;
	public Spawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(spawn.contains(p.getName())) {
			if(p.getLocation().getX() == settings.getData().getDouble("stele." + "" + p.getName()  + ".location" + ".x")){
  				if(p.getLocation().getZ() == settings.getData().getDouble("stele." + "" + p.getName()  + ".location" + ".z")){
  					spawn.remove(p.getName());
  					p.sendMessage(ChatColor.RED + "Teleport canceled!");
  				}
  				}
			
		}
	}
	

		
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("spawn")){
			final Player p = (Player) sender;
			if(args.length <= 0) {
				settings.getData().set("stele." + "" + p.getName()  + ".location" + ".x", Double.valueOf(p.getLocation().getX()));
				settings.getData().set("stele." + "" + p.getName()  + ".location" + ".z", Double.valueOf(p.getLocation().getZ()));
				settings.saveData();
				p.sendMessage(ChatColor.GREEN + "Teleporting you to spawn in 3 seconds, stand still!");
				new BukkitRunnable() {
		          	  public void run() {
		          		  if(p.getLocation().getX() == settings.getData().getDouble("stele." + "" + p.getName()  + ".location" + ".x")){
		          				if(p.getLocation().getZ() == settings.getData().getDouble("stele." + "" + p.getName()  + ".location" + ".z")){		          			
		          			  p.sendMessage(ChatColor.GREEN + "Teleporting!");
		          				
		          		  }
		          		  }
		          	  }
		          	}.runTaskLater(plugin, 60);
				return true;
			}
			
		}
		return false;
}
}