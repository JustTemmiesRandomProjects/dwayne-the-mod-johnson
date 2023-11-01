package mom.beaver.dwayne.registry;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.items.DwayneTheItemJohnson;
import mom.beaver.dwayne.items.blocks.DwayneTheBlockJohnson;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RegisterItems {

    private static final Item DWAYNE_THE_ITEM_JOHNSON = new DwayneTheItemJohnson(new FabricItemSettings());
    private static final DwayneTheBlockJohnson DWAYNE_THE_BLOCK_JOHNSON = new DwayneTheBlockJohnson(FabricBlockSettings.create().strength(1.5f).requiresTool());
//    private static final Item BEAVER_FUEL = new BeaverFuelItem(new FabricItemSettings());
//    private static final BeaverSoundsItem BEAVER_SOUNDS = new BeaverSoundsItem(new FabricItemSettings().maxCount(1));
//    private static final Block BEAVER_BLOCK = new Block(FabricBlockSettings.create().strength(1.5f));
//    private static final BeaverBlock BEAVER_BLOCK = new BeaverBlock(FabricBlockSettings.create().strength(1.5f).requiresTool());

    public static void register() {

        // register items and blocks
        Item[] dwayne_group_entries = {
                registerItem("dwayne_the_item_johnson", DWAYNE_THE_ITEM_JOHNSON),
                registerItemAndBlock("dwayne_the_block_johnson", DWAYNE_THE_BLOCK_JOHNSON)
        };

        // register fuel
//        FuelRegistry.INSTANCE.add(BEAVER_FUEL, 1);

//        // item group
        Registry.register(Registries.ITEM_GROUP, new Identifier(DwayneTheModJohnson.MOD_ID, "dwayne_group"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(DWAYNE_THE_ITEM_JOHNSON))
                        .displayName(Text.translatable("Dwayne Johnson"))
                        .entries((context, entries) -> {
                            for (Item item : dwayne_group_entries) {
                                entries.add(item);
                            }
                        })
                        .build()
        );
    }

    private static Item registerItem(String ID, Item item) {
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }

    private static void registerBlock(String ID, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
    }

    private static Item registerItemAndBlock(String ID, Block block) {
        Item item = new BlockItem(block, new FabricItemSettings());
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }
}