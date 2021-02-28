package eu.midnightdust.hats;

import eu.midnightdust.hats.bunny.BunnyEarsFeatureRenderer;
import eu.midnightdust.hats.christmas.ChristmasHatFeatureRenderer;
import eu.midnightdust.hats.config.HatsConfig;
import eu.midnightdust.hats.tater.TinyPotatoFeatureRenderer;
import eu.midnightdust.hats.web.HatLoader;
import eu.midnightdust.hats.witch.WitchHatFeatureRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;

@SuppressWarnings({"deprecation", "UnstableApiUsage"})
public class HatsClient implements ClientModInitializer {

    public static final String MOD_ID = "midnightlib";

    @Override
    public void onInitializeClient() {
        HatsConfig.init("midnightlib", HatsConfig.class);

        EntityModelLayerRegistry.registerModelLayer(BunnyEarsFeatureRenderer.RABBIT_EARS_MODEL_LAYER, BunnyEarsFeatureRenderer::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ChristmasHatFeatureRenderer.CHRISTMAS_HAT_MODEL_LAYER, ChristmasHatFeatureRenderer::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(TinyPotatoFeatureRenderer.TINY_POTATO_MODEL_LAYER, TinyPotatoFeatureRenderer::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WitchHatFeatureRenderer.WITCH_HAT_MODEL_LAYER, WitchHatFeatureRenderer::getTexturedModelData);
        if (HatsConfig.special_hats) {
            HatLoader.init();
        }
    }
}
