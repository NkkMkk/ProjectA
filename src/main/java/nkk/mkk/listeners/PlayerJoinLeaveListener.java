package nkk.mkk.listeners;

import nkk.mkk.db.database;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinLeaveListener implements Listener {

    @EventHandler
    public void playerJoin (PlayerJoinEvent e) {
        new database().playerDataCreate(e.getPlayer());
    }
}
