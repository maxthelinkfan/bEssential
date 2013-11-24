package me.brawl.Chat;


import me.brawl.Main.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OpChat implements Listener {
	
	public Main plugin; 
    public OpChat(Main instance){
            plugin = instance;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
    	System.out.println("Event Ran");
      Player p = e.getPlayer();
      String m = e.getMessage();

      if(p.isOp()){
    	  System.out.println("isOP");
      e.setFormat(ChatColor.RED + p.getName() + ":" + m);
      System.out.println("setFormat");
      }else
    	  System.out.println("beforeSetFormat");
          e.setFormat(p.getName() + ":" + m);
          System.out.println("setFormatnonOp");



    }
}