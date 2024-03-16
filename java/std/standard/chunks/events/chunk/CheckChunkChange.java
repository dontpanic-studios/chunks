package std.standard.chunks.events.chunk;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import std.standard.chunks.Chunks;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class CheckChunkChange implements Listener {

    @EventHandler
    public void onChunkChange(PlayerMoveEvent e) {
        Chunk curChunk = e.getPlayer().getChunk();
        Player p = e.getPlayer();

        try {
            if (!Chunks.getPlugin().getConfig().getString(curChunk.getChunkKey() + ".owner").isEmpty()) {
                p.sendActionBar(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_OWNER) + Chunks.getPlugin().getConfig().getString(p.getChunk().getChunkKey() + ".owner"));
            }
        } catch (Exception ex) {
            return;
        }
    }

}
