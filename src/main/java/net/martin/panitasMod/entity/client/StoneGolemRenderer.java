package net.martin.panitasMod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.martin.panitasMod.entity.custom.StoneGolemEntity;
import net.martin.panitasMod.panitasMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StoneGolemRenderer extends MobRenderer<StoneGolemEntity,golem_piedra<StoneGolemEntity>> {

    public StoneGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new golem_piedra<>(pContext.bakeLayer(ModModelLayers.GOLEM_PIEDRA_LAYER)),1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(StoneGolemEntity stoneGolemEntity) {
        return new ResourceLocation(panitasMod.MOD_ID,"textures/entity/golem_piedra.png");
    }

    @Override
    public void render(StoneGolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
