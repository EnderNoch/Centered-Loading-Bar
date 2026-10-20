package pl.endernoch.centeredloadingbar.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

// Nothing here is required (see centered-loading-bar.mixins.json): if a Minecraft update moves this code,
// the mod quietly stops doing anything instead of crashing the game.
@Mixin(LoadingOverlay.class)
public class LoadingOverlayMixin {
	// The Mojang logo is drawn as two blits (left and right half); skip both.
	@WrapWithCondition(
		method = "extractRenderState",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIIIIII)V"
		)
	)
	private boolean centeredloadingbar$hideLogo(GuiGraphicsExtractor graphics, RenderPipeline pipeline, Identifier texture, int x, int y, float u, float v, int width, int height, int uWidth, int vHeight, int textureWidth, int textureHeight, int tintColor) {
		return false;
	}

	// Vanilla puts the bar at 83.25% of the screen height, just under the logo; move it to the middle.
	@ModifyConstant(method = "extractRenderState", constant = @Constant(doubleValue = 0.8325))
	private double centeredloadingbar$centerBar(double original) {
		return 0.5;
	}
}
