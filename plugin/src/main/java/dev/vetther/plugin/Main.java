package dev.vetther.plugin;

import dev.vetther.itembuilder.builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        ItemStack item = ItemBuilder.item(Material.DIAMOND)
                .setName("name")
                .build();

    }
}
