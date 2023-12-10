package mom.beaver.dwayne.registry;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.items.DwayneTheItemJohnson;
import mom.beaver.dwayne.items.blocks.DwayneTheBlockJohnson;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class RegisterItems {

    public static final Item DWAYNE_THE_ITEM_JOHNSON = new DwayneTheItemJohnson(new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final DwayneTheBlockJohnson DWAYNE_THE_BLOCK_JOHNSON = new DwayneTheBlockJohnson(FabricBlockSettings.create().strength(1.5f).requiresTool());

    public static Map<String, Item> block_items = new HashMap<>();

    public static Block DWAYNE_THE_FLOWER_JOHNSON_BLOCK = new FlowerBlock(StatusEffects.HASTE, 20,
            FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision());

    public static void register() {

        Item DWAYNE_THE_FLOWER_JOHNSON = registerItemAndBlock("dwayne_the_flower_johnson", DWAYNE_THE_FLOWER_JOHNSON_BLOCK, new FabricItemSettings());
        Block DWAYNE_THE_POTTED_JOHNSON_BLOCK = registerBlock("dwayne_the_potted_flower_johnson", new FlowerPotBlock(DWAYNE_THE_FLOWER_JOHNSON_BLOCK, FabricBlockSettings.copy(Blocks.POTTED_POPPY)));

        BlockRenderLayerMap.INSTANCE.putBlock(DWAYNE_THE_FLOWER_JOHNSON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DWAYNE_THE_POTTED_JOHNSON_BLOCK, RenderLayer.getCutout());

        // register items and blocks
        Item[] dwayne_group_entries = {
                registerItem("dwayne_the_item_johnson", DWAYNE_THE_ITEM_JOHNSON),
                registerItemAndBlock("dwayne_the_block_johnson", DWAYNE_THE_BLOCK_JOHNSON, new FabricItemSettings().rarity(Rarity.EPIC)),
                DWAYNE_THE_FLOWER_JOHNSON
        };



        Registry.register(Registries.ITEM_GROUP, new Identifier(DwayneTheModJohnson.MOD_ID, "dwayne_group"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(DWAYNE_THE_ITEM_JOHNSON))
                        .displayName(Text.translatable("Dwayne Johnson"))
                        .entries((context, entries) -> {
                            for (Item item : dwayne_group_entries) {
                                entries.add(item);
                            }
                        }).build()
        );
    }

    private static Item registerItem(String ID, Item item) {
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }

    private static Block registerBlock(String ID, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
        return block;
    }

    private static Item registerItemAndBlock(String ID, Block block, FabricItemSettings itemSettings) {
        Item item = new BlockItem(block, itemSettings);
        block_items.put(ID, item);
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }
}