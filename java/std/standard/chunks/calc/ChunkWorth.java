package std.standard.chunks.calc;

import org.bukkit.Chunk;

public class ChunkWorth {

    public int getWorth(Chunk chk) {
        int fin = 0;
        if(chk.isSlimeChunk()) {
            fin += 50;
        }

        if(chk.getEntities().length < 100) {
            for (int i = 0; i > chk.getEntities().length; i++) {
                fin += i;
            }
        } else {
            fin = 0;
        }
        return fin;
    }

}
