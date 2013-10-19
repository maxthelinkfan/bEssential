package me.brawl.Commands;

import me.brawl.Main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Admin implements CommandExecutor, Listener {
	

 	   
    

	
	@SuppressWarnings("unused")
	private Main plugin;
	public Admin(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("admin") && sender.hasPermission("brawl.admin")){
			Player p = (Player) sender;
			p.setGameMode(GameMode.CREATIVE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000000, 2));
            Inventory inv = p.getInventory();
            inv.clear();
            p.getInventory();
            ItemStack wand = new ItemStack(Material.WOOD_AXE);
            inv.addItem(wand);
            ItemStack sign = new ItemStack(Material.SIGN);
            inv.addItem(sign);
            ItemStack cmd1 = new ItemStack(Material.COMMAND);
            inv.addItem(cmd1);
            p.sendMessage(ChatColor.RED + "Your are now in ADMIN mode. Your are invisible to all players.");
            
			}
		return false;
			}
}


