package com.wdiscute.starcatcher.items.modifieritem;

import com.mojang.datafixers.util.Pair;
import com.wdiscute.starcatcher.io.ModDataComponents;
import com.wdiscute.starcatcher.registry.custom.tackleskin.AbstractTackleSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class TackleSkinModifierItem extends Item
{
    public TackleSkinModifierItem(ResourceLocation tackleSkin)
    {
        this(1, tackleSkin);
    }

    public TackleSkinModifierItem(int maxStackSize, ResourceLocation rl)
    {
        super(new Item.Properties()
                .component(ModDataComponents.TACKLE_SKIN, rl)
                .stacksTo(maxStackSize)
        );
    }
}
