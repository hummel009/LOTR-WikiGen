package com.github.hummel.wikigen.util;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRShields;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRUnitTradeEntry;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRank;
import lotr.common.world.biome.LOTRBiomeDecorator;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.biome.variant.LOTRBiomeVariantList;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import lotr.common.world.village.LOTRVillageGen;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReflectionHelper {
	private ReflectionHelper() {
	}

	public static LOTRFaction getAlignmentFaction(LOTRShields shield) {
		try {
			Field privateField = LOTRShields.class.getDeclaredField("alignmentFaction");
			privateField.setAccessible(true);
			return (LOTRFaction) privateField.get(shield);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getBaseWeight(LOTRBiomeSpawnList.FactionContainer container) {
		try {
			Field privateField = LOTRBiomeSpawnList.FactionContainer.class.getDeclaredField("baseWeight");
			privateField.setAccessible(true);
			return (int) privateField.get(container);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static List<Object> getBiomeGems(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("biomeGems");
			privateField.setAccessible(true);
			return (List<Object>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static List<Object> getBiomeOres(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("biomeOres");
			privateField.setAccessible(true);
			return (List<Object>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static List<Object> getBiomeSoils(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("biomeSoils");
			privateField.setAccessible(true);
			return (List<Object>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static float getDamageAmount(Item item) {
		try {
			Field privateField = getPotentiallyObfuscatedPrivateValue(ItemSword.class, "field_150934_a");
			privateField.setAccessible(true);
			return (float) privateField.get(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0f;
	}

	public static List<LOTRBiomeSpawnList.FactionContainer> getFactionContainers(LOTRBiomeSpawnList spawnlist) {
		try {
			Field privateField = LOTRBiomeSpawnList.class.getDeclaredField("factionContainers");
			privateField.setAccessible(true);
			return (List<LOTRBiomeSpawnList.FactionContainer>) privateField.get(spawnlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static int getInitialCost(LOTRUnitTradeEntry entry) {
		try {
			Field privateField = LOTRUnitTradeEntry.class.getDeclaredField("initialCost");
			privateField.setAccessible(true);
			return (int) privateField.get(entry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static LOTRAchievement getKillAchievement(LOTREntityNPC entity) {
		try {
			Method method = LOTREntityNPC.class.getDeclaredMethod("getKillAchievement");
			method.setAccessible(true);
			return (LOTRAchievement) method.invoke(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getMaxHeight(Object oreGenerant) {
		try {
			Field privateField = oreGenerant.getClass().getDeclaredField("maxHeight");
			privateField.setAccessible(true);
			return (int) privateField.get(oreGenerant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getMinHeight(Object oreGenerant) {
		try {
			Field privateField = oreGenerant.getClass().getDeclaredField("minHeight");
			privateField.setAccessible(true);
			return (int) privateField.get(oreGenerant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
		Collection<Object> list = new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.getType() == type) {
				Object fieldObj = null;
				try {
					fieldObj = field.get(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				list.add(fieldObj);
			}
		}
		return (List<T>) list;
	}

	public static float getOreChance(Object oreGenerant) {
		try {
			Field privateField = oreGenerant.getClass().getDeclaredField("oreChance");
			privateField.setAccessible(true);
			return (float) privateField.get(oreGenerant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0f;
	}

	public static WorldGenMinable getOreGen(Object oreGenerant) {
		try {
			Field privateField = oreGenerant.getClass().getDeclaredField("oreGen");
			privateField.setAccessible(true);
			return (WorldGenMinable) privateField.get(oreGenerant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Block getOreGenBlock(WorldGenMinable worldGenMinable) {
		try {
			Field privateField = getPotentiallyObfuscatedPrivateValue(WorldGenMinable.class, "field_150519_a");
			privateField.setAccessible(true);
			return (Block) privateField.get(worldGenMinable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getOreGenMeta(WorldGenMinable worldGenMinable) {
		try {
			Field privateField = getPotentiallyObfuscatedPrivateValue(WorldGenMinable.class, "mineableBlockMeta");
			privateField.setAccessible(true);
			return (int) privateField.get(worldGenMinable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static <T, E> T getPotentiallyObfuscatedPrivateValue(Class<? super E> classToAccess, String fieldName) {
		try {
			return cpw.mods.fml.relauncher.ReflectionHelper.getPrivateValue(classToAccess, null, ObfuscationReflectionHelper.remapFieldNames(classToAccess.getName(), fieldName));
		} catch (Exception e1) {
			try {
				return (T) classToAccess.getDeclaredField(fieldName);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public static List<LOTRFactionRank> getRanksSortedDescending(LOTRFaction fac) {
		try {
			Field privateField = LOTRFaction.class.getDeclaredField("ranksSortedDescending");
			privateField.setAccessible(true);
			return (List<LOTRFactionRank>) privateField.get(fac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static List<LOTRInvasions> getRegisteredInvasions(LOTRBiomeInvasionSpawns invasionSpawns) {
		try {
			Field privateField = LOTRBiomeInvasionSpawns.class.getDeclaredField("registeredInvasions");
			privateField.setAccessible(true);
			return (List<LOTRInvasions>) privateField.get(invasionSpawns);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static float getSpawnChance(LOTRVillageGen village) {
		try {
			Field privateField = LOTRVillageGen.class.getDeclaredField("spawnChance");
			privateField.setAccessible(true);
			return (float) privateField.get(village);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0f;
	}

	public static List<LOTRSpawnEntry> getSpawnEntries(LOTRSpawnList spawnList) {
		try {
			Field privateField = LOTRSpawnList.class.getDeclaredField("spawnList");
			privateField.setAccessible(true);
			return (List<LOTRSpawnEntry>) privateField.get(spawnList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static LOTRSpawnList getSpawnList(LOTRBiomeSpawnList.SpawnListContainer container) {
		try {
			Field privateField = LOTRBiomeSpawnList.SpawnListContainer.class.getDeclaredField("spawnList");
			privateField.setAccessible(true);
			return (LOTRSpawnList) privateField.get(container);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<LOTRBiomeSpawnList.SpawnListContainer> getSpawnListContainers(LOTRBiomeSpawnList.FactionContainer container) {
		try {
			Field privateField = LOTRBiomeSpawnList.FactionContainer.class.getDeclaredField("spawnLists");
			privateField.setAccessible(true);
			return (List<LOTRBiomeSpawnList.SpawnListContainer>) privateField.get(container);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static Object getStructureGen(Object randomStructure) {
		try {
			Field privateField = randomStructure.getClass().getDeclaredField("structureGen");
			privateField.setAccessible(true);
			return privateField.get(randomStructure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Object> getStructures(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("randomStructures");
			privateField.setAccessible(true);
			return (List<Object>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static Item.ToolMaterial getToolMaterial(Item item) {
		try {
			Field privateField = getPotentiallyObfuscatedPrivateValue(ItemSword.class, "field_150933_b");
			privateField.setAccessible(true);
			return (Item.ToolMaterial) privateField.get(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<LOTRTreeType.WeightedTreeType> getTreeTypes(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("treeTypes");
			privateField.setAccessible(true);
			return (List<LOTRTreeType.WeightedTreeType>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static LOTRBiomeVariant getVariant(Object variantBucket) {
		try {
			Field privateField = variantBucket.getClass().getDeclaredField("variant");
			privateField.setAccessible(true);
			return (LOTRBiomeVariant) privateField.get(variantBucket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Object> getVariantList(LOTRBiomeVariantList biomeVariantList) {
		try {
			Field privateField = LOTRBiomeVariantList.class.getDeclaredField("variantList");
			privateField.setAccessible(true);
			return (List<Object>) privateField.get(biomeVariantList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static List<LOTRVillageGen> getVillages(LOTRBiomeDecorator decorator) {
		try {
			Field privateField = LOTRBiomeDecorator.class.getDeclaredField("villages");
			privateField.setAccessible(true);
			return (List<LOTRVillageGen>) privateField.get(decorator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static boolean isSpawnsInDarkness(LOTREntityNPC entity) {
		try {
			Field privateField = LOTREntityNPC.class.getDeclaredField("spawnsInDarkness");
			privateField.setAccessible(true);
			return (boolean) privateField.get(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isTargetSeeker(LOTREntityNPC entity) {
		try {
			Field privateField = LOTREntityNPC.class.getDeclaredField("isTargetSeeker");
			privateField.setAccessible(true);
			return (boolean) privateField.get(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Entity newEntity(Class<? extends Entity> entityClass, World world) {
		try {
			Class<?>[] param = new Class[]{World.class};
			return entityClass.getDeclaredConstructor(param).newInstance(world);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}