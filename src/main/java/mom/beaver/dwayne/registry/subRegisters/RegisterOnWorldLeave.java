package mom.beaver.dwayne.registry.subRegisters;

import mom.beaver.dwayne.DwayneTheModJohnson;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class RegisterOnWorldLeave {
    public static void register() {
        // reset the jovial ticks played counter to 0 whenever leaving a server
        ClientPlayConnectionEvents.DISCONNECT.register(((handler, client) -> {
            DwayneTheModJohnson.LOGGER.info("Disconnecting from server...");
            client.execute(() -> {
                DwayneTheModJohnson.JOVIAL_TICKS_PLAYED = 0;
            });
        }));
    }
}
