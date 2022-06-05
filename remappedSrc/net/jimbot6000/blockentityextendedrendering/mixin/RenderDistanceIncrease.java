package net.jimbot6000.blockentityextendedrendering.mixin;

import net.jimbot6000.blockentityextendedrendering.BlockEntityExtendedRendering;
import net.jimbot6000.blockentityextendedrendering.gui.BEERConfig;
import net.jimbot6000.blockentityextendedrendering.utils.GetDistanceInterface;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Properties;

@Mixin(BlockEntityRenderer.class)
public interface RenderDistanceIncrease extends GetDistanceInterface {

	@Override
	default int getRenderDistance() {
		BlockEntityExtendedRendering.LOGGER.info("mixin used");
		Properties config = new Properties();
		BlockEntityExtendedRendering.CONFIG.writeTo(config);
		return Integer.parseInt(config.getProperty(BEERConfig.BLOCK_ENTITY_RENDER_DISTANCE_KEY));
	}
}