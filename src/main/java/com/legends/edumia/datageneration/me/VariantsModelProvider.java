package com.legends.edumia.datageneration.me;

import net.fabricmc.fabric.api.client.model.ExtraModelProvider;
import com.legends.edumia.Edumia;
import com.legends.edumia.datageneration.me.content.models.SimpleBigItemModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class VariantsModelProvider implements ExtraModelProvider {

    @Override
    public void provideExtraModels(ResourceManager manager, Consumer<Identifier> out) {
        for(Item item : SimpleBigItemModel.items) {
            out.accept(getInventoryModelIdentifierVariant(item));
        }
    }

    public static ModelIdentifier getInventoryModelIdentifierVariant(Item item) {
        return new ModelIdentifier(
                Edumia.MOD_ID, VariantsModelProvider.getKey(item.getTranslationKey()) + "_inventory", "inventory");
    }

    public static String getKey(String path) {
        return path.substring(path.lastIndexOf('.') + 1).trim();
    }
}
