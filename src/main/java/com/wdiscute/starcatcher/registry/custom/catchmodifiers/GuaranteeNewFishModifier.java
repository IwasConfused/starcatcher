package com.wdiscute.starcatcher.registry.custom.catchmodifiers;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.U;
import com.wdiscute.starcatcher.io.FishCaughtCounter;
import com.wdiscute.starcatcher.io.ModDataAttachments;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.level.Level;

import java.util.List;

public class GuaranteeNewFishModifier extends AbstractCatchModifier
{
    float chance;

    public GuaranteeNewFishModifier(float changeOutOf100)
    {
        chance = changeOutOf100;
    }

    @Override
    public void afterChoosingTheCatch(List<FishProperties> available)
    {
        super.afterChoosingTheCatch(available);

        if(U.r.nextFloat(100) > chance) return;

        Level level = instance.level();

        List<FishCaughtCounter> fishesCaught = ModDataAttachments.get(instance.player, ModDataAttachments.FISHES_CAUGHT);
        for (FishProperties fp : available)
        {
            boolean caught = false;
            for (FishCaughtCounter fcc : fishesCaught)
            {
                if (fp.equals(level.registryAccess().registryOrThrow(Starcatcher.FISH_REGISTRY).get(fcc.fp())))
                    caught = true;
            }

            if (!caught && fp.hasGuideEntry())
            {
                instance.fpToFish = fp;
                break;
            }
        }
    }
}
