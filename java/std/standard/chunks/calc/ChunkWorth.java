package std.standard.chunks.calc;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import std.standard.chunks.Chunks;

public class ChunkWorth {

    public int getWorth(Chunk chk) {
        int fin = 0;
        double ownerExp;
        try {
            ownerExp = Math.round(Bukkit.getOfflinePlayer(Chunks.getPlugin().getConfig().getString(chk.getChunkKey() + ".owner")).getPlayer().calculateTotalExperiencePoints() / 0.5);
        } catch (Exception e) {
            ownerExp = 1.01;
        }

        if(chk.isSlimeChunk()) {
            fin += 50;
        }

        if(chk.getEntities().length < 100) {
            for (int i = 0; i > chk.getEntities().length; i+=5) {
                fin += i;
            }
        } else {
            fin = -1;
            return fin;
        }

        return (int) Math.round(Math.pow(fin, ownerExp));
    }

}
