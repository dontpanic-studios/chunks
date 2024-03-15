package std.standard.chunks.events;

import com.google.common.base.Enums;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.BlockIterator;
import std.standard.chunks.enums.AvailableCrops;
import std.standard.chunks.enums.LanguageEnum;
import std.standard.chunks.language.Language;

import java.util.List;

public class PlayerShiftShowCropTime implements Listener {

    @EventHandler
    public void onShifting(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        Block crop = getTargetBlock(p, 1);
        TextDisplay cropStat;

        try {
            if (e.isSneaking() && Enums.getIfPresent(AvailableCrops.class, crop.getType().toString()).isPresent()) {
                org.bukkit.block.data.Ageable ageable = ((org.bukkit.block.data.Ageable)crop.getBlockData());
                Location cusLoc = new Location(p.getWorld(), crop.getX() + 0.5, crop.getY() + 1, p.getZ() - 0.5);
                cropStat = (TextDisplay) p.getWorld().spawnEntity(cusLoc, EntityType.TEXT_DISPLAY);
                cropStat.setBillboard(Display.Billboard.CENTER);
                if (!isFullGrown(crop)) {
                    cropStat.setText(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CROP_AGE_LEFT) + (ageable.getMaximumAge() - ageable.getAge()));
                } else {
                    cropStat.setText(ChatColor.COLOR_CHAR + new Language().DeSeriallizer(LanguageEnum.TEXT_CROP_FULL_GROWN));
                }
            } else {
                List<Entity> nearby = p.getNearbyEntities(5, 5, 5);
                for (Entity tmp : nearby)
                    if (tmp instanceof TextDisplay)
                        tmp.remove();
            }
        } catch (Exception ex){
            return;
        }
    }

    public final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            try {
                if (lastBlock instanceof Ageable) {
                    continue;
                }
            } catch (Exception e) {
                return null;
            }
            break;
        }
        return lastBlock;
    }

    private boolean isFullGrown(Block block){
        org.bukkit.block.data.Ageable ageable = ((org.bukkit.block.data.Ageable)block.getBlockData());
        return ageable.getAge() >= ageable.getMaximumAge();
    }

}
