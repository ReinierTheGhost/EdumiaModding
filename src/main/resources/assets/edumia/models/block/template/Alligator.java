// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Alligator<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "alligator"), "main");
	private final ModelPart butt;

	public Alligator(ModelPart root) {
		this.butt = root.getChild("butt");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition butt = partdefinition.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.0F, -0.1F, 14.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.5F, -7.5F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 26).addBox(-6.5F, 0.0F, -12.0F, 13.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 1.3F, 0.0911F, 0.0F, 0.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 46).addBox(-4.5F, -1.0F, -8.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -11.2F, 0.0456F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 62).addBox(-4.5F, -2.0F, -4.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.5F, 0.0911F, 0.0F, 0.0F));

		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(0, 72).addBox(-3.5F, -2.0F, -12.0F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 72).addBox(-3.5F, 0.0F, -12.0F, 7.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.9F));

		PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 95).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.7F));

		PartDefinition cranium = snout.addOrReplaceChild("cranium", CubeListBuilder.create().texOffs(0, 100).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.1227F, 0.0F, 0.0F));

		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(0, 116).addBox(-4.5F, 0.0F, -4.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 2.9F, 0.0F));

		PartDefinition lowJaw2 = lowJaw.addOrReplaceChild("lowJaw2", CubeListBuilder.create().texOffs(42, 149).addBox(-3.0F, 0.0F, -11.75F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.9F));

		PartDefinition lArm1 = chest.addOrReplaceChild("lArm1", CubeListBuilder.create().texOffs(46, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 6.0F, -7.0F, 0.0F, 0.0F, -1.309F));

		PartDefinition lArm2 = lArm1.addOrReplaceChild("lArm2", CubeListBuilder.create().texOffs(63, 0).addBox(-1.5F, 0.158F, -1.9263F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.75F, -1.2298F, 0.0F, 0.0F));

		PartDefinition lHand = lArm2.addOrReplaceChild("lHand", CubeListBuilder.create().texOffs(72, 10).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 90, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		butt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}