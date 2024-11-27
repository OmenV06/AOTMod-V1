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

public class TitanFourTwoModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TitanFourTwo;
	private final ModelPart Skull;

	public TitanFourTwoModel(ModelPart root) {
		this.TitanFourTwo = root.getChild("TitanFourTwo");
		this.Skull = TitanFourTwo.getChild("Torso").getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TitanFourTwo = partdefinition.addOrReplaceChild("TitanFourTwo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = TitanFourTwo.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Skull = Torso.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 58).addBox(-5.0F, -10.0F, -5.5F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(96, 77).addBox(-5.0F, -3.0F, -0.5F, 10.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(133, 14).addBox(-4.0F, -11.0F, -2.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -53.0F, 0.5F));

		PartDefinition Nose_r1 = Skull.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(6, 7).addBox(-0.5F, -56.25F, -22.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 53.0F, -0.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition BeardTop = Skull.addOrReplaceChild("BeardTop", CubeListBuilder.create().texOffs(38, 79).addBox(-5.0F, -56.75F, -5.25F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(110, 96).addBox(-5.75F, -53.0F, -5.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(59, 110).addBox(4.75F, -53.0F, -5.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 53.0F, -0.5F));

		PartDefinition BeardRight_r1 = BeardTop.addOrReplaceChild("BeardRight_r1", CubeListBuilder.create().texOffs(30, 58).addBox(-2.0F, -53.75F, -17.25F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 1.5708F, 0.0F));

		PartDefinition BeardLeft_r1 = BeardTop.addOrReplaceChild("BeardLeft_r1", CubeListBuilder.create().texOffs(64, 59).addBox(-5.0F, -53.75F, -17.25F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, -1.5708F, 0.0F));

		PartDefinition Brow = Skull.addOrReplaceChild("Brow", CubeListBuilder.create().texOffs(53, 7).addBox(-4.5F, -61.0F, -5.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(53, 9).addBox(0.5F, -61.0F, -5.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 53.0F, -0.5F));

		PartDefinition TopTeeth = Skull.addOrReplaceChild("TopTeeth", CubeListBuilder.create().texOffs(104, 22).addBox(-4.5F, -55.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(3.5F, -55.5F, -15.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 49).addBox(-4.5F, -55.5F, -15.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 52.0F, 11.5F));

		PartDefinition Jaw = Skull.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(72, 59).addBox(-5.0F, -55.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 53.0F, -0.5F));

		PartDefinition BottomTeeth = Jaw.addOrReplaceChild("BottomTeeth", CubeListBuilder.create().texOffs(0, 30).addBox(-4.5F, -55.5F, -15.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(3.5F, -55.5F, -15.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(38, 81).addBox(-4.5F, -55.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 12.0F));

		PartDefinition BeardBottom = Jaw.addOrReplaceChild("BeardBottom", CubeListBuilder.create().texOffs(30, 83).addBox(-5.0F, -53.0F, -5.25F, 10.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BeardLeftFiller_r1 = BeardBottom.addOrReplaceChild("BeardLeftFiller_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-1.5F, -50.25F, -22.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, -0.7941F, 0.0087F));

		PartDefinition BeardRightFiller_r1 = BeardBottom.addOrReplaceChild("BeardRightFiller_r1", CubeListBuilder.create().texOffs(53, 0).addBox(-1.0F, -50.0F, -23.25F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.7941F, 0.0087F));

		PartDefinition BeardFront_r1 = BeardBottom.addOrReplaceChild("BeardFront_r1", CubeListBuilder.create().texOffs(102, 59).addBox(-5.0F, -52.75F, -17.5F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition UpperBody = Torso.addOrReplaceChild("UpperBody", CubeListBuilder.create().texOffs(0, 25).addBox(-11.0F, -26.0F, -5.0F, 22.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(104, 13).addBox(-3.0F, -29.0F, -2.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -18.0F, 5.0F, 2.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(55, 14).addBox(-9.5F, -2.0F, -5.5F, 19.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -0.5F));

		PartDefinition Belly = UpperBody.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(53, 0).addBox(-10.0F, -27.0F, -7.0F, 20.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(54, 46).addBox(-10.0F, -42.0F, -7.0F, 20.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(-10.0F, -28.0F, -8.0F, 20.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(53, 31).addBox(-10.0F, -41.0F, -8.0F, 20.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 75).addBox(-9.0F, -40.0F, -9.0F, 18.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-10.0F, -40.0F, -8.0F, 20.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.5F));

		PartDefinition Ribs = UpperBody.addOrReplaceChild("Ribs", CubeListBuilder.create().texOffs(88, 74).addBox(-10.5F, -41.0F, 4.5F, 21.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 71).addBox(-10.5F, -37.0F, 4.5F, 21.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(55, 27).addBox(-10.5F, -33.0F, 4.5F, 21.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 107).addBox(9.5F, -41.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(106, 45).addBox(9.5F, -37.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(106, 27).addBox(9.5F, -33.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 107).addBox(-10.5F, -41.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(105, 0).addBox(-10.5F, -37.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(48, 102).addBox(-10.5F, -33.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.5F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, -0.5F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(64, 71).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(89, 84).addBox(-3.5F, 12.0F, -3.5F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(40, 59).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 88).addBox(-3.5F, 12.0F, -3.5F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(11.0F, -49.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 96).addBox(0.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(97, 103).addBox(0.5F, 14.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(61, 91).addBox(-5.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(81, 103).addBox(-4.5F, 14.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-22.0F, 0.0F, 0.0F));

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
		ModelPart RightArm = this.TitanFourTwo.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFourTwo.getChild("Torso").getChild("Arms").getChild("LeftArm");
		RightArm.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		LeftArm.xRot = Mth.cos(limbSwing * 0.3331F) * 2.0F * limbSwingAmount * 0.5F;

		// Legs
		ModelPart RightLeg = this.TitanFourTwo.getChild("Torso").getChild("Legs").getChild("RightLeg");
		ModelPart LeftLeg = this.TitanFourTwo.getChild("Torso").getChild("Legs").getChild("LeftLeg");
		RightLeg.xRot = Mth.cos(limbSwing * 0.3331F) * 1.4F * limbSwingAmount;
		LeftLeg.xRot = Mth.cos(limbSwing * 0.3331F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	private void applyIdleAnimation(float ageInTicks) {
		// Calculate a rhythmic motion for arm swaying
		float armSwayAngle = Mth.sin(ageInTicks * 0.1f) * 0.05f; // Small angle for subtle motion

		// Get references to the RightArm and LeftArm
		ModelPart RightArm = this.TitanFourTwo.getChild("Torso").getChild("Arms").getChild("RightArm");
		ModelPart LeftArm = this.TitanFourTwo.getChild("Torso").getChild("Arms").getChild("LeftArm");

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
		TitanFourTwo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TitanFourTwo;
	}
}