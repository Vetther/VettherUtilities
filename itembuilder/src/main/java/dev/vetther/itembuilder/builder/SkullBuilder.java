package dev.vetther.itembuilder.builder;

import org.bukkit.inventory.ItemStack;

public class SkullBuilder extends BasicBuilder<SkullBuilder> {

    public SkullBuilder(ItemStack itemStack, int amount) {
        super(itemStack, amount);
    }

    @Override
    protected SkullBuilder getThis() {
        return this;
    }

}
