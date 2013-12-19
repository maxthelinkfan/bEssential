package me.brawl.Main;

import me.brawl.Commands.*;
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

	
 
 

 
 //events\\
 
 
 
 
 
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
  
  getCommand("admin").setExecutor(new Admin(this));
  getCommand("ban").setExecutor(new Ban(this));
  getCommand("day").setExecutor(new Day(this));
  getCommand("feed").setExecutor(new Feed(this));
  getCommand("fly").setExecutor(new Fly(this));
  getCommand("gm").setExecutor(new Gm(this));
  getCommand("hat").setExecutor(new Hat(this));
  getCommand("helpop").setExecutor(new Helpop(this));
  getCommand("i").setExecutor(new I(this));
  getCommand("kick").setExecutor(new Kick(this));
  getCommand("list").setExecutor(new List(this));
  getCommand("message").setExecutor(new Message(this));
  getCommand("more").setExecutor(new More(this));
  getCommand("night").setExecutor(new Night(this));
  getCommand("ping").setExecutor(new Ping(this));
  getCommand("spawn").setExecutor(new Spawn(this));
  getCommand("suicide").setExecutor(new Suicide(this));
  getCommand("tp").setExecutor(new TP(this));
  getCommand("tpall").setExecutor(new TPAll(this));
  getCommand("vanish").setExecutor(new Vanish(this));
  getCommand("warp").setExecutor(new Warp(this));
  getCommand("whois").setExecutor(new Whois(this));
  getCommand("workbench").setExecutor(new Workbench(this));
  
  Bukkit.getServer().getPluginManager().registerEvents(new Spawn(this), this);
  
  
  
  
 }
 
 
     
       

         
     
    	   
       
     {
}
}
