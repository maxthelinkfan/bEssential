package me.brawl.Main;

import me.brawl.Commands.*;
import me.brawl.events.BanKickEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent; 
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

public class Main extends JavaPlugin implements Listener {
 SettingsManager settings = SettingsManager.getInstance();
 
 
 // CHAT EVENTS \\
 
 @EventHandler
 public void onPlayerChat(AsyncPlayerChatEvent e){
 	System.out.println("Event Ran");
   Player p = e.getPlayer();
   String m = e.getMessage();
   if(p.isOp()){    	   
 	  System.out.println("isOP");
   e.setFormat(ChatColor.RED + p.getName() + ": " + m);
   
   }
 }
 
 @EventHandler
 public void onPlayerChat2(AsyncPlayerChatEvent e2) {
	 Player p2 = e2.getPlayer();
	 String m2 = e2.getMessage();
	 if(p2.hasPermission("brawl.vip")){
		 if(!p2.hasPermission("brawl.mvp")) {
			 if(!p2.hasPermission("brawl.mod")){
			 if(!p2.hasPermission("brawl.pro")) {
		 
		 if(!p2.isOp()) {
		 e2.setFormat(ChatColor.GREEN + p2.getName() + ": " + m2);
	 }
	 }
		 }
	 }
	 }
 }
 
 
 @EventHandler
 public void onPlayerChat3(AsyncPlayerChatEvent e3) {
	 Player p3 = e3.getPlayer();
	 String m3 = e3.getMessage();
	 if(p3.hasPermission("brawl.mvp")){
		 if(!p3.hasPermission("brawl.vip")) {
			 if(!p3.hasPermission("brawl.mod")){
			 if(!p3.hasPermission("brawl.pro")) {		 
		 if(!p3.isOp()) {
		 e3.setFormat(ChatColor.BLUE + p3.getName() + ": " + m3);
		 }
	 }
		 }
		 }
	 }	 
 }
 @EventHandler
 public void onPlayerChate(AsyncPlayerChatEvent ee) {
	 Player pe = ee.getPlayer();
	 String me = ee.getMessage();
	 if(pe.hasPermission("brawl.pro")){
		 if(!pe.hasPermission("brawl.vip")) {
			 if(!pe.hasPermission("brawl.mod")){
			 if(!pe.hasPermission("brawl.mvp")) {		 
		 if(!pe.isOp()) {
		 ee.setFormat(ChatColor.GOLD + pe.getName() + ": " + me);
		 }
	 }
		 }
		 }
	 }	 
 }
 @EventHandler
 public void onPlayerChat4(AsyncPlayerChatEvent ee) {
	 Player pe = ee.getPlayer();
	 String me = ee.getMessage();
	 if(pe.hasPermission("brawl.mod")){
		 if(!pe.hasPermission("brawl.vip")) {
			 if(!pe.hasPermission("brawl.mvp")) {	
				 if(!pe.hasPermission("brawl.pro")) {
		 if(!pe.isOp()) {
		 ee.setFormat(ChatColor.DARK_PURPLE + pe.getName() + ": " + me);
		 }
	 }
		 }
	 }	 
	 }
 }
 
 // END OF CHAT EVENTS \\

 
 // TAG EVENTS \\
 @EventHandler
 public void onNameTag(PlayerReceiveNameTagEvent event) {
 if (event.getNamedPlayer().getName().equals("AnonPvP")) {
 event.setTag(ChatColor.RED + "" + event.getNamedPlayer().getName());
 }
 }
 @EventHandler
 public void onNameTag1(PlayerReceiveNameTagEvent event) {
 if (event.getNamedPlayer().getName().equals("Hydrations")) {
 event.setTag(ChatColor.RED + "Hydrations");
 }
 }
 @EventHandler
 public void onNameTagMod(PlayerReceiveNameTagEvent event) {
	 Player p = event.getNamedPlayer();
 if(p.hasPermission("brawl.modtag")) {
	 if(!p.isOp()) {
 event.setTag(ChatColor.DARK_PURPLE + p.getName());
 }
 }
 }
 @SuppressWarnings("deprecation")
@EventHandler (priority = EventPriority.HIGHEST)
 public void onPlayerJoin(AsyncPlayerPreLoginEvent e) {
	 if(e.getResult().equals(Result.KICK_BANNED)) {
		 e.setKickMessage("Test!");
	 }
	 
 }

	
 
 
 
 public Kick executor1;
 public Ban executor2;
 public Message executor3;
 public Vanish executor4;
 public Whois executor5;
 public Fly executor6;
 public Admin executor7;
 public Day executor8;
 public Night executor9;
 public List executor10;
 public Suicide executor11;
 public TP executor12;
 public Feed executor13;
 public Helpop executor14;
 public Gamemode executor15;
 


 
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
  
  executor13 = new Feed(this);
  getCommand("feed").setExecutor(executor13);
  
  executor14 = new Helpop(this);
  getCommand("helpop").setExecutor(executor14);
  
  executor15 = new Gamemode(this);
  getCommand("gm").setExecutor(executor15);
  
  
  
 }
 
     
       

         
     
    	   
       
     {
}
}
