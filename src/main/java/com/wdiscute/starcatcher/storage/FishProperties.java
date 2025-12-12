package com.wdiscute.starcatcher.storage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.wdiscute.starcatcher.Config;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.U;
import com.wdiscute.starcatcher.bob.FishingBobEntity;
import com.wdiscute.starcatcher.compat.EclipticSeasonsCompat;
import com.wdiscute.starcatcher.compat.SereneSeasonsCompat;
import com.wdiscute.starcatcher.compat.TerraFirmaCraftSeasonsCompat;
import com.wdiscute.starcatcher.io.ExtraComposites;
import com.wdiscute.starcatcher.io.ModDataComponents;
import com.wdiscute.starcatcher.minigame.modifiers.ModModifiers;
import com.wdiscute.starcatcher.minigame.sweetspotbehaviour.ModSweetSpotsBehaviour;
import com.wdiscute.starcatcher.registry.ModEntities;
import com.wdiscute.starcatcher.registry.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//      <><|    <- fish
public record FishProperties(
        CatchInfo catchInfo,
        int baseChance,
        SizeAndWeight sw,
        Rarity rarity,
        WorldRestrictions wr,
        BaitRestrictions br,
        Difficulty dif,
        Daytime daytime,
        Weather weather,
        boolean skipMinigame,
        boolean hasGuideEntry
)
{
    public static final Codec<FishProperties> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    CatchInfo.CODEC.fieldOf("catch_info").forGetter(FishProperties::catchInfo),
                    Codec.INT.fieldOf("base_chance").forGetter(FishProperties::baseChance),
                    SizeAndWeight.CODEC.fieldOf("size_and_weight").forGetter(FishProperties::sw),
                    Rarity.CODEC.fieldOf("rarity").forGetter(FishProperties::rarity),
                    WorldRestrictions.CODEC.fieldOf("world_restrictions").forGetter(FishProperties::wr),
                    BaitRestrictions.CODEC.fieldOf("bait_restrictions").forGetter(FishProperties::br),
                    Difficulty.CODEC.fieldOf("difficulty").forGetter(FishProperties::dif),
                    Daytime.CODEC.fieldOf("daytime").forGetter(FishProperties::daytime),
                    Weather.CODEC.fieldOf("weather").forGetter(FishProperties::weather),
                    Codec.BOOL.fieldOf("skips_minigame").forGetter(FishProperties::skipMinigame),
                    Codec.BOOL.fieldOf("has_guide_entry").forGetter(FishProperties::hasGuideEntry)

            ).apply(instance, FishProperties::new)
    );

    public static final Codec<List<FishProperties>> LIST_CODEC = FishProperties.CODEC.listOf();

    public static final StreamCodec<RegistryFriendlyByteBuf, FishProperties> STREAM_CODEC = ExtraComposites.composite(
            CatchInfo.STREAM_CODEC, FishProperties::catchInfo,
            ByteBufCodecs.VAR_INT, FishProperties::baseChance,
            SizeAndWeight.STREAM_CODEC, FishProperties::sw,
            Rarity.STREAM_CODEC, FishProperties::rarity,
            WorldRestrictions.STREAM_CODEC, FishProperties::wr,
            BaitRestrictions.STREAM_CODEC, FishProperties::br,
            Difficulty.STREAM_CODEC, FishProperties::dif,
            Daytime.STREAM_CODEC, FishProperties::daytime,
            Weather.STREAM_CODEC, FishProperties::weather,
            ByteBufCodecs.BOOL, FishProperties::skipMinigame,
            ByteBufCodecs.BOOL, FishProperties::hasGuideEntry,
            FishProperties::new
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, List<FishProperties>> STREAM_CODEC_LIST = STREAM_CODEC.apply(ByteBufCodecs.list());


    /**
     * @deprecated use Builder instead
     */
    @Deprecated(forRemoval = true)
    public static final FishProperties DEFAULT = new FishProperties(
            CatchInfo.DEFAULT,
            5,
            SizeAndWeight.DEFAULT,
            Rarity.COMMON,
            WorldRestrictions.DEFAULT,
            BaitRestrictions.DEFAULT,
            Difficulty.DEFAULT,
            Daytime.ALL,
            Weather.ALL,
            false,
            true
    );

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private CatchInfo.Builder catchInfo = new CatchInfo.Builder();
        private int baseChance = 5;

        private SizeAndWeight sw = SizeAndWeight.DEFAULT;
        private Rarity rarity = Rarity.COMMON;
        private WorldRestrictions wr = WorldRestrictions.DEFAULT;
        private BaitRestrictions br = BaitRestrictions.DEFAULT;
        private Difficulty dif = Difficulty.DEFAULT;
        private Daytime daytime = Daytime.ALL;
        private Weather weather = Weather.ALL;
        private boolean skipMinigame = false;
        private boolean hasGuideEntry = true;

        public Builder withCatchInfo(CatchInfo.Builder builder)
        {
            this.catchInfo = builder;
            return this;
        }

        public Builder withFish(Holder<Item> fish)
        {
            this.catchInfo.withFish(fish);
            return this;
        }

        public Builder withBucketedFish(Holder<Item> bucketedFish)
        {
            this.catchInfo.withBucketedFish(bucketedFish);
            return this;
        }

        public Builder withEntityToSpawn(Holder<EntityType<?>> entity)
        {
            this.catchInfo.withEntityToSpawn(entity);
            return this;
        }

        public Builder withAlwaysSpawnEntity(boolean alwaysSpawnEntity)
        {
            this.catchInfo.withAlwaysSpawnEntity(alwaysSpawnEntity);
            return this;
        }

        public Builder withItemToOverrideWith(Holder<Item> itemToOverrideWith)
        {
            this.catchInfo.withOverrideMinigameWith(itemToOverrideWith);
            return this;
        }

        public Builder withBaseChance(int baseChance)
        {
            this.baseChance = baseChance;
            return this;
        }

        public Builder withSizeAndWeight(SizeAndWeight sizeAndWeight)
        {
            this.sw = sizeAndWeight;
            return this;
        }

        public Builder withRarity(Rarity rarity)
        {
            this.rarity = rarity;
            return this;
        }

        public Builder withWorldRestrictions(WorldRestrictions wr)
        {
            this.wr = wr;
            return this;
        }

        public Builder withBaitRestrictions(BaitRestrictions br)
        {
            this.br = br;
            return this;
        }

        public Builder withDifficulty(Difficulty dif)
        {
            this.dif = dif;
            return this;
        }

        public Builder withDaytime(Daytime daytime)
        {
            this.daytime = daytime;
            return this;
        }

        public Builder withWeather(Weather weather)
        {
            this.weather = weather;
            return this;
        }

        public Builder withSkipMinigame(boolean skipMinigame)
        {
            this.skipMinigame = skipMinigame;
            return this;
        }

        public Builder withHasGuideEntry(boolean hasGuideEntry)
        {
            this.hasGuideEntry = hasGuideEntry;
            return this;
        }

        public Builder withSeasons(WorldRestrictions.Seasons... seasons)
        {
            this.wr = this.wr.withSeasons(seasons);
            return this;
        }

        public FishProperties build()
        {
            return new FishProperties(
                    catchInfo.build(),
                    baseChance,
                    sw,
                    rarity,
                    wr,
                    br,
                    dif,
                    daytime,
                    weather,
                    skipMinigame,
                    hasGuideEntry
            );
        }
    }

    //region CatchInfo
    public record CatchInfo(
            Holder<Item> fish,
            Holder<Item> bucketedFish,
            Holder<EntityType<?>> entityToSpawn,
            boolean alwaysSpawnEntity,
            Holder<Item> overrideMinigameWith,
            Holder<Item> treasure
    )
    {
        public static final Codec<CatchInfo> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        BuiltInRegistries.ITEM.holderByNameCodec().fieldOf("item").forGetter(CatchInfo::fish),
                        BuiltInRegistries.ITEM.holderByNameCodec().fieldOf("fish_bucket").forGetter(CatchInfo::bucketedFish),
                        BuiltInRegistries.ENTITY_TYPE.holderByNameCodec().fieldOf("entity").forGetter(CatchInfo::entityToSpawn),
                        Codec.BOOL.fieldOf("always_spawn_entity").forGetter(CatchInfo::alwaysSpawnEntity),
                        BuiltInRegistries.ITEM.holderByNameCodec().optionalFieldOf("override_minigame_item", ModItems.MISSINGNO).forGetter(CatchInfo::overrideMinigameWith),
                        BuiltInRegistries.ITEM.holderByNameCodec().optionalFieldOf("treasure", ModItems.MISSINGNO).forGetter(CatchInfo::treasure)
                ).apply(instance, CatchInfo::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CatchInfo> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.holderRegistry(Registries.ITEM), CatchInfo::fish,
                ByteBufCodecs.holderRegistry(Registries.ITEM), CatchInfo::bucketedFish,
                ByteBufCodecs.holderRegistry(Registries.ENTITY_TYPE), CatchInfo::entityToSpawn,
                ByteBufCodecs.BOOL, CatchInfo::alwaysSpawnEntity,
                ByteBufCodecs.holderRegistry(Registries.ITEM), CatchInfo::overrideMinigameWith,
                ByteBufCodecs.holderRegistry(Registries.ITEM), CatchInfo::treasure,
                CatchInfo::new
        );

        public static final CatchInfo DEFAULT = new CatchInfo(
                ModItems.MISSINGNO,
                ModItems.MISSINGNO,
                //cant use entity reference as its not registered for the psf
                U.holderEntity("starcatcher", "fish"),
                false,
                ModItems.MISSINGNO,
                ModItems.WATERLOGGED_SATCHEL
        );

        public CatchInfo withItemToOverrideWith(Holder<Item> itemToOverrideWith)
        {
            return new CatchInfo(this.fish, this.bucketedFish, this.entityToSpawn, alwaysSpawnEntity, itemToOverrideWith, this.treasure);
        }

        public static class Builder
        {
            private Holder<Item> fish = ModItems.MISSINGNO;
            private Holder<Item> bucketedFish = ModItems.MISSINGNO;
            private Holder<EntityType<?>> entityToSpawn = U.holderEntity("starcatcher", "fish");
            private boolean alwaysSpawnEntity = false;
            private Holder<Item> itemToOverrideWith = ModItems.MISSINGNO;
            private Holder<Item> treasure = ModItems.WATERLOGGED_SATCHEL;

            public Builder withFish(Holder<Item> fish)
            {
                this.fish = fish;
                return this;
            }

            public Builder withBucketedFish(Holder<Item> bucketedFish)
            {
                this.bucketedFish = bucketedFish;
                return this;
            }

            public Builder withEntityToSpawn(Holder<EntityType<?>> entityToSpawn)
            {
                this.entityToSpawn = entityToSpawn;
                return this;
            }

            public Builder withAlwaysSpawnEntity(boolean alwaysSpawnEntity)
            {
                this.alwaysSpawnEntity = alwaysSpawnEntity;
                return this;
            }

            public Builder withOverrideMinigameWith(Holder<Item> itemToOverrideWith)
            {
                this.itemToOverrideWith = itemToOverrideWith;
                return this;
            }

            public Builder withTreasure(Holder<Item> treasure)
            {
                this.treasure = treasure;
                return this;
            }

            public CatchInfo build()
            {
                return new CatchInfo(fish, bucketedFish, entityToSpawn, alwaysSpawnEntity, itemToOverrideWith, treasure);
            }
        }
    }

    //endregion CatchInfo


    //region bait

    public record BaitRestrictions(
            List<ResourceLocation> correctBait,
            boolean consumesBait,
            int correctBaitChanceAdded
    )
    {
        public static final Codec<BaitRestrictions> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.list(ResourceLocation.CODEC).fieldOf("correct_baits").forGetter(BaitRestrictions::correctBait),
                        Codec.BOOL.fieldOf("consumes_bait").forGetter(BaitRestrictions::consumesBait),
                        Codec.INT.fieldOf("correct_bait_chance_added").forGetter(BaitRestrictions::correctBaitChanceAdded)
                ).apply(instance, BaitRestrictions::new));


        public static final StreamCodec<ByteBuf, BaitRestrictions> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), BaitRestrictions::correctBait,
                ByteBufCodecs.BOOL, BaitRestrictions::consumesBait,
                ByteBufCodecs.INT, BaitRestrictions::correctBaitChanceAdded,
                BaitRestrictions::new
        );

        public static final BaitRestrictions DEFAULT = new BaitRestrictions(
                List.of(),
                true,
                0);

        public static final BaitRestrictions FISH_OF_THIEVES = new BaitRestrictions(
                List.of(rl("fishofthieves", "earthworms"), rl("fishofthieves", "grubs"), rl("fishofthieves", "leeches")),
                true,
                20);

        public static final BaitRestrictions CHERRY_BAIT = new BaitRestrictions(
                List.of(ModItems.CHERRY_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions LUSH_BAIT = new BaitRestrictions(
                List.of(ModItems.LUSH_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions SCULK_BAIT = new BaitRestrictions(
                List.of(ModItems.SCULK_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions DRIPSTONE_BAIT = new BaitRestrictions(
                List.of(ModItems.DRIPSTONE_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions MURKWATER_BAIT = new BaitRestrictions(
                List.of(ModItems.MURKWATER_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions LEGENDARY_BAIT = new BaitRestrictions(
                List.of(ModItems.LEGENDARY_BAIT.getId()),
                true,
                15);

        public static final BaitRestrictions LEGENDARY_BAIT_VOIDBITER = new BaitRestrictions(
                List.of(ModItems.LEGENDARY_BAIT.getId()),
                true,
                50);

        public BaitRestrictions withCorrectBait(ResourceLocation... correctBait)
        {
            return new BaitRestrictions(List.of(correctBait), this.consumesBait, this.correctBaitChanceAdded);
        }

        public BaitRestrictions withConsumesBait(boolean consumesBait)
        {
            return new BaitRestrictions(this.correctBait, consumesBait, this.correctBaitChanceAdded);
        }

        public BaitRestrictions withCorrectBaitChanceAdded(int correctBaitChanceAdded)
        {
            return new BaitRestrictions(this.correctBait, consumesBait, correctBaitChanceAdded);
        }
    }

    //endregion bait

    //region world
    public record WorldRestrictions(
            List<ResourceLocation> dims,
            List<ResourceLocation> dimsBlacklist,
            List<ResourceLocation> biomes,
            List<ResourceLocation> biomesTags,
            List<ResourceLocation> biomesBlacklist,
            List<ResourceLocation> biomesBlacklistTags,
            List<ResourceLocation> fluids,
            List<Seasons> seasons,
            int mustBeCaughtBelowY,
            int mustBeCaughtAboveY
    )
    {
        public enum Seasons implements StringRepresentable
        {
            ALL("all"),

            SPRING("spring"),
            EARLY_SPRING("early_spring"),
            MID_SPRING("mid_spring"),
            LATE_SPRING("late_spring"),

            SUMMER("summer"),
            EARLY_SUMMER("early_summer"),
            MID_SUMMER("mid_summer"),
            LATE_SUMMER("late_summer"),

            AUTUMN("autumn"),
            EARLY_AUTUMN("early_autumn"),
            MID_AUTUMN("mid_autumn"),
            LATE_AUTUMN("late_autumn"),

            WINTER("winter"),
            EARLY_WINTER("early_winter"),
            MID_WINTER("mid_winter"),
            LATE_WINTER("late_winter");

            public static final Codec<FishProperties.WorldRestrictions.Seasons> CODEC = StringRepresentable.fromEnum(FishProperties.WorldRestrictions.Seasons::values);
            public static final Codec<List<FishProperties.WorldRestrictions.Seasons>> LIST_CODEC = Seasons.CODEC.listOf();
            public static final StreamCodec<RegistryFriendlyByteBuf, FishProperties.WorldRestrictions.Seasons> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(FishProperties.WorldRestrictions.Seasons.class);
            public static final StreamCodec<RegistryFriendlyByteBuf, List<FishProperties.WorldRestrictions.Seasons>> LIST_STREAM_CODEC = STREAM_CODEC.apply(ByteBufCodecs.list());
            private final String key;

            Seasons(String key)
            {
                this.key = key;
            }

            public String getSerializedName()
            {
                return this.key;
            }

        }


        public static final WorldRestrictions DEFAULT = new WorldRestrictions(
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(ResourceLocation.withDefaultNamespace("water")),
                List.of(Seasons.ALL),
                Integer.MAX_VALUE,
                Integer.MIN_VALUE);

        public static final Codec<WorldRestrictions> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.list(ResourceLocation.CODEC).fieldOf("dimensions").forGetter(WorldRestrictions::dims),
                        Codec.list(ResourceLocation.CODEC).fieldOf("dimensions_blacklist").forGetter(WorldRestrictions::dimsBlacklist),
                        Codec.list(ResourceLocation.CODEC).fieldOf("biomes").forGetter(WorldRestrictions::biomes),
                        Codec.list(ResourceLocation.CODEC).fieldOf("biomes_tags").forGetter(WorldRestrictions::biomesTags),
                        Codec.list(ResourceLocation.CODEC).fieldOf("biomes_blacklist").forGetter(WorldRestrictions::biomesBlacklist),
                        Codec.list(ResourceLocation.CODEC).fieldOf("biomes_blacklist_tags").forGetter(WorldRestrictions::biomesBlacklistTags),
                        Codec.list(ResourceLocation.CODEC).fieldOf("fluids").forGetter(WorldRestrictions::fluids),
                        Seasons.LIST_CODEC.fieldOf("seasons").forGetter(WorldRestrictions::seasons),
                        Codec.INT.fieldOf("below_y").forGetter(WorldRestrictions::mustBeCaughtBelowY),
                        Codec.INT.fieldOf("above_y").forGetter(WorldRestrictions::mustBeCaughtAboveY)
                ).apply(instance, WorldRestrictions::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WorldRestrictions> STREAM_CODEC = ExtraComposites.composite(
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::dims,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::dimsBlacklist,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::biomes,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::biomesTags,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::biomesBlacklist,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::biomesBlacklistTags,
                ByteBufCodecs.fromCodec(Codec.list(ResourceLocation.CODEC)), WorldRestrictions::fluids,
                Seasons.LIST_STREAM_CODEC, WorldRestrictions::seasons,
                ByteBufCodecs.VAR_INT, WorldRestrictions::mustBeCaughtBelowY,
                ByteBufCodecs.VAR_INT, WorldRestrictions::mustBeCaughtAboveY,
                WorldRestrictions::new
        );

        public static final WorldRestrictions OVERWORLD =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location());

        public static final WorldRestrictions OVERWORLD_LUSH_CAVES =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomes(Biomes.LUSH_CAVES.location())
                        .withMustBeCaughtBelowY(50);

        public static final WorldRestrictions OVERWORLD_STONE_CAVES =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withMustBeCaughtBelowY(50)
                        .withMustBeCaughtAboveY(0);

        public static final WorldRestrictions OVERWORLD_DEEPSLATE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withMustBeCaughtBelowY(0);

        public static final WorldRestrictions OVERWORLD_DRIPSTONE_CAVES =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomes(Biomes.DRIPSTONE_CAVES.location())
                        .withMustBeCaughtBelowY(50)
                        .withMustBeCaughtAboveY(0);

        public static final WorldRestrictions OVERWORLD_DEEP_DARK =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomes(Biomes.DEEP_DARK.location())
                        .withMustBeCaughtBelowY(50);

        public static final WorldRestrictions OVERWORLD_RIVER =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_RIVER)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_OCEAN =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags((StarcatcherTags.IS_OCEAN))
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_WARM_OCEAN =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_WARM_OCEAN)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_DEEP_OCEAN =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_DEEP_OCEAN)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_LAKE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesBlacklistTags(StarcatcherTags.IS_OCEAN, StarcatcherTags.IS_RIVER)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_FRESHWATER =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesBlacklistTags(StarcatcherTags.IS_OCEAN)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_COLD_FRESHWATER =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_COLD_LAKE, StarcatcherTags.IS_COLD_RIVER)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_WARM_FRESHWATER =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_WARM_LAKE, StarcatcherTags.IS_WARM_RIVER)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_WARM_LAKE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_WARM_LAKE)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_COLD_RIVER =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_COLD_RIVER)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_COLD_OCEAN =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_COLD_OCEAN)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_COLD_LAKE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_COLD_LAKE)
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(100);

        public static final WorldRestrictions OVERWORLD_COLD_MOUNTAIN =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_COLD_LAKE)
                        .withMustBeCaughtAboveY(100);

        public static final WorldRestrictions OVERWORLD_BEACH =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_BEACH)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_MUSHROOM_FIELDS =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_MUSHROOM_FIELDS)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_JUNGLE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(BiomeTags.IS_JUNGLE.location())
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_TAIGA =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(BiomeTags.IS_TAIGA.location())
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_CHERRY_GROVE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_CHERRY_GROVE)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_SWAMP =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_SWAMP)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_DARK_FOREST =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withBiomesTags(StarcatcherTags.IS_DARK_FOREST)
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_SURFACE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_LAVA_SURFACE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"))
                        .withMustBeCaughtAboveY(50);

        public static final WorldRestrictions OVERWORLD_LAVA_UNDERGROUND =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"))
                        .withMustBeCaughtBelowY(50);

        public static final WorldRestrictions OVERWORLD_UNDERGROUND =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withMustBeCaughtBelowY(50);

        public static final WorldRestrictions OVERWORLD_LAVA_DEEPSLATE =
                WorldRestrictions.DEFAULT
                        .withDims(Level.OVERWORLD.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"))
                        .withMustBeCaughtBelowY(0);

        public static final WorldRestrictions NETHER_LAVA =
                WorldRestrictions.DEFAULT
                        .withDims(Level.NETHER.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"));

        public static final WorldRestrictions NETHER_LAVA_CRIMSON_FOREST =
                WorldRestrictions.DEFAULT
                        .withDims(Level.NETHER.location())
                        .withBiomes(Biomes.CRIMSON_FOREST.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"));

        public static final WorldRestrictions NETHER_LAVA_WARPED_FOREST =
                WorldRestrictions.DEFAULT
                        .withDims(Level.NETHER.location())
                        .withBiomes(Biomes.WARPED_FOREST.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"));

        public static final WorldRestrictions NETHER_LAVA_SOUL_SAND_VALLEY =
                WorldRestrictions.DEFAULT
                        .withDims(Level.NETHER.location())
                        .withBiomes(Biomes.SOUL_SAND_VALLEY.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"));

        public static final WorldRestrictions NETHER_LAVA_BASALT_DELTAS =
                WorldRestrictions.DEFAULT
                        .withDims(Level.NETHER.location())
                        .withBiomes(Biomes.BASALT_DELTAS.location())
                        .withFluids(ResourceLocation.withDefaultNamespace("lava"));

        public static final WorldRestrictions END =
                WorldRestrictions.DEFAULT
                        .withDims(Level.END.location());

        public static final WorldRestrictions END_OUTER_ISLANDS =
                WorldRestrictions.DEFAULT
                        .withDims(Level.END.location())
                        .withBiomesTags(BiomeTags.IS_END.location())
                        .withBiomesBlacklist(Biomes.THE_END.location());

        public WorldRestrictions withDims(ResourceLocation... dims)
        {
            return new WorldRestrictions(List.of(dims), this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withDimsBlacklist(ResourceLocation... dimsBlacklist)
        {
            return new WorldRestrictions(this.dims, List.of(dimsBlacklist), this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withBiomes(ResourceLocation... biome)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, List.of(biome), this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withBiomesTags(ResourceLocation... biomesTag)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, List.of(biomesTag), this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withBiomesBlacklist(ResourceLocation... biomesBlacklist)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, List.of(biomesBlacklist), this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withBiomesBlacklistTags(ResourceLocation... biomesBlacklistTags)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, List.of(biomesBlacklistTags), this.fluids, this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withFluids(ResourceLocation... fluids)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, List.of(fluids), this.seasons, this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withSeasons(Seasons... seasons)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, Arrays.stream(seasons).toList(), this.mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withMustBeCaughtBelowY(int mustBeCaughtBelowY)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, mustBeCaughtBelowY, this.mustBeCaughtAboveY);
        }

        public WorldRestrictions withMustBeCaughtAboveY(int mustBeCaughtAboveY)
        {
            return new WorldRestrictions(this.dims, this.dimsBlacklist, this.biomes, this.biomesTags, this.biomesBlacklist, this.biomesBlacklistTags, this.fluids, this.seasons, this.mustBeCaughtBelowY, mustBeCaughtAboveY);
        }

    }

    //region dif

    public record Difficulty(
            int speed,
            int penalty,
            float decay,
            List<SweetSpot> sweetSpots,
            List<ResourceLocation> modifiers
    )
    {
        //region preset difficulties

        public static Difficulty DEFAULT = new Difficulty(
                9, 10, 1,
                List.of(SweetSpot.NORMAL, SweetSpot.NORMAL),
                List.of()
        );

        public static Difficulty MEDIUM = DEFAULT;
        public static Difficulty HARD = DEFAULT;
        public static Difficulty THIN_NO_DECAY_NOT_FORGIVING = DEFAULT;
        public static Difficulty HARD_ONLY_THIN_MOVING = DEFAULT;
        public static Difficulty EVERYTHING_FLIP = DEFAULT;
        public static Difficulty EVERYTHING = DEFAULT;
        public static Difficulty MEDIUM_VANISHING = DEFAULT;
        public static Difficulty EASY_MOVING = DEFAULT;
        public static Difficulty REALLY_HEAVY_FISH = DEFAULT;
        public static Difficulty EASY_FAST_FISH = DEFAULT;
        public static Difficulty HARD_VANISHING = DEFAULT;
        public static Difficulty MEDIUM_MOVING = DEFAULT;
        public static Difficulty MEDIUM_FAST_FISH_VANISHING = DEFAULT;
        public static Difficulty EASY_VANISHING = DEFAULT;
        public static Difficulty HARD_MOVING = DEFAULT;
        public static Difficulty MEDIUM_VANISHING_MOVING = DEFAULT;
        public static Difficulty SINGLE_BIG_FAST_MOVING = DEFAULT;
        public static Difficulty HARD_ONLY_THIN = DEFAULT;
        public static Difficulty SINGLE_BIG_FAST = DEFAULT;
        public static Difficulty THIN_NO_DECAY = DEFAULT;
        public static Difficulty MEDIUM_MOVING_NO_FLIP = DEFAULT;
        public static Difficulty EVERYTHING_VANISHING = DEFAULT;
        public static Difficulty EVERYTHING_FLIP_MOVING = DEFAULT;
        public static Difficulty NON_STOP_ACTION_VANISHING = DEFAULT;
        public static Difficulty SINGLE_BIG_FAST_NO_DECAY = DEFAULT;
        public static Difficulty EASY_NO_FLIP_VANISHING = DEFAULT;
        public static Difficulty VESANI = DEFAULT;
        public static Difficulty NON_STOP_ACTION = DEFAULT;
        public static Difficulty MOVING_THIN_NO_DECAY = DEFAULT;
        public static Difficulty SINGLE_BIG_FAST_NO_DECAY_VANISHING = DEFAULT;
        public static Difficulty THIN_NO_DECAY_NOT_FORGIVING_MOVING = DEFAULT;
        public static Difficulty FAT_CATCH = DEFAULT;
        public static Difficulty VOIDBITER = DEFAULT;

        public static Difficulty WITHER = new Difficulty(
                10, 30, 1,
                List.of(SweetSpot.WITHER_BIG, SweetSpot.WITHER, SweetSpot.WITHER),
                List.of());

        public static Difficulty CREEPER = new Difficulty(
                10, 20, 1,
                List.of(SweetSpot.CREEPER, SweetSpot.CREEPER),
                List.of(ModModifiers.SPAWN_TNT_SWEET_SPOTS));

        //endregion preset difficulties



        public static final Codec<Difficulty> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.INT.fieldOf("speed").forGetter(Difficulty::speed),
                        Codec.INT.fieldOf("missPenalty").forGetter(Difficulty::penalty),
                        Codec.FLOAT.fieldOf("decay").forGetter(Difficulty::decay),
                        SweetSpot.LIST_CODEC.fieldOf("sweetspots").forGetter(Difficulty::sweetSpots),
                        ResourceLocation.CODEC.listOf().fieldOf("modifiers").forGetter(Difficulty::modifiers)
                ).apply(instance, Difficulty::new));


        public static final StreamCodec<FriendlyByteBuf, Difficulty> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.INT, Difficulty::speed,
                ByteBufCodecs.INT, Difficulty::penalty,
                ByteBufCodecs.FLOAT, Difficulty::decay,
                SweetSpot.LIST_STREAM_CODEC, Difficulty::sweetSpots,
                ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()), Difficulty::modifiers,
                Difficulty::new
        );
    }

    public record SweetSpot(
            ResourceLocation sweetSpotType,
            ResourceLocation texturePath,
            int size,
            int reward,
            boolean isFlip,
            boolean isVanishing,
            boolean isMoving,
            int particleColor
    )
    {
        private static final ResourceLocation RL_NORMAL = Starcatcher.rl("textures/gui/minigame/spots/normal.png");
        private static final ResourceLocation RL_THIN = Starcatcher.rl("textures/gui/minigame/spots/thin.png");
        private static final ResourceLocation RL_FREEZE = Starcatcher.rl("textures/gui/minigame/spots/frozen.png");
        private static final ResourceLocation RL_TREASURE = Starcatcher.rl("textures/gui/minigame/spots/treasure.png");
        private static final ResourceLocation RL_WITHER = Starcatcher.rl("textures/gui/minigame/spots/wither.png");
        private static final ResourceLocation RL_WITHER_BIG = Starcatcher.rl("textures/gui/minigame/spots/wither_big.png");
        private static final ResourceLocation RL_CREEPER = Starcatcher.rl("textures/gui/minigame/spots/creeper.png");
        private static final ResourceLocation RL_TNT = Starcatcher.rl("textures/gui/minigame/spots/tnt.png");

        public static SweetSpot NORMAL_STEADY = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_NORMAL,
                33,
                10,
                false,
                false,
                false,
                0x00ff00
        );

        public static SweetSpot NORMAL = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_NORMAL,
                22,
                10,
                false,
                false,
                false,
                0x00ff00
        );

        public static SweetSpot THIN_STEADY = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_THIN,
                20,
                10,
                false,
                false,
                false,
                0x00ff00
        );

        public static SweetSpot THIN = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_THIN,
                15,
                10,
                false,
                false,
                false,
                0x00ff00
        );



        public static SweetSpot FREEZE = new SweetSpot(
                ModSweetSpotsBehaviour.FROZEN,
                RL_FREEZE,
                33,
                10,
                false,
                false,
                false,
                0x095f92
        );

        public static SweetSpot TREASURE = new SweetSpot(
                ModSweetSpotsBehaviour.TREASURE,
                RL_TREASURE,
                20,
                10,
                false,
                false,
                false,
                0xFFD700
        );

        public static SweetSpot WITHER = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_WITHER,
                22,
                10,
                false,
                false,
                true,
                0x1f1f1f
        );

        public static SweetSpot WITHER_BIG = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_WITHER_BIG,
                33,
                10,
                false,
                false,
                false,
                0x1f1f1f
        );

        public static SweetSpot CREEPER = new SweetSpot(
                ModSweetSpotsBehaviour.NORMAL,
                RL_CREEPER,
                22,
                10,
                false,
                false,
                false,
                0x515353
        );

        public static SweetSpot TNT = new SweetSpot(
                ModSweetSpotsBehaviour.TNT,
                RL_TNT,
                33,
                30,
                false,
                false,
                false,
                0xff0000
        );

        public static final Codec<SweetSpot> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        ResourceLocation.CODEC.fieldOf("sweet_spot_type").forGetter(SweetSpot::sweetSpotType),
                        ResourceLocation.CODEC.fieldOf("texture_path").forGetter(SweetSpot::texturePath),
                        Codec.INT.fieldOf("hitbox_size_in_pixels").forGetter(SweetSpot::size),
                        Codec.INT.fieldOf("reward").forGetter(SweetSpot::reward),
                        Codec.BOOL.fieldOf("is_flip").forGetter(SweetSpot::isFlip),
                        Codec.BOOL.fieldOf("is_vanishing").forGetter(SweetSpot::isVanishing),
                        Codec.BOOL.fieldOf("is_moving").forGetter(SweetSpot::isMoving),
                        Codec.INT.fieldOf("color_as_int").forGetter(SweetSpot::particleColor)
                ).apply(instance, SweetSpot::new));

        public static final Codec<List<SweetSpot>> LIST_CODEC = CODEC.listOf();

        public static final StreamCodec<FriendlyByteBuf, SweetSpot> STREAM_CODEC = ExtraComposites.composite(
                ResourceLocation.STREAM_CODEC, SweetSpot::sweetSpotType,
                ResourceLocation.STREAM_CODEC, SweetSpot::texturePath,
                ByteBufCodecs.INT, SweetSpot::size,
                ByteBufCodecs.INT, SweetSpot::reward,
                ByteBufCodecs.BOOL, SweetSpot::isFlip,
                ByteBufCodecs.BOOL, SweetSpot::isVanishing,
                ByteBufCodecs.BOOL, SweetSpot::isMoving,
                ByteBufCodecs.INT, SweetSpot::particleColor,
                SweetSpot::new
        );

        public static final StreamCodec<FriendlyByteBuf, List<SweetSpot>> LIST_STREAM_CODEC = STREAM_CODEC.apply(ByteBufCodecs.list());
    }

    //endregion dif


    public record SizeAndWeight(float sizeAverage, float sizeDeviation, float weightAverage, float weightDeviation)
    {
        public static final SizeAndWeight DEFAULT = new SizeAndWeight(41f, 21f, 2001f, 701f);
        public static final SizeAndWeight NONE = new SizeAndWeight(0, 0, 0, 0);

        public static final Codec<SizeAndWeight> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.FLOAT.fieldOf("average_size_cm").forGetter(SizeAndWeight::sizeAverage),
                        Codec.FLOAT.fieldOf("deviation_size_cm").forGetter(SizeAndWeight::sizeDeviation),
                        Codec.FLOAT.fieldOf("average_weight_grams").forGetter(SizeAndWeight::weightAverage),
                        Codec.FLOAT.fieldOf("deviation_weight_grams").forGetter(SizeAndWeight::weightDeviation)
                ).apply(instance, SizeAndWeight::new));

        public static final StreamCodec<ByteBuf, SizeAndWeight> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.FLOAT, SizeAndWeight::sizeAverage,
                ByteBufCodecs.FLOAT, SizeAndWeight::sizeDeviation,
                ByteBufCodecs.FLOAT, SizeAndWeight::weightAverage,
                ByteBufCodecs.FLOAT, SizeAndWeight::weightDeviation,
                SizeAndWeight::new
        );
    }


    public enum Rarity implements StringRepresentable
    {
        COMMON("common", 4, "", "", Style.EMPTY.applyFormat(ChatFormatting.WHITE)),
        UNCOMMON("uncommon", 8, "<gradient-37>", "</gradient-43>", Style.EMPTY.applyFormat(ChatFormatting.GREEN)),
        RARE("rare", 12, "<gradient-57>", "</gradient-63>", Style.EMPTY.applyFormat(ChatFormatting.BLUE)),
        EPIC("epic", 20, "<gradient-80>", "</gradient-90>", Style.EMPTY.applyFormat(ChatFormatting.LIGHT_PURPLE)),
        LEGENDARY("legendary", 35, "<rgb>", "</rgb>", Style.EMPTY.applyFormat(ChatFormatting.GOLD));

        public static final Codec<Rarity> CODEC = StringRepresentable.fromEnum(Rarity::values);
        public static final StreamCodec<FriendlyByteBuf, Rarity> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(Rarity.class);
        private final String key;
        private final int xp;
        private final String pre;
        private final String post;
        private final Style style;

        Rarity(String key, int xp, String pre, String post, Style style)
        {
            this.key = key;
            this.xp = xp;
            this.pre = pre;
            this.post = post;
            this.style = style;
        }

        public String getSerializedName()
        {
            return this.key;
        }

        public int getId()
        {
            return this.ordinal();
        }

        public int getXp()
        {
            return xp;
        }

        public String getPre()
        {
            return pre;
        }

        public String getPost()
        {
            return post;
        }

        public Style getStyle()
        {
            return style;
        }
    }

    public enum Daytime implements StringRepresentable
    {
        ALL("all"),
        DAY("day"),
        NOON("noon"),
        NIGHT("night"),
        MIDNIGHT("midnight");

        public static final Codec<Daytime> CODEC = StringRepresentable.fromEnum(Daytime::values);
        public static final StreamCodec<FriendlyByteBuf, Daytime> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(Daytime.class);
        private final String key;

        Daytime(String key)
        {
            this.key = key;
        }

        public String getSerializedName()
        {
            return this.key;
        }
    }

    public enum Weather implements StringRepresentable
    {
        ALL("all"),
        CLEAR("clear"),
        RAIN("rain"),
        THUNDER("thunder");

        public static final Codec<Weather> CODEC = StringRepresentable.fromEnum(Weather::values);
        public static final StreamCodec<FriendlyByteBuf, Weather> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(Weather.class);
        private final String key;

        Weather(String key)
        {
            this.key = key;
        }

        public String getSerializedName()
        {
            return this.key;
        }
    }

    public static List<ResourceLocation> getBiomesAsList(FishProperties fp, Level level)
    {
        level.registryAccess().registry(Registries.BIOME);

        List<ResourceLocation> rls = new ArrayList<>();

        for (ResourceLocation rl : fp.wr.biomesTags)
        {
            TagKey<Biome> biomeBeingChecked = TagKey.create(Registries.BIOME, rl);

            Optional<HolderSet.Named<Biome>> optional = level.registryAccess().lookupOrThrow(Registries.BIOME).get(biomeBeingChecked);

            if (optional.isPresent())
            {
                for (Holder<Biome> biomeHolder : optional.get())
                {
                    String biomeString = biomeHolder.getRegisteredName();

                    rls.add(ResourceLocation.parse(biomeString));
                }
            }
        }

        for (ResourceLocation rl : fp.wr.biomes)
        {
            Optional<Holder.Reference<Biome>> optional = level.registryAccess().lookupOrThrow(Registries.BIOME).get(ResourceKey.create(Registries.BIOME, rl));
            if (optional.isPresent()) if (!rls.contains(rl)) rls.add(rl);
        }

        return rls;
    }

    public static List<ResourceLocation> getBiomesBlacklistAsList(FishProperties fp, Level level)
    {
        level.registryAccess().registry(Registries.BIOME);

        List<ResourceLocation> rls = new ArrayList<>();

        for (ResourceLocation rl : fp.wr.biomesBlacklistTags)
        {
            TagKey<Biome> biomeBeingChecked = TagKey.create(Registries.BIOME, rl);

            Optional<HolderSet.Named<Biome>> optional = level.registryAccess().lookupOrThrow(Registries.BIOME).get(biomeBeingChecked);

            if (optional.isPresent())
            {
                for (Holder<Biome> biomeHolder : optional.get())
                {
                    String biomeString = biomeHolder.getRegisteredName();

                    rls.add(ResourceLocation.parse(biomeString));
                }
            }
        }

        for (ResourceLocation rl : fp.wr.biomesBlacklist)
        {
            Optional<Holder.Reference<Biome>> optional = level.registryAccess().lookupOrThrow(Registries.BIOME).get(ResourceKey.create(Registries.BIOME, rl));
            if (optional.isPresent()) if (!rls.contains(rl)) rls.add(rl);
        }

        return rls;
    }

    public static List<FishProperties> getFPs(Level level)
    {
        return getFPs(level.registryAccess());
    }

    public static List<FishProperties> getFPs(RegistryAccess registryAccess)
    {
        return registryAccess.registryOrThrow(Starcatcher.FISH_REGISTRY).stream().toList();
    }

    public static int getChance(FishProperties fp, Entity entity, ItemStack bait)
    {
        Level level = entity.level();

        //Serene Seasons check
        if (ModList.get().isLoaded("sereneseasons") && Config.ENABLE_SEASONS.get())
        {
            if (!SereneSeasonsCompat.canCatch(fp, level)) return 0;
        }

        //Ecliptic Seasons check
        if (ModList.get().isLoaded("eclipticseasons") && Config.ENABLE_SEASONS.get())
        {
            if (!EclipticSeasonsCompat.canCatch(fp, level)) return 0;
        }

        //TerraFirmaCraft Seasons check
        if (ModList.get().isLoaded("tfc") && Config.ENABLE_SEASONS.get())
        {
            if (!TerraFirmaCraftSeasonsCompat.canCatch(fp, level)) return 0;
        }

        //dimension  check
        if (!fp.wr.dims.isEmpty() && !fp.wr().dims().contains(level.dimension().location()))
            return 0;

        if (fp.wr.dimsBlacklist.contains(level.dimension().location()))
            return 0;

        //biome check
        List<ResourceLocation> biomes = getBiomesAsList(fp, level);
        List<ResourceLocation> blacklist = getBiomesBlacklistAsList(fp, level);
        ResourceLocation currentBiome = level.getBiome(entity.blockPosition()).getKey().location();

        if (!biomes.isEmpty() && !biomes.contains(currentBiome))
            return 0;

        if (!blacklist.isEmpty() && blacklist.contains(currentBiome))
            return 0;

        //fluid check
        boolean fluid = fp.wr.fluids.contains(BuiltInRegistries.FLUID.getKey(getSource(level.getFluidState(entity.blockPosition()).getType())));
        boolean fluidAbove = fp.wr.fluids.contains(BuiltInRegistries.FLUID.getKey(getSource(level.getFluidState(entity.blockPosition().above()).getType())));
        boolean fluidBelow = fp.wr.fluids.contains(BuiltInRegistries.FLUID.getKey(getSource(level.getFluidState(entity.blockPosition().below()).getType())));

        if (!fluid && !fluidAbove && !fluidBelow && entity instanceof FishingBobEntity)
            return 0;

        //y level check
        if (entity.position().y > fp.wr.mustBeCaughtBelowY())
        {
            return 0;
        }

        //y level check
        if (entity.position().y < fp.wr.mustBeCaughtAboveY())
        {
            return 0;
        }

        //time check
        if (fp.daytime() != Daytime.ALL)
        {
            long time = level.getDayTime() % 24000;

            switch (fp.daytime())
            {
                case Daytime.DAY:
                    if (time >= 12700 && time <= 23000) return 0;
                    break;

                case Daytime.NOON:
                    if (time <= 3500 || time >= 8500) return 0;
                    break;

                case Daytime.NIGHT:
                    if (time >= 23000 || time <= 12700) return 0;
                    break;

                case Daytime.MIDNIGHT:
                    if (time <= 16500 || time >= 19500) return 0;
                    break;
            }
        }

        if (!bait.is(ModItems.METEOROLOGICAL_BAIT))
        {
            //clear check
            if (fp.weather() == Weather.CLEAR && (level.getRainLevel(0) > 0.5 || level.getThunderLevel(0) > 0.5))
            {
                return 0;
            }

            //rain check
            if (fp.weather() == Weather.RAIN && level.getRainLevel(0) < 0.5)
            {
                return 0;
            }

            //thunder check
            if (fp.weather() == Weather.THUNDER && level.getThunderLevel(0) < 0.5)
            {
                return 0;
            }
        }

        //correct bait chance bonus
        if (fp.br().correctBait().contains(BuiltInRegistries.ITEM.getKey(bait.getItem())))
        {
            return fp.baseChance() + fp.br().correctBaitChanceAdded();
        }

        return fp.baseChance();
    }

    public static List<FishProperties> getFpsWithGuideEntryForArea(Entity entity)
    {
        List<FishProperties> list = new ArrayList<>();

        //todo make this also show entities that require a bait
        for (FishProperties fp : entity.level().registryAccess().registryOrThrow(Starcatcher.FISH_REGISTRY))
            if (getChance(fp, entity, new ItemStack(ModItems.ROD.get())) > 0 && fp.hasGuideEntry)
                list.add(fp);

        return list;
    }

    public static Fluid getSource(Fluid fluid1)
    {
        if (fluid1 instanceof FlowingFluid fluid)
        {
            return fluid.getSource();
        }

        return fluid1;
    }

    public static SizeAndWeight sw(float s, float s1, float w, float w1)
    {
        return new SizeAndWeight(s, s1, w, w1);
    }

    public static ResourceLocation rl(String ns, String path)
    {
        return ResourceLocation.fromNamespaceAndPath(ns, path);
    }

}
