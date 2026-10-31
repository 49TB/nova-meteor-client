package meteordevelopment.meteorclient.systems.modules.player;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.world.BlockUtils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class AutoMine extends Module {
    public AutoMine() {
        super(Categories.Player, "auto-mine", "Mines the block you are looking at.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (!(mc.hitResult instanceof BlockHitResult hitResult) || hitResult.getType() != HitResult.Type.BLOCK) return;

        BlockUtils.breakBlock(hitResult.getBlockPos(), true);
    }
}
