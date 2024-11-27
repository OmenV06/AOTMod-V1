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

public class TitanThreeOneModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TitanThreeOne;
	private final ModelPart Skull;

	public TitanThreeOneModel(ModelPart root) {
		this.TitanThreeOne = root.getChild("TitanThreeOne");
		this.Skull = TitanThreeOne.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TitanThreeOne = partdefinition.addOrReplaceChild("TitanThreeOne", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = TitanThreeOne.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(28, 24).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 22).addBox(-4.0F, -3.0F, 2.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(1.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -38.0F, 0.0F));

		PartDefinition Nose_r1 = Skull.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -42.75F, -15.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 38.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Jaw = Skull.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, -40.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 38.0F, 0.0F));

		PartDefinition TeethTop = Jaw.addOrReplaceChild("TeethTop", CubeListBuilder.create().texOffs(56, 52).addBox(-3.5F, -38.0F, -14.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(57, 33).addBox(2.5F, -38.0F, -14.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(52, 27).addBox(-3.5F, -38.0F, -15.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 11.5F));

		PartDefinition TeethBottom = Jaw.addOrReplaceChild("TeethBottom", CubeListBuilder.create().texOffs(0, 56).addBox(-3.5F, -38.0F, -14.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(55, 46).addBox(2.5F, -38.0F, -14.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(52, 25).addBox(-3.5F, -38.0F, -15.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 11.5F));

		PartDefinition UpperBody = Torso.addOrReplaceChild("UpperBody", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -18.0F, -5.0F, 12.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(28, 18).addBox(-2.5F, -19.0F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-5.0F, -10.0F, -4.0F, 10.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-4.5F, -4.0F, -3.5F, 9.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 51).addBox(-1.5F, 9.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 38).addBox(-1.5F, 9.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, 0.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(6.0F, -36.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(44, 10).addBox(0.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(13, 55).addBox(0.5F, 8.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(16, 43).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 51).addBox(-3.5F, 8.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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
		ModelPart RightArm = this.TitanThreeOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanThreeOne.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.TitanThreeOne.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.TitanThreeOne.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.TitanThreeOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanThreeOne.getChild("Torso").getChild("Arms").getChild("LeftArm");

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
		TitanThreeOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TitanThreeOne;
	}

}