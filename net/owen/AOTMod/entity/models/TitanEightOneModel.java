package net.owen.AOTMod.entity.models;// Made with Blockbench 4.9.3
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

public class TitanEightOneModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TitanEightOne;
	private final ModelPart Skull;

	public TitanEightOneModel(ModelPart root) {
		this.TitanEightOne = root.getChild("TitanEightOne");
		this.Skull = TitanEightOne.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TitanEightOne = partdefinition.addOrReplaceChild("TitanEightOne", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = TitanEightOne.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(72, 46).addBox(-8.0F, -18.0F, -8.0F, 16.0F, 13.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(72, 75).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -109.0F, 0.0F));

		PartDefinition Body = Torso.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(120, 39).addBox(-5.0F, -54.0F, -4.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-15.0F, -50.0F, -9.0F, 30.0F, 20.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 62).addBox(-12.0F, -30.0F, -6.0F, 24.0F, 20.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-13.0F, -10.0F, -7.0F, 26.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -55.0F, -1.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-15.0F, -103.0F, -1.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(36, 134).addBox(-9.5F, 26.0F, -4.5F, 9.0F, 24.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(114, 132).addBox(-10.0F, 0.0F, -5.0F, 10.0F, 26.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 133).addBox(0.5F, 26.0F, -4.5F, 9.0F, 24.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(124, 96).addBox(0.0F, 0.0F, -5.0F, 10.0F, 26.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, 0.0F, 0.0F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -56.0F, -1.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(84, 96).addBox(-5.0F, 28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-5.5F, 0.0F, -5.5F, 11.0F, 28.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(44, 96).addBox(-5.0F, 28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 94).addBox(-5.5F, 0.0F, -5.5F, 11.0F, 28.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
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
		ModelPart RightArm = this.TitanEightOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanEightOne.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.TitanEightOne.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.TitanEightOne.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.TitanEightOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanEightOne.getChild("Torso").getChild("Arms").getChild("LeftArm");

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
		TitanEightOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TitanEightOne;
	}

}