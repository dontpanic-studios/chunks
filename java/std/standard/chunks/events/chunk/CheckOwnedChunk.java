package std.standard.chunks.events.chunk;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import std.standard.chunks.Chunks;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class CheckOwnedChunk implements Listener {

    @EventHandler
    public void onChunkChange(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Chunk curChunk = p.getChunk();
        Long chunkKey = curChunk.getChunkKey();

        if(!Chunks.plugin.getChunkData().getString(chunkKey + ".owner").equalsIgnoreCase(p.getName()) || Chunks.plugin.getConfig().getString(chunkKey + ".owner").equals(null)) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_NO_PERMISSION));
        }
    }

}
