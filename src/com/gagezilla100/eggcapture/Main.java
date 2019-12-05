package com.gagezilla100.eggcapture;

import com.gagezilla100.eggcapture.config.config;
import com.gagezilla100.eggcapture.events.eggHit;
import com.gagezilla100.eggcapture.events.eggThrow;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        config.createConfig();

        getServer().getPluginManager().registerEvents(new eggThrow(), this);
        getServer().getPluginManager().registerEvents(new eggHit(), this);

        System.out.println("Enabled EggCapture.");
    }

}