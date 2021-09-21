package net.mcreator.temporium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.temporium.particle.EtoileFilanteParticle;
import net.mcreator.temporium.TemporiumMod;

import java.util.Map;
import java.util.HashMap;

public class ApparitionEtoilesFilantesProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TemporiumMod.LOGGER.warn("Failed to load dependency entity for procedure ApparitionEtoilesFilantes!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TemporiumMod.LOGGER.warn("Failed to load dependency world for procedure ApparitionEtoilesFilantes!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.0083)) {
			world.addParticle(EtoileFilanteParticle.particle, ((entity.getPosX()) + ((Math.random() * 30) - 15)), ((entity.getPosY()) + 50),
					((entity.getPosZ()) + ((Math.random() * 30) - 15)), ((Math.random() * 2) - 1), (-0.002), ((Math.random() * 2) - 1));
		}
	}
}
