package me.brawl.events;


import me.brawl.Main.Main;
import me.brawl.Main.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BanKickEvent implements Listener{
	SettingsManager settings = SettingsManager.getInstance();
       
        public BanKickEvent(Main instance){
                @SuppressWarnings("unused")
				Main plugin = instance;
        }
        @EventHandler
        public void onPlayerJoin(PlayerLoginEvent e) {
        	Player p = e.getPlayer();        
        	if(settings.getData().contains(".banned" + p.getName())){
        			p.kickPlayer(ChatColor.RED + "You have been banned for cheating!");
        		}
        	}
        }
