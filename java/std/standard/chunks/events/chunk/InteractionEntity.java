package std.standard.chunks.events.chunk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import std.standard.chunks.Chunks;

public class InteractionEntity implements Listener {
    @EventHandler
    public void onInteractionBlock(PlayerInteractEntityEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getRightClicked().getChunk().getChunkKey() + ".configs.BOL_INTERACTED_ENTITY") == 0) {
            e.setCancelled(true);
        }
    }

}
