package mom.beaver.dwayne.items.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;

public class DwayneTheFlowerJohnson extends FlowerBlock {
    public DwayneTheFlowerJohnson (AbstractBlock.Settings settings) {
        super(StatusEffects.SLOWNESS, 8, settings);
    }
}
