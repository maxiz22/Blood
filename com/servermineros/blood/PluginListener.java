package com.servermineros.blood;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PluginListener implements Listener{



	@EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
	public void onDamage(EntityDamageByEntityEvent event){
		if(event.getDamager().getType() == EntityType.ARROW && event.getDamager().getVelocity().length() >= 2) {
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.STEP_SOUND, 55);
		/*event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16428);
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16421);
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16425);*/
		}
		if((event.getDamager() instanceof Player)) {
		Player p = ((Player) event.getDamager());
		Entity victim = event.getEntity();
		if(event.getDamage() > 3) {
		p.playSound(p.getLocation(), Sound.HURT_FLESH, 200, 200);
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.STEP_SOUND, getBloodType(victim.getType()));
		/*event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16428);
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16421);
		event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.POTION_BREAK, 16425);*/
		}
		}
	}
	private int getBloodType(EntityType type){
		switch(type){
			case PLAYER: case SKELETON: case ZOMBIE: case VILLAGER: case COW: case SHEEP: case PIG: case WITCH: case CHICKEN: case BAT:
				return 55;
			case ENDERMAN:
				return 49;
			case CREEPER:
				return 133;
			case BLAZE:
				return 41;
			case GHAST:
				return 42;
			case MUSHROOM_COW:
				return 99;
			default:
				return 55;
		}
	}
}
