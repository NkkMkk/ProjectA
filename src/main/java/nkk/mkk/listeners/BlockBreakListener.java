package nkk.mkk.listeners;

import nkk.mkk.db.database;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.json.JSONObject;

import java.io.IOException;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void breakBlock (BlockBreakEvent e) throws IOException {
        database db = new database();
        Player p = e.getPlayer();
        Block b = e.getBlock();
        db.writeToJson("blocksBreak", new JSONObject().put("last-block", b.getType()), db.playerDataPath(p.getUniqueId()));
        db.writeToJson("blocksBreak", p.getInventory(), db.playerDataPath(p.getUniqueId()));
    }

}
