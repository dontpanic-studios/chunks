package std.standard.chunks.events;

import com.google.common.base.Enums;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.BlockIterator;
import std.standard.chunks.enums.AvailableCrops;

import java.util.List;

public class PlayerShiftShowCropTime implements Listener {

    @EventHandler
    public void onShifting(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        Block crop = getTargetBlock(p, 1);
        TextDisplay cropStat;

        if(e.isSneaking() && Enums.getIfPresent(AvailableCrops.class, crop.getType().toString()).isPresent()) {
            Location cusLoc = new Location(p.getWorld(), crop.getX(), crop.getY() + 0.5, crop.getZ());
            cropStat = (TextDisplay) p.getWorld().spawnEntity(cusLoc, EntityType.TEXT_DISPLAY);
            cropStat.setBillboard(Display.Billboard.CENTER);
            cropStat.setText("남은 시간: " + crop.getState().getData());
        } else {
            List<Entity> nearby =  p.getNearbyEntities(5,5,5);
            for (Entity tmp: nearby)
                if (tmp instanceof TextDisplay)
                    tmp.remove();
        }

    }

    public final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR && lastBlock.getType() != Material.WHEAT && lastBlock.getType() != Material.CARROTS && lastBlock.getType() != Material.POTATOES && lastBlock.getType() != Material.SWEET_BERRIES) {
                continue;
            }
            break;
        }
        return lastBlock;
    }
}
