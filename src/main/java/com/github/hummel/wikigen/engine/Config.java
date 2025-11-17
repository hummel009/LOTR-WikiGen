package com.github.hummel.wikigen.engine;

import com.github.hummel.wikigen.util.ReflectionHelper;
import lotr.common.entity.animal.*;
import lotr.common.entity.npc.*;
import lotr.common.world.structure.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.*;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class Config {
	public static final Map<Class<? extends Entity>, String> ENTITY_CLASS_TO_NAME = new HashMap<>();
	public static final Map<Class<?>, String> STRUCTURE_CLASS_TO_NAME = new HashMap<>();
	public static final Map<Class<?>, Set<String>> SETTLEMENT_CLASS_TO_NAMES = new HashMap<>();

	public static final String NAMESPACE_PREFIX = "";
	public static final String NAMESPACE_SUBPAGE = "";
	// NAMESPACE_PREFIX_EXAMPLE = "LOTR+:";
	// NAMESPACE_SUBPAGE_EXAMPLE = "/LOTR+";

	public static World world;

	/**
	 * Copy registry from LOTREntities and paste here.
	 * Remove all "registerEntity" lines.
	 * Replace all method names with "genEntityInfo".
	 */
	public static void getEntitiesInfo() {

	}

	/**
	 * Copy registry from LOTRStructures and paste here.
	 * Replace all method names with "genStructureInfo".
	 */
	public static void getStructuresInfo() {
	}

	private static void getEntityInfo(Class<? extends Entity> entityClass, String name, int id) {
		saveEntityInfo(entityClass, name);
	}

	private static void getEntityInfo(Class<? extends Entity> entityClass, String name, int id, int egg1, int egg2) {
		saveEntityInfo(entityClass, name);
	}

	private static void saveEntityInfo(Class<? extends Entity> entityClass, String name) {
		ENTITY_CLASS_TO_NAME.put(entityClass, name);
		WikiGenerator.ENTITY_CLASS_TO_ENTITY.put(entityClass, ReflectionHelper.newEntity(entityClass, world));
		WikiGenerator.ENTITY_CLASSES.add(entityClass);
	}

	private static void getStructureInfo(int i, Class<? extends WorldGenerator> clazz, String name, int egg1, int egg2) {
		saveStructureInfo(clazz, name);
	}

	private static void saveStructureInfo(Class<? extends WorldGenerator> clazz, String name) {
		STRUCTURE_CLASS_TO_NAME.put(clazz, name);
	}

	private static void genStructureInfo(int i, LOTRVillageGen clazz, String name, int j, int k, IVillageProperties<?> iVillageProperties) {
		saveStructureInfo(clazz, name);
	}

	private static void saveStructureInfo(LOTRVillageGen clazz, String name) {
		SETTLEMENT_CLASS_TO_NAMES.computeIfAbsent(clazz.getClass(), s -> new HashSet<>());
		SETTLEMENT_CLASS_TO_NAMES.get(clazz.getClass()).add(name);
	}

	private interface IVillageProperties<V> {
		void apply(V var1);
	}
}