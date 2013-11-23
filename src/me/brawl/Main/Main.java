package me.brawl.Main;

import me.brawl.Commands.Admin;
import me.brawl.Commands.Ban;
import me.brawl.Commands.Day;
import me.brawl.Commands.Fly;
import me.brawl.Commands.Kick;
import me.brawl.Commands.List;
import me.brawl.Commands.Message;
import me.brawl.Commands.Night;
import me.brawl.Commands.Suicide;
import me.brawl.Commands.TP;
import me.brawl.Commands.Vanish;
import me.brawl.Commands.Whois;
import me.brawl.events.BanKickEvent;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
 SettingsManager settings = SettingsManager.getInstance();

 
 private Kick executor1;
 private Ban executor2;
 private Message executor3;
 private Vanish executor4;
 private Whois executor5;
 private Fly executor6;
 private Admin executor7;
 private Day executor8;
 private Night executor9;
 private List executor10;
 private Suicide executor11;
 private TP executor12;

 
 private BanKickEvent event = new BanKickEvent(this);
 
  public static Economy economy = null;
  
   private boolean setupEconomy()
     {
         RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
         if (economyProvider != null) {
             economy = economyProvider.getProvider();
         }

         return (economy != null);
     }
 
 public void onEnable() {
  
  Bukkit.getServer().getPluginManager().registerEvents(this, this);
  setupEconomy();
  
  settings.setup(this);
  
  executor1 = new Kick(this);
  getCommand("kick").setExecutor(executor1);
  
  executor2 = new Ban(this);
  getCommand("ban").setExecutor(executor2);
  
  executor3 = new Message(this);
  getCommand("msg").setExecutor(executor3);
  
  executor4 = new Vanish(this);
  getCommand("vanish").setExecutor(executor4);

  executor7 = new Admin(this);
  getCommand("admin").setExecutor(executor7);

  executor5 = new Whois(this);
  getCommand("whois").setExecutor(executor5);
  
  executor6 = new Fly(this);
  getCommand("fly").setExecutor(executor6);
  
  executor8 = new Day(this);
  getCommand("day").setExecutor(executor8);
  
  executor9 = new Night(this);
  getCommand("night").setExecutor(executor9);
  
  executor10 = new List(this);
  getCommand("list").setExecutor(executor10);
  
  executor11 = new Suicide(this);
  getCommand("suicide").setExecutor(executor11);
  
  executor12 = new TP(this);
  getCommand("tp").setExecutor(executor12);
  
  
  PluginManager event = getServer().getPluginManager();
     event.registerEvents(this.event, this);
}
}