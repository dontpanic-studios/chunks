package std.standard.chunks.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import std.standard.chunks.Chunks;

public class InteractionAll implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getPlayer().getChunk().getChunkKey() + ".configs.BOL_INTERACTED_ALL") == 0) {
            e.setCancelled(true);
        }
    }

}
