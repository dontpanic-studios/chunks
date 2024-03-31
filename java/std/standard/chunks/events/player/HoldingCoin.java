package std.standard.chunks.events.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import std.standard.chunks.calc.ChunkWorth;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

public class HoldingCoin implements Listener {

    @EventHandler
    public void onHoldCoin(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();

        if(e.getMainHandItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_ITEM_COIN))) {
            p.sendActionBar(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_WORTH) + new ChunkWorth().getWorth(p.getChunk()));
        }
    }

}
