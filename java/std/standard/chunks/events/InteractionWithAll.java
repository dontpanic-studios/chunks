package std.standard.chunks.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import std.standard.chunks.Chunks;

public class InteractionWithAll implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(!Chunks.plugin.getChunkData().getBoolean(e.getPlayer().getChunk() + ".config.interactionAll")) {
            e.setCancelled(true);
        }
    }

}
