package dev.vetther.itembuilder.builder;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

abstract class BasicBuilder<B extends BasicBuilder<B>> {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    BasicBuilder(ItemStack itemStack, int amount) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        this.itemStack.setAmount(amount);
    }

    public B setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        return this.getThis();
    }

    public B setItemMeta(ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
        return this.getThis();
    }

    public B setType(Material material) {
        this.itemStack.setType(material);
        return this.getThis();
    }

    public B setName(String name) {
        if (itemMeta == null) return this.getThis();
        itemMeta.setDisplayName(name);
        return this.getThis();
    }

    public B name(Component name) {
        if (itemMeta == null) return this.getThis();
        try {
            ItemReflection.getDisplayName().set(this.itemMeta, ItemReflection.GSON.serialize(name));
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return this.getThis();
    }

    public B lore(Component lore) {
        if (itemMeta == null) return this.getThis();
        try {
            ItemReflection.getLore().set(this.itemMeta, ItemReflection.GSON.serialize(lore));
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return this.getThis();
    }

    public B amount(int amount) {
        itemStack.setAmount(amount);
        return this.getThis();
    }

    public B setLore(List<String> lore) {
        if (itemMeta == null) return this.getThis();
        itemMeta.setLore(lore);
        return this.getThis();
    }

    public B setLore(String... lore) {
        if (itemMeta == null) return this.getThis();
        itemMeta.setLore(Arrays.asList(lore));
        return this.getThis();
    }

    public B enchant(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        if (itemMeta == null) return this.getThis();
        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);
        return this.getThis();
    }

    public B enchant(Enchantment enchantment, int level) {
        if (itemMeta == null) return this.getThis();
        itemMeta.addEnchant(enchantment, level, true);
        return this.getThis();
    }

    public B disenchant(Enchantment enchantment) {
        if (itemMeta == null) return this.getThis();
        itemMeta.removeEnchant(enchantment);
        return this.getThis();
    }

    public B unbreakable(boolean unbreakable) {
        if (itemMeta == null) return this.getThis();
        itemMeta.setUnbreakable(unbreakable);
        return this.getThis();
    }

    public B addFlags(ItemFlag... itemFlags) {
        if (itemMeta == null) return this.getThis();
        itemMeta.addItemFlags(itemFlags);
        return this.getThis();
    }

    public B removeFlags(ItemFlag... itemFlags) {
        if (itemMeta == null) return this.getThis();
        itemMeta.removeItemFlags(itemFlags);
        return this.getThis();
    }

    public B setFlags(ItemFlag... itemFlags) {
        if (itemMeta == null) return this.getThis();
        for (ItemFlag itemFlag : itemMeta.getItemFlags()) {
            itemMeta.removeItemFlags(itemFlag);
        }
        itemMeta.addItemFlags(itemFlags);
        return this.getThis();
    }

    public B modelData(int data) {
        if (itemMeta == null) return this.getThis();
        itemMeta.setCustomModelData(data);
        return this.getThis();
    }

    public B damage(int damage) {
        if (itemMeta == null) return this.getThis();
        ((Damageable) itemMeta).setDamage(damage);
        return this.getThis();
    }

    public B setNbt(String key, String value) {
        if (itemMeta == null) return this.getThis();
        itemMeta = ItemNbt.set(itemMeta, key, PersistentDataType.STRING, value);
        return this.getThis();
    }

    public B setNbt(String key, boolean value) {
        if (itemMeta == null) return this.getThis();
        itemMeta = (value)
                ? ItemNbt.set(itemMeta, key, PersistentDataType.BYTE, (byte) 1)
                : ItemNbt.set(itemMeta, key, PersistentDataType.BYTE, (byte) 0);
        return this.getThis();
    }

    public B setNbt(String key, double value) {
        if (this.itemMeta == null) return this.getThis();
        this.itemMeta = ItemNbt.set(this.itemMeta, key, PersistentDataType.DOUBLE, value);
        return this.getThis();
    }

    public B removeNbt(String key) {
        if (this.itemMeta == null) return this.getThis();
        this.itemMeta = ItemNbt.remove(this.itemMeta, key);
        return this.getThis();
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return itemStack;
    }

    protected abstract B getThis();
}
