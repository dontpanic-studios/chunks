package std.standard.chunks.events.chunk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import std.standard.chunks.Chunks;

public class InteractionPlants implements Listener {

    @EventHandler
    public void onInteractPlant(BlockGrowEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getBlock().getChunk().getChunkKey() + ".configs.BOL_CROP_STATE_CHANGES") == 0) {
            e.setCancelled(true);
        }
    }

}
