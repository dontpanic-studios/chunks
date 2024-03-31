package std.standard.chunks.events.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import std.standard.chunks.Chunks;
import std.standard.chunks.calc.ChunkWorth;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.item.coin;
import std.standard.chunks.language.Language;

import java.io.IOException;

public class BuyChunkRightClick implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player p = e.getPlayer();
            ItemStack curItem = p.getItemInHand();
            if(curItem.equals(new coin().getCoin())) {
                if(Chunks.plugin.getChunkData().getString(p.getChunk().getChunkKey() + ".owner") == null) {
                    p.sendTitle(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_BOUGHT),
                            ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_OWNER) + p.getName());
                    Chunks.getPlugin().getConfig().set(p.getChunk().getChunkKey() + ".owner", p.getName());
                    Chunks.getPlugin().getConfig().set(p.getChunk().getChunkKey() + ".chunkWorth", new ChunkWorth().getWorth(p.getChunk()));
                    try {
                        Chunks.plugin.getChunkData().save(Chunks.plugin.chunkDataFile);
                    } catch (IOException ex) {
                        p.sendMessage(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_SAVE_FAILED));
                    }
                }
            }
        }
    }

}
