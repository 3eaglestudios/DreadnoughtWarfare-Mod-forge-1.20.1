package net.threeeaglestudios.dreadnoughtwarfare.entity.client;// Made with Blockbench 4.12.2
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
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;

public class ArtilleryModel<T extends ArtilleryEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "artillery_real_normal_mc"), "main");
	private final ModelPart Artillery;
	private final ModelPart holders_shield;
	private final ModelPart gun;
	private final ModelPart barrel;
	private final ModelPart endofbarrel;
	private final ModelPart startofbarrel;
	private final ModelPart shield;
	private final ModelPart arty_frame;
	private final ModelPart wheels;
	private final ModelPart shield2;

	public ArtilleryModel(ModelPart root) {
		this.Artillery = root.getChild("Artillery");
		this.holders_shield = this.Artillery.getChild("holders_shield");
		this.gun = this.Artillery.getChild("gun");
		this.barrel = this.gun.getChild("barrel");
		this.endofbarrel = this.barrel.getChild("endofbarrel");
		this.startofbarrel = this.barrel.getChild("startofbarrel");
		this.shield = this.Artillery.getChild("shield");
		this.arty_frame = this.Artillery.getChild("arty_frame");
		this.wheels = this.arty_frame.getChild("wheels");
		this.shield2 = this.Artillery.getChild("shield2");
	}

	//PARTS ARE NOT MADE FOR ANIMATIONS YET - ! REMEMBER !

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Artillery = partdefinition.addOrReplaceChild("Artillery", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8391F, 15.2029F, -10.3578F, 0.0F, 0.0F, -3.1416F));

		PartDefinition holders_shield = Artillery.addOrReplaceChild("holders_shield", CubeListBuilder.create(), PartPose.offset(0.8391F, 2.8184F, 3.6507F));

		PartDefinition cube_r1 = holders_shield.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(178, 125).addBox(-17.0F, -1.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(178, 100).addBox(14.0F, -1.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(156, 169).addBox(0.0F, -1.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(126, 38).addBox(-20.0F, -2.0F, -1.0F, 39.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gun = Artillery.addOrReplaceChild("gun", CubeListBuilder.create(), PartPose.offset(-0.7314F, -12.8743F, 7.6999F));

		PartDefinition cube_r2 = gun.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 181).addBox(-5.4F, -2.5516F, 15.2616F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 6.9008F, 0.013F, 0.0F, 0.1304F, 1.5708F));

		PartDefinition cube_r3 = gun.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 126).addBox(-1.4F, -1.5516F, -43.7384F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.6F, 27.2238F, -0.0928F, 0.0924F, 0.7811F));

		PartDefinition cube_r4 = gun.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(178, 129).addBox(10.6F, -1.5516F, 14.2616F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(156, 165).addBox(10.6F, -1.5516F, 15.2616F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(178, 136).addBox(9.6F, -1.5516F, 17.2616F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.002F))
		.texOffs(144, 171).addBox(1.6F, 0.4484F, 15.2616F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(178, 133).addBox(6.6F, -0.5516F, 15.2616F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.002F)), PartPose.offsetAndRotation(3.4F, -1.7F, -1.0F, 0.0F, 0.1309F, 1.5708F));

		PartDefinition cube_r5 = gun.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(178, 94).addBox(1.6F, -2.5516F, 16.2616F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 6.1F, -2.0F, 0.0F, 0.1309F, 1.5708F));

		PartDefinition cube_r6 = gun.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(178, 73).addBox(5.6F, -0.5516F, 14.2616F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -1.7F, -1.0F, 0.0F, 0.1309F, 1.5708F));

		PartDefinition cube_r7 = gun.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(126, 105).addBox(-6.4F, -2.5516F, -0.7384F, 8.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.1304F, 1.5708F));

		PartDefinition cube_r8 = gun.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(144, 165).addBox(-0.1299F, -0.2815F, 0.5376F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 17.0F, 0.121F, 0.05F, 2.7519F));

		PartDefinition cube_r9 = gun.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(114, 165).addBox(4.6F, -1.5516F, 6.2616F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.6F, -1.0F, 0.0F, 0.1309F, 1.5708F));

		PartDefinition cube_r10 = gun.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(164, 139).addBox(-2.4F, -2.5516F, 6.2616F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0928F, 0.0924F, 0.7811F));

		PartDefinition cube_r11 = gun.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(164, 155).addBox(-3.5F, -2.5516F, 15.2616F, 1.1F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.1304F, 1.5708F));

		PartDefinition cube_r12 = gun.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 181).addBox(-5.4F, 1.4484F, 15.2616F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, 6.9008F, 0.013F, 0.0F, 0.1304F, 1.5708F));

		PartDefinition barrel = gun.addOrReplaceChild("barrel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition endofbarrel = barrel.addOrReplaceChild("endofbarrel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = endofbarrel.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 126).addBox(-1.4F, -1.5516F, -53.7384F, 3.0F, 3.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0928F, 0.0924F, 0.7811F));

		PartDefinition startofbarrel = barrel.addOrReplaceChild("startofbarrel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r14 = startofbarrel.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(126, 0).addBox(-1.9F, -2.0516F, -20.7384F, 4.0F, 4.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0928F, 0.0924F, 0.7811F));

		PartDefinition shield = Artillery.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = shield.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(144, 173).addBox(-17.3486F, -22.2095F, -7.6947F, 9.0F, 18.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4799F, 0.8132F, -0.3615F));

		PartDefinition cube_r16 = shield.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(174, 105).addBox(-11.3537F, -22.2095F, -0.0329F, 8.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(114, 151).addBox(-3.8537F, -22.2095F, -0.0329F, 6.0F, 4.6F, 2.0F, new CubeDeformation(-0.001F))
		.texOffs(166, 173).addBox(2.1463F, -22.2095F, -0.0329F, 8.5F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0928F, 0.4703F, 1.4056F, -0.3229F, 0.0F, 0.0F));

		PartDefinition cube_r17 = shield.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(114, 158).addBox(-3.8537F, -8.2095F, -0.0329F, 6.0F, 4.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0938F, 0.471F, 1.4044F, -0.3229F, 0.0F, 0.0F));

		PartDefinition cube_r18 = shield.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(60, 167).addBox(7.8271F, -22.2095F, -7.2168F, 9.0F, 18.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.1796F, 0.0293F, 0.0876F, -0.4799F, -0.8132F, 0.3615F));

		PartDefinition arty_frame = Artillery.addOrReplaceChild("arty_frame", CubeListBuilder.create(), PartPose.offset(-0.1609F, 2.6971F, 4.3578F));

		PartDefinition cube_r19 = arty_frame.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(178, 65).addBox(-19.0F, -3.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(102, 177).addBox(16.0F, -3.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.1213F, -0.7071F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r20 = arty_frame.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(178, 76).addBox(-8.6F, 1.3F, 59.1F, 3.5F, 4.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4605F, -4.1576F, 3.9113F, -0.0732F, -0.3047F, 0.022F));

		PartDefinition cube_r21 = arty_frame.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(178, 88).addBox(-7.6F, 6.8F, 59.1F, 3.5F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4305F, 10.3309F, 2.8394F, 0.1886F, -0.3047F, 0.022F));

		PartDefinition cube_r22 = arty_frame.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, 2.8F, 8.1F, 2.0F, 2.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9075F, -5.0284F, -5.339F, -0.0732F, -0.3047F, 0.022F));

		PartDefinition cube_r23 = arty_frame.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(178, 91).addBox(4.1F, 6.8F, 59.1F, 3.5F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2695F, 10.3309F, 2.8394F, 0.1886F, 0.3047F, -0.022F));

		PartDefinition cube_r24 = arty_frame.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(178, 82).addBox(5.1F, 1.3F, 59.1F, 3.5F, 4.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2395F, -4.1576F, 3.9113F, -0.0732F, 0.3047F, -0.022F));

		PartDefinition cube_r25 = arty_frame.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(126, 79).addBox(-7.4F, 15.1F, 11.0F, 1.6F, 1.6F, 24.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1948F, -28.1256F, -0.9147F, -0.4223F, -0.3047F, 0.022F));

		PartDefinition cube_r26 = arty_frame.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(126, 53).addBox(5.5F, 15.1F, 11.0F, 1.0F, 1.6F, 24.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1948F, -28.1256F, -0.9147F, -0.4223F, 0.3047F, -0.022F));

		PartDefinition cube_r27 = arty_frame.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).addBox(5.1F, 2.8F, 8.1F, 2.0F, 2.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2075F, -5.0284F, -5.339F, -0.0732F, 0.3047F, -0.022F));

		PartDefinition cube_r28 = arty_frame.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(178, 56).addBox(-8.0F, 3.8F, 2.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.2075F, -4.8284F, -5.339F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r29 = arty_frame.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(82, 177).addBox(6.0F, 3.8F, 2.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2075F, -4.8284F, -5.339F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r30 = arty_frame.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(132, 126).addBox(22.0F, 1.1F, 1.0F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.0F, -3.1F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r31 = arty_frame.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(178, 53).addBox(-8.0F, 2.7F, 1.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.8284F, -1.1716F, 0.0F, 0.0F, 0.0F));

		PartDefinition wheels = arty_frame.addOrReplaceChild("wheels", CubeListBuilder.create().texOffs(82, 151).addBox(-21.0F, -7.0F, -6.0F, 3.0F, 13.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(82, 151).addBox(18.0F, -7.0F, -6.0F, 3.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shield2 = Artillery.addOrReplaceChild("shield2", CubeListBuilder.create(), PartPose.offset(0.8391F, -0.1313F, 3.1862F));

		PartDefinition cube_r32 = shield2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(126, 48).addBox(-19.0F, -4.0F, -1.0F, 36.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r33 = shield2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(126, 42).addBox(-19.0F, -6.0F, -1.0F, 36.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9497F, -4.5355F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(ArtilleryEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		//FOR ME TO REMEMBER FOR OTHER ENTITIES :
		//
		//this.animateWalk(ModAnimationDefinitions.ENTITY_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		//this.animate(entity.idleAnimationState, ModAnimationDefinitions.ENTITY_IDLE, ageInTicks, 1f);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Artillery.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Artillery;
	}
}