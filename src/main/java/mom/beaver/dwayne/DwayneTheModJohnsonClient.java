package mom.beaver.dwayne;

import mom.beaver.dwayne.registry.subRegisters.RegisterOnClientTick;
import mom.beaver.dwayne.registry.subRegisters.RegisterOnWorldJoin;
import mom.beaver.dwayne.registry.subRegisters.RegisterOnWorldLeave;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

@Environment(EnvType.CLIENT)
public class DwayneTheModJohnsonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegisterOnClientTick.register();
        RegisterOnWorldJoin.register();
        RegisterOnWorldLeave.register();
    }
}
