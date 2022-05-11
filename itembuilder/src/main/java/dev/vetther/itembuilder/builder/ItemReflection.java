package dev.vetther.itembuilder.builder;

import dev.vetther.itembuilder.utils.ReflectionUtils;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.lang.reflect.Field;

public class ItemReflection {

    public static final GsonComponentSerializer GSON = GsonComponentSerializer.gson();
    private static final Field DISPLAY_NAME;
    private static final Field LORE;

    static {
        try {

            Class<?> craftMeta = ReflectionUtils.getCraftClass("inventory.CraftMetaItem");

            if (craftMeta == null) {
                throw new ClassNotFoundException("CraftItemMeta class was not found. Maybe you are using unsupported version");
            }

            DISPLAY_NAME = craftMeta.getDeclaredField("displayName");
            LORE = craftMeta.getDeclaredField("lore");

            DISPLAY_NAME.setAccessible(true);
            LORE.setAccessible(true);

        }catch (NoSuchFieldException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }

    }

    public static Field getDisplayName() {
        return DISPLAY_NAME;
    }

    public static Field getLore() {
        return DISPLAY_NAME;
    }

}
