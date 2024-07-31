package net.martin.panitasMod.entity.client;
// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class golem_piedra<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart rock_golem;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart Larm;
	private final ModelPart Rarm;
	private final ModelPart Rleg;
	private final ModelPart Lleg;
	private final ModelPart torso;
	private final ModelPart hitbox;

	public golem_piedra(ModelPart root) {
		this.rock_golem = root.getChild("rock_golem");
		this.head = this.rock_golem.getChild("h_head");
		this.body = this.rock_golem.getChild("body");
		this.Larm = this.body.getChild("Larm");
		this.Rarm = this.body.getChild("Rarm");
		this.Rleg = this.body.getChild("Rleg");
		this.Lleg = this.body.getChild("Lleg");
		this.torso = this.body.getChild("torso");
		this.hitbox = root.getChild("hitbox");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rock_golem = partdefinition.addOrReplaceChild("rock_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = rock_golem.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.9F, -49.0F, -2.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = rock_golem.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, 2.9F));

		PartDefinition Larm = body.addOrReplaceChild("Larm", CubeListBuilder.create().texOffs(0, 19).addBox(-3.9F, -2.3F, -4.4F, 7.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(-3.6F, 6.7F, -3.9F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 64).addBox(-2.6F, 10.7F, -2.9F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-3.6F, 14.7F, -3.9F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(15.9F, -9.3F, 0.0F));

		PartDefinition Rarm = body.addOrReplaceChild("Rarm", CubeListBuilder.create().texOffs(23, 28).addBox(-3.0F, -2.6F, -4.4F, 7.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-2.7F, 6.4F, -3.9F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, 15).addBox(-1.7F, 10.4F, -2.9F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 46).addBox(-2.7F, 14.4F, -3.9F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -9.0F, 0.0F));

		PartDefinition Rleg = body.addOrReplaceChild("Rleg", CubeListBuilder.create().texOffs(62, 58).addBox(-2.3F, 0.0F, -2.7F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(45, 36).addBox(-3.3F, 10.9F, -5.7F, 7.0F, 6.0F, 10.0F, new CubeDeformation(-0.998F)), PartPose.offset(-4.7F, 13.0F, -0.2F));

		PartDefinition Lleg = body.addOrReplaceChild("Lleg", CubeListBuilder.create().texOffs(22, 60).addBox(-2.7F, 0.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 9).addBox(-3.7F, 10.9F, -6.0F, 7.0F, 6.0F, 10.0F, new CubeDeformation(-0.998F)), PartPose.offset(4.5F, 13.0F, 0.1F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(30, 0).addBox(-9.0F, -5.0F, 2.0F, 18.0F, 2.0F, 2.0F, new CubeDeformation(3.0F))
		.texOffs(46, 25).addBox(-8.0F, 1.0F, 2.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(2.0F))
		.texOffs(30, 4).addBox(-8.0F, 5.0F, 2.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(1.0F))
		.texOffs(46, 29).addBox(-6.1F, 12.0F, 1.0F, 12.0F, 3.0F, 4.0F, new CubeDeformation(1.0F))
		.texOffs(44, 64).addBox(2.2F, -4.6F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.9F, -5.1F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.002F))
		.texOffs(0, 6).addBox(-8.0F, -3.2F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.002F))
		.texOffs(60, 52).addBox(-7.6F, -0.6F, -0.7F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-9.0F, -0.2F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.002F))
		.texOffs(54, 8).addBox(-5.1F, 8.0F, 1.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(69, 36).addBox(2.2F, 2.4F, 0.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.5F))
		.texOffs(6, 6).addBox(1.0F, 2.8F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.002F))
		.texOffs(0, 23).addBox(-3.9F, 9.8F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.002F)), PartPose.offset(0.0F, -3.0F, -2.9F));

		PartDefinition hitbox = partdefinition.addOrReplaceChild("hitbox", CubeListBuilder.create().texOffs(-36, -8).addBox(-19.0F, -49.0F, -2.0F, 38.0F, 48.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rock_golem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hitbox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return rock_golem;
	}
}