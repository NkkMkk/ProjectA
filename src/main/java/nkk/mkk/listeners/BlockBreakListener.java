package nkk.mkk.listeners;

import nkk.mkk.db.database;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.FileNotFoundException;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void breakBlock (BlockBreakEvent e) throws FileNotFoundException {
        database db = new database();

        /*Object count = db.playerDataGet(e.getPlayer().getUniqueId());
        if (count == null) {
            db.playerDataSet(e.getPlayer().getUniqueId());
            count = db.playerDataGet(e.getPlayer().getUniqueId());
        }

         */

        //System.out.println( count + " " + e.getPlayer().getDisplayName() + " > " + e.getBlock().getType());
    }

}
