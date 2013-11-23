package me.brawl.Commands;


import java.util.ArrayList;
 

import me.brawl.Main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;


 
public class Vanish extends JavaPlugin implements Listener {
       
	@SuppressWarnings("unused")
	 private Main plugin;
	 public Vanish(Main plugin) {
	  this.plugin = plugin;
	 }
       
        private ArrayList<Player> vanished = new ArrayList<Player>();
 
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
               
                if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.DARK_RED + "You cannot vanish!");
                        return true;
                }
               
                Player p = (Player) sender;
               
                if (cmd.getName().equalsIgnoreCase("vanish")) {
                        if (p.hasPermission("brawl.vanish")) {
                        } else { sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to vanish");
                        
                        	return true;
                        }
                       
                        if (!vanished.contains(p)) {
                                for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                        pl.hidePlayer(p);
                                }
                                vanished.add(p);
                                p.sendMessage(ChatColor.GOLD + "You have been vanished!");
                                Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + " has left the game.");
                                return true;
                        }
                        else {
                                for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                        pl.showPlayer(p);
                                }
                                vanished.remove(p);
                                p.sendMessage(ChatColor.GOLD + "You are now visible!");
                                return true;
                        }
                }
                return true;
        }
       
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {
                for (Player p : vanished) {
                        e.getPlayer().hidePlayer(p);
                }
        }
       
        @EventHandler
        public void onPlayerLeave(PlayerQuitEvent e) {
                vanished.remove(e.getPlayer());
        }
}