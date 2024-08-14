package ch.andre601.nouiontab.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.PlayerListHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin{
    
    @Shadow
    @Final
    private PlayerListHud playerListHud;
    
    @Inject(
        method = {
            "renderOverlay",
            "renderCrosshair",
            "renderMainHud",
            "renderExperienceLevel",
            "renderStatusEffectOverlay",
            "method_55808",
            
            "renderDemoTimer",
            "method_55807",
            "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V",
            "renderOverlayMessage",
            "renderTitleAndSubtitle",
            "renderChat"
        },
        at = @At("HEAD"),
        cancellable = true
    )
    private void hideHudOnPlayerListRender(CallbackInfo ci){
        if(((PlayerListHudAccessor) this.playerListHud).nouiontab$isVisible()){
            ci.cancel();
        }
    }
}
