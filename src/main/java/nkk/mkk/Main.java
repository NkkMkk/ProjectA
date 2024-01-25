package nkk.mkk;

import nkk.mkk.db.database;
import nkk.mkk.listeners.BlockBreakListener;
import nkk.mkk.listeners.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);
    }


    public static Main getPlugin() {
        return plugin;
    }

}
