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

public class TitanFourOneModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TitanFourOne;
	private final ModelPart Skull;

	public TitanFourOneModel(ModelPart root) {
		this.TitanFourOne = root.getChild("TitanFourOne");
		this.Skull = TitanFourOne.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TitanFourOne = partdefinition.addOrReplaceChild("TitanFourOne", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = TitanFourOne.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition UpperBody = Torso.addOrReplaceChild("UpperBody", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -5.0F, 16.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-6.0F, -20.0F, -4.0F, 12.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(16, 71).addBox(-1.0F, -20.0F, 4.0F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 18).addBox(-2.5F, -29.0F, -2.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 0.0F));

		PartDefinition Rib = UpperBody.addOrReplaceChild("Rib", CubeListBuilder.create().texOffs(0, 59).addBox(-7.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(44, 55).addBox(1.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition Rib2 = UpperBody.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(22, 53).addBox(-7.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(50, 43).addBox(1.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 29.0F, 0.0F));

		PartDefinition Rib3 = UpperBody.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(0, 47).addBox(-7.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(42, 6).addBox(1.0F, -45.0F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 32.0F, 0.0F));

		PartDefinition LowerBody = UpperBody.addOrReplaceChild("LowerBody", CubeListBuilder.create().texOffs(0, 34).addBox(25.0F, -41.0F, -2.0F, 10.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 26).addBox(23.5F, -36.0F, -2.0F, 13.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, 31.0F, -2.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -21.0F, -0.5F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(72, 35).addBox(0.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 82).addBox(0.5F, 11.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -31.0F, 0.5F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 71).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(79, 52).addBox(-3.5F, 11.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -31.0F, 0.5F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.5F, -13.0F, -0.5F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(27, 66).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 14).addBox(-2.0F, 14.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -15.0F, 0.5F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(47, 67).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 67).addBox(-2.0F, 14.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -15.0F, 0.5F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(28, 39).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -55.0F, 0.0F));

		PartDefinition Nose_r1 = Skull.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -57.25F, -22.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 56.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition TeethTop = Skull.addOrReplaceChild("TeethTop", CubeListBuilder.create().texOffs(93, 17).addBox(-2.5F, -61.0F, -4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(-3.5F, -61.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(2.5F, -61.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 58.25F, 0.5F));

		PartDefinition Jaw = Skull.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, -58.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 56.0F, 0.0F));

		PartDefinition TeethBottom = Jaw.addOrReplaceChild("TeethBottom", CubeListBuilder.create().texOffs(93, 17).addBox(-2.5F, -61.0F, -4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(-3.5F, -61.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(2.5F, -61.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.75F, 0.5F));

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
		ModelPart RightArm = this.TitanFourOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFourOne.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.TitanFourOne.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.TitanFourOne.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.TitanFourOne.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFourOne.getChild("Torso").getChild("Arms").getChild("LeftArm");

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
		TitanFourOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TitanFourOne;
	}

}