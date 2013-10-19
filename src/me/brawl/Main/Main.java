package me.brawl.Main;

import me.brawl.Commands.Ban;
import me.brawl.Commands.Kick;
import me.brawl.Commands.Message;
import me.brawl.Commands.Vanish;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	
	private Kick executor1;
	private Ban executor2;
	private Message executor3;
	private Vanish executor4;
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	
		executor1 = new Kick(this);
		getCommand("kick").setExecutor(executor1);
		
		executor2 = new Ban(this);
		getCommand("ban").setExecutor(executor2);
		
		executor3 = new Message(this);
		getCommand("msg").setExecutor(executor3);
		
		executor4 = new Vanish(this);
		getCommand("vanish").setExecutor(executor4);
		
}
}
