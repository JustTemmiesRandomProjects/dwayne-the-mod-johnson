package mom.beaver.dwayne;

import mom.beaver.dwayne.registry.subRegisters.RegisterOnClientTick;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DwayneTheModJohnsonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegisterOnClientTick.register();
    }
}
