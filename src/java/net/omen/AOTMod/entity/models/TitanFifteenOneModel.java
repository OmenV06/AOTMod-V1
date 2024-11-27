package net.omen.AOTMod.entity.models;// Made with Blockbench 4.9.3
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

public class TitanFifteenOneModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TitanFifteenOne;
	private final ModelPart Skull;

	public TitanFifteenOneModel(ModelPart root) {
		this.TitanFifteenOne = root.getChild("TitanFifteenOne");
		this.Skull = TitanFifteenOne.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TitanFifteenOne = partdefinition.addOrReplaceChild("TitanFifteenOne", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = TitanFifteenOne.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(214, 72).addBox(-13.0F, -9.0F, -13.0F, 26.0F, 9.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(210, 145).addBox(-13.0F, -30.0F, -13.0F, 26.0F, 21.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -209.0F, 0.0F));

		PartDefinition Body = Torso.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 68).addBox(-27.0F, -23.0F, -14.0F, 54.0F, 22.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 118).addBox(-25.0F, -65.0F, -12.0F, 50.0F, 42.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-29.0F, -101.0F, -16.0F, 58.0F, 36.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(136, 72).addBox(-8.0F, -107.0F, -6.0F, 16.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -102.0F, 0.0F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(14.0F, -105.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(126, 171).addBox(-11.0F, 0.0F, -11.0F, 22.0F, 53.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(0, 184).addBox(-10.0F, 53.0F, -10.0F, 20.0F, 52.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(148, 96).addBox(-39.0F, 0.0F, -11.0F, 22.0F, 53.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(180, 0).addBox(-38.0F, 53.0F, -10.0F, 20.0F, 52.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(29.0F, -201.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(60, 236).addBox(0.0F, 0.0F, -10.0F, 20.0F, 50.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(140, 246).addBox(1.0F, 50.0F, -9.0F, 18.0F, 48.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(214, 192).addBox(-20.0F, 0.0F, -10.0F, 20.0F, 50.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(260, 0).addBox(-19.0F, 50.0F, -9.0F, 18.0F, 48.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-58.0F, 0.0F, 0.0F));

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
		ModelPart RightArm = this.TitanFifteenOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFifteenOne.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.TitanFifteenOne.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.TitanFifteenOne.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.TitanFifteenOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFifteenOne.getChild("Torso").getChild("Arms").getChild("LeftArm");

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
		TitanFifteenOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TitanFifteenOne;
	}

}