package com.legends.edumia.sound;

import com.legends.edumia.Edumia;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent NAZGUL_FADE = registerSoundEvent("nazgul_fade");
    public static SoundEvent NAZGUL_SCREAM = registerSoundEvent("nazgul_scream");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Edumia.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        Edumia.LOGGER.debug("Registering Mod Entities for " + Edumia.MOD_ID);
    }
}
