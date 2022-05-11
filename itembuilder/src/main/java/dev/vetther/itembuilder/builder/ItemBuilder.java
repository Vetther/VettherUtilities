package dev.vetther.itembuilder.builder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder extends BasicBuilder<ItemBuilder> {

    public ItemBuilder(ItemStack itemStack, int amount) {
        super(itemStack, amount);
    }

    public static ItemBuilder item(ItemStack itemStack) {
        return new ItemBuilder(itemStack, itemStack.getAmount());
    }

    public static ItemBuilder item(Material material) {
        return new ItemBuilder(new ItemStack(material), 1);
    }

    public static ItemBuilder item(ItemStack itemStack, int amount) {
        return new ItemBuilder(itemStack, amount);
    }

    public static ItemBuilder item(Material material, int amount) {
        return new ItemBuilder(new ItemStack(material), amount);
    }

    public static SkullBuilder skull(ItemStack itemStack) {
        return new SkullBuilder(itemStack, itemStack.getAmount());
    }

    public static SkullBuilder skull(Material material) {
        return new SkullBuilder(new ItemStack(material), 1);
    }

    public static SkullBuilder skull(ItemStack itemStack, int amount) {
        return new SkullBuilder(itemStack, amount);
    }

    public static SkullBuilder skull(Material material, int amount) {
        return new SkullBuilder(new ItemStack(material), amount);
    }

    @Override
    protected ItemBuilder getThis() {
        return this;
    }

}
