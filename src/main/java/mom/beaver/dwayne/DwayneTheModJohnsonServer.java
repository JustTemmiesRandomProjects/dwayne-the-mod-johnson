package mom.beaver.dwayne;

import mom.beaver.dwayne.registry.subRegisters.RegisterOnClientTick;
import mom.beaver.dwayne.registry.subRegisters.RegisterOnServerTick;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class DwayneTheModJohnsonServer implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        RegisterOnServerTick.register();
    }
}
