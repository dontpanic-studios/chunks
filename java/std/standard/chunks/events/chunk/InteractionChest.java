package std.standard.chunks.events.chunk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import std.standard.chunks.Chunks;

public class InteractionChest implements Listener {

    @EventHandler
    public void onOpenChest(InventoryOpenEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getPlayer().getChunk().getChunkKey() + ".configs.BOL_INTERACTED_CHEST") == 0 && e.getView().getType().equals(InventoryType.CHEST)) {
            e.setCancelled(true);
        }
    }

}
