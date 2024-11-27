package net.owen.AOTMod.entity.models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class BeastTitanModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart BeastTitan;
	private final ModelPart Skull;

	public BeastTitanModel(ModelPart root) {
		this.BeastTitan = root.getChild("BeastTitan");
		this.Skull = BeastTitan.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BeastTitan = partdefinition.addOrReplaceChild("BeastTitan", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = BeastTitan.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(304, 78).addBox(-12.0F, -24.0F, -12.0F, 24.0F, 16.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(304, 118).addBox(12.0F, -18.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(316, 118).addBox(15.0F, -20.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(340, 118).addBox(-16.0F, -18.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(328, 118).addBox(-18.0F, -20.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(368, 118).addBox(-12.0F, -8.0F, -12.0F, 24.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -248.0F, 0.0F));

		PartDefinition Body = Torso.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(160, 232).addBox(-65.0F, -126.0F, -5.0F, 60.0F, 6.0F, 52.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-79.0F, -120.0F, -9.0F, 88.0F, 64.0F, 64.0F, new CubeDeformation(0.0F))
				.texOffs(0, 128).addBox(-71.0F, -56.0F, -1.0F, 72.0F, 56.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offset(35.0F, -124.0F, -14.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-45.0F, -50.0F, -2.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 232).addBox(0.0F, 0.0F, -10.0F, 20.0F, 190.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(89.0F, -190.0F, 11.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(80, 232).addBox(-20.0F, 0.0F, -10.0F, 20.0F, 190.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -190.0F, 11.0F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(-5.0F, -54.0F, -6.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(240, 128).addBox(-16.0F, 0.0F, -16.0F, 32.0F, 70.0F, 32.0F, new CubeDeformation(0.0F))
				.texOffs(288, 290).addBox(-12.0F, 70.0F, -12.0F, 24.0F, 54.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(25.0F, -70.0F, 15.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(304, 0).addBox(-12.0F, 70.0F, -12.0F, 24.0F, 54.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(160, 290).addBox(-16.0F, 0.0F, -16.0F, 32.0F, 70.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, -70.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		// Determine if the entity is walking
		boolean isWalking = limbSwingAmount > 0.1f;

		if (isWalking) {
			// Apply walking animation
			applyWalkingAnimation(limbSwing, limbSwingAmount);
		} else {
			// Apply idle animation
			applyIdleAnimation(ageInTicks);
		}
	}

	private void applyWalkingAnimation(float limbSwing, float limbSwingAmount) {
		// Arms
		ModelPart RightArm = this.BeastTitan.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.BeastTitan.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.BeastTitan.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.BeastTitan.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.BeastTitan.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.BeastTitan.getChild("Torso").getChild("Arms").getChild("LeftArm");

		// Apply rotation to the arms
		RightArm.zRot = armSwayAngle;
		LeftArm.zRot = -armSwayAngle; // Inverse the angle for the opposite arm

		// Additional idle animations can be added here
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		// Clamp the head yaw and pitch within a realistic range
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		// Convert the yaw and pitch to radians for rotation
		// Normally, 180 degrees is equivalent to PI radians. Adjust if the movement is too fast or slow.
		this.Skull.yRot = pNetHeadYaw * ((float)Math.PI / 90F);
		this.Skull.xRot = pHeadPitch * ((float)Math.PI / 135F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		BeastTitan.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return BeastTitan;
	}
}