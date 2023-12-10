package mom.beaver.dwayne.registry;

import mom.beaver.dwayne.DwayneTheModJohnson;
import mom.beaver.dwayne.items.DwayneTheItemJohnson;
import mom.beaver.dwayne.items.EvilFreddyKalasItem;
import mom.beaver.dwayne.items.FreddyKalasItem;
import mom.beaver.dwayne.items.blocks.DwayneTheBlockJohnson;
import mom.beaver.dwayne.items.blocks.FreddyKalasCorruptithar;
import mom.beaver.dwayne.items.blocks.blockEntities.FreddyKalasCorruptitharEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class RegisterItems {

    public static final Item DWAYNE_THE_ITEM_JOHNSON = new DwayneTheItemJohnson(new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final Item FREDDY_KALAS_ITEM = new FreddyKalasItem(new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item EVIL_FREDDY_KALAS_ITEM = new EvilFreddyKalasItem(new FabricItemSettings().rarity(Rarity.EPIC).fireproof());

    private static final DwayneTheBlockJohnson DWAYNE_THE_BLOCK_JOHNSON = new DwayneTheBlockJohnson(FabricBlockSettings.create().strength(1.5f).requiresTool());
    private static final FreddyKalasCorruptithar FREDDY_KALAS_CORRUPTITHAR = new FreddyKalasCorruptithar(FabricBlockSettings.create().strength(3.5f));
    public static final BlockEntityType<FreddyKalasCorruptitharEntity> FREDDY_KALAS_CORRUPTITHAR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(DwayneTheModJohnson.MOD_ID, "freddy_kalas_corruptithar_entity"),
            FabricBlockEntityTypeBuilder.create(FreddyKalasCorruptitharEntity::new, FREDDY_KALAS_CORRUPTITHAR).build()
    );

    //    private static final Item BEAVER_FUEL = new BeaverFuelItem(new FabricItemSettings());
//    private static final BeaverSoundsItem BEAVER_SOUNDS = new BeaverSoundsItem(new FabricItemSettings().maxCount(1));
//    private static final Block BEAVER_BLOCK = new Block(FabricBlockSettings.create().strength(1.5f));
//    private static final BeaverBlock BEAVER_BLOCK = new BeaverBlock(FabricBlockSettings.create().strength(1.5f).requiresTool());

    public static void register() {

        // register items and blocks
        Item[] dwayne_group_entries = {
                registerItem("dwayne_the_item_johnson", DWAYNE_THE_ITEM_JOHNSON),
                registerItemAndBlock("dwayne_the_block_johnson", DWAYNE_THE_BLOCK_JOHNSON, new FabricItemSettings().rarity(Rarity.EPIC))
        };

        Item[] freddy_group_entries = {
                registerItem("freddy_kalas_item", FREDDY_KALAS_ITEM),
                registerItem("evil_freddy_kalas_item", EVIL_FREDDY_KALAS_ITEM),
                registerItemAndBlock("freddy_kalas_corruptithar", FREDDY_KALAS_CORRUPTITHAR, new FabricItemSettings().rarity(Rarity.EPIC))
        };

        // register fuel
//        FuelRegistry.INSTANCE.add(BEAVER_FUEL, 1);



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

        Registry.register(Registries.ITEM_GROUP, new Identifier(DwayneTheModJohnson.MOD_ID, "freddy_group"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(FREDDY_KALAS_CORRUPTITHAR))
                        .displayName(Text.translatable("Freddy Kalas"))
                        .entries((context, entries) -> {
                            for (Item item : freddy_group_entries) {
                                entries.add(item);
                            }
                        }).build()
        );
    }

    private static Item registerItem(String ID, Item item) {
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }

    private static void registerBlock(String ID, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
    }

    private static Item registerItemAndBlock(String ID, Block block, FabricItemSettings itemSettings) {
        Item item = new BlockItem(block, itemSettings);
        Registry.register(Registries.BLOCK, new Identifier(DwayneTheModJohnson.MOD_ID, ID), block);
        Registry.register(Registries.ITEM, new Identifier(DwayneTheModJohnson.MOD_ID, ID), item);
        return item;
    }
}