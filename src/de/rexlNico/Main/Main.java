package de.rexlNico.Main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		if(!plugincommandAndern.file.exists()){
			plugincommandAndern.cfg.set("MSG", "&cDu hast keine rechte die &aPlugins &czu sehen");
			try {
				plugincommandAndern.cfg.save(plugincommandAndern.file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		pm.registerEvents(new plugincommandAndern(), this);
		pm.registerEvents(new join(), this);
		pm.registerEvents(new chatevent(), this);
		Bukkit.getConsoleSender().sendMessage("§ePluginHider §cwurde §aGealden§c.");
		
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}

}
