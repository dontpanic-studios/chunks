package std.standard.chunks.events.player;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import std.standard.chunks.calc.ChunkWorth;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.item.coin;
import std.standard.chunks.language.Language;

public class HoldingCoin implements Listener {

    @EventHandler
    public void onHoldCoin(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        ItemStack itemStack = e.getMainHandItem();

        if(itemStack.equals(new coin().getCoin())) {
            p.sendActionBar(Component.text(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CHUNK_WORTH)) + Integer.toString(new ChunkWorth().getWorth(p.getChunk())));
        }
    }

}
