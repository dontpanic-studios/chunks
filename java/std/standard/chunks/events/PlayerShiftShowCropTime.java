package std.standard.chunks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.BlockIterator;

public class PlayerShiftShowCropTime implements Listener {

    @EventHandler
    public void onShifting(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        Block crop = getTargetBlock(p, 1);
        TextDisplay cropStat;
        Location cropLoc;

        if(e.isSneaking()) {
            cropLoc = crop.getLocation();
            cropLoc.setY(crop.getY() + 0.85);
            cropStat = (TextDisplay) p.getWorld().spawnEntity(cropLoc, EntityType.TEXT_DISPLAY);
            cropStat.setBillboard(Display.Billboard.CENTER);
            //cropStat.setText(crop.getState().getBlockData().get);
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
