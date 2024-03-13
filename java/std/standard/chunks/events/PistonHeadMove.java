package std.standard.chunks.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import std.standard.chunks.Chunks;

public class PistonHeadMove implements Listener {
    @EventHandler
    public void onInteract(BlockPistonExtendEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getBlock().getChunk().getChunkKey() + ".configs.BOL_PISTON_HEAD_MOVE") == 0) {
            if(!e.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteract(BlockPistonRetractEvent e) {
        if(Chunks.plugin.getChunkData().getInt(e.getRetractLocation().getChunk().getChunkKey() + ".configs.BOL_PISTON_HEAD_MOVE") == 0) {
            if(!e.isCancelled()) {
                e.setCancelled(true);
            }
        }
    }

}
