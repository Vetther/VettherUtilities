package dev.vetther.itembuilder.builder;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemNbt {

    public static Plugin PLUGIN = JavaPlugin.getProvidingPlugin(ItemNbt.class);

    public static <T> ItemMeta set(ItemMeta itemMeta, String key, PersistentDataType<T, T> persistentDataType, T value) {
        ItemMeta meta;
        meta = itemMeta;
        meta.getPersistentDataContainer().set(new NamespacedKey(PLUGIN, key), persistentDataType, value);
        return meta;
    }

    public static ItemMeta remove(ItemMeta itemMeta, String key) {
        ItemMeta meta;
        meta = itemMeta;
        meta.getPersistentDataContainer().remove(new NamespacedKey(PLUGIN, key));
        return meta;
    }

    public static <T> T get(ItemMeta itemMeta, String key, PersistentDataType<T, T> persistentDataType) {
        return itemMeta.getPersistentDataContainer().get(new NamespacedKey(PLUGIN, key), persistentDataType);
    }

    public static boolean getBoolean(ItemMeta itemMeta, String key) {
        return get(itemMeta, key, PersistentDataType.BYTE) == (byte) 1;
    }
}
