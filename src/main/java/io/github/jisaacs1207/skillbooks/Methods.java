package io.github.jisaacs1207.skillbooks;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class Methods implements Listener{

	public static int getSkillPoints(String playerName) {
		File playerfile = new File(SkillBooks.plugin.getDataFolder()+"/players/"+playerName);
		YamlConfiguration playerfileyaml = YamlConfiguration.loadConfiguration(playerfile);
		int skillPoints = 0;
		for(String key : playerfileyaml.getConfigurationSection("skills.primary").getKeys(true)){
			int keyValue = playerfileyaml.getInt("skills.primary."+key);
			skillPoints = keyValue+skillPoints;
		}
		return skillPoints;
	}
	
	public static void generateNewPlayerFile(String playerName){
		
		String player = playerName;
		File playerfile = new File(SkillBooks.plugin.getDataFolder()+"/players/"+player);
		YamlConfiguration playerfileyaml = YamlConfiguration.loadConfiguration(playerfile);
		
		// vip
		playerfileyaml.set("vip.level", 0);
		playerfileyaml.set("vip.teacher", 0);
		
		// skillpoints
		playerfileyaml.set("skillpoints.cap",1200);
		playerfileyaml.set("skillpoints.current",0);
		playerfileyaml.set("reading", 0);
		playerfileyaml.set("readingbegan", 0);
		
		// primary crafting
		playerfileyaml.set("skills.primary.crafting.crafting", 0);                  //1
		playerfileyaml.set("skills.primary.crafting.taming", 0);                    //2
		playerfileyaml.set("skills.primary.crafting.stabling", 0);                  //3
		playerfileyaml.set("skills.primary.crafting.creaturecontrol", 0);           //4
		playerfileyaml.set("skills.primary.crafting.skinning", 0);                  //5
		playerfileyaml.set("skills.primary.crafting.weaponcrafting", 0);            //6
		playerfileyaml.set("skills.primary.crafting.legendaryweaponcrafting", 0);   //7
		playerfileyaml.set("skills.primary.crafting.armorcrafting", 0);             //8
		playerfileyaml.set("skills.primary.crafting.legendaryweaponcrafting", 0);   //9
		playerfileyaml.set("skills.primary.crafting.alchemy", 0);                   //10
		playerfileyaml.set("skills.primary.crafting.transmutation", 0);             //11
		playerfileyaml.set("skills.primary.crafting.bowcrafting", 0);               //12
		playerfileyaml.set("skills.primary.crafting.legendarybowcrafting", 0);      //13
		playerfileyaml.set("skills.primary.crafting.fletching", 0);                 //14
		playerfileyaml.set("skills.primary.crafting.engineering", 0);               //15
		playerfileyaml.set("skills.primary.crafting.tinkering", 0);                 //16
		playerfileyaml.set("skills.primary.crafting.amateurwriting", 0);            //17
		playerfileyaml.set("skills.primary.crafting.originalwriting", 0);           //18
		playerfileyaml.set("skills.primary.crafting.authorship", 0);                //19
		
        // primary botany
		
		playerfileyaml.set("skills.primary.botany.botany", 0);                      //20
		playerfileyaml.set("skills.primary.botany.herbalism", 0);                   //21
		playerfileyaml.set("skills.primary.botany.dendrology", 0);                  //22
		
		// primary defense
		
		playerfileyaml.set("skills.primary.defense.defense", 0);                    //23
		playerfileyaml.set("skills.primary.defense.defensivestance", 0);            //24
		playerfileyaml.set("skills.primary.defense.shield", 0);                     //25
		playerfileyaml.set("skills.primary.defense.shieldwall", 0);                 //26
		playerfileyaml.set("skills.primary.defense.twohandeddefense", 0);           //27
		playerfileyaml.set("skills.primary.defense.twohandedcleave", 0);            //28
		playerfileyaml.set("skills.primary.defense.parry", 0);                      //29
		playerfileyaml.set("skills.primary.defense.dodge", 0);                      //30
		playerfileyaml.set("skills.primary.defense.riposte", 0);                    //31
		
		// primary weapons
		
		playerfileyaml.set("skills.primary.defense.weapons", 0);                    //32
		playerfileyaml.set("skills.primary.weapons.twohanded", 0);                  //33
		playerfileyaml.set("skills.primary.defense.brawling", 0);                   //34
		playerfileyaml.set("skills.primary.defense.shieldfighting", 0);             //35
		playerfileyaml.set("skills.primary.defense.archery", 0);                    //36
		playerfileyaml.set("skills.primary.defense.onehanded", 0);                  //37
		
		// primary movement
		
		playerfileyaml.set("skills.primary.movement.movement", 0);                  //38
		playerfileyaml.set("skills.primary.movement.athletics", 0);                 //39
		playerfileyaml.set("skills.primary.movement.riding", 0);                    //40
		playerfileyaml.set("skills.primary.movement.damageavoidance", 0);           //41
		playerfileyaml.set("skills.primary.movement.endurance", 0);                 //42
		playerfileyaml.set("skills.primary.movement.passiveregeneration", 0);       //43
		playerfileyaml.set("skills.primary.movement.balance", 0);                   //44
		
		// primary zoology
		
		playerfileyaml.set("skills.primary.zoology.zoology", 0);                    //45
		playerfileyaml.set("skills.primary.zoology.mimicry", 0);                    //46
		playerfileyaml.set("skills.primary.zoology.disguise", 0);                  
		playerfileyaml.set("skills.primary.zoology.animalcall", 0);                 
		playerfileyaml.set("skills.primary.zoology.terrestria", 0);                 
		playerfileyaml.set("skills.primary.zoology.etheria", 0);                 
		playerfileyaml.set("skills.primary.zoology.spiraria", 0);

		// secondary crafting
		
		playerfileyaml.set("skills.secondary.crafting.beginnerwriting", 0);
		playerfileyaml.set("skills.secondary.crafting.intermediarywriting", 0);
		playerfileyaml.set("skills.secondary.crafting.advancedwriting", 0);
		playerfileyaml.set("skills.secondary.crafting.mounting", 0);
		playerfileyaml.set("skills.secondary.crafting.creaturecommands", 0);
		playerfileyaml.set("skills.secondary.crafting.improvedweaponcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.advancedweaponcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.improvedarmorcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.advancedarmorcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.improvedalchemy", 0);
		playerfileyaml.set("skills.secondary.crafting.advancedalchemy", 0);
		playerfileyaml.set("skills.secondary.crafting.improvedbowcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.advancedbowcrafting", 0);
		playerfileyaml.set("skills.secondary.crafting.deconstruct", 0);
		
		// secondary botany
		
		playerfileyaml.set("skills.secondary.botany.mycology", 0);
		playerfileyaml.set("skills.secondary.botany.redmushroom", 0);
		playerfileyaml.set("skills.secondary.botany.brownmushroom", 0);
		playerfileyaml.set("skills.secondary.botany.mooshroom", 0);
		playerfileyaml.set("skills.secondary.botany.greenery", 0);
		playerfileyaml.set("skills.secondary.botany.flower", 0);
		playerfileyaml.set("skills.secondary.botany.vegetable", 0);
		playerfileyaml.set("skills.secondary.botany.fruit", 0);
		playerfileyaml.set("skills.secondary.botany.melon", 0);
		playerfileyaml.set("skills.secondary.botany.oak", 0);
		playerfileyaml.set("skills.secondary.botany.spruce", 0);
		playerfileyaml.set("skills.secondary.botany.birch", 0);
		playerfileyaml.set("skills.secondary.botany.jungle", 0);
		playerfileyaml.set("skills.secondary.botany.acacia", 0);
		
		// secondary defense
		
		playerfileyaml.set("skills.secondary.defense.shieldblock", 0);
		playerfileyaml.set("skills.secondary.defense.shieldbash", 0);
		playerfileyaml.set("skills.secondary.defense.twohandedblock", 0);
		playerfileyaml.set("skills.secondary.defense.offhandparry", 0);
		playerfileyaml.set("skills.secondary.defense.sidestep", 0);
		
		// secondary weapons
		
		playerfileyaml.set("skills.secondary.weapons.diamond", 0);
		playerfileyaml.set("skills.secondary.weapons.iron", 0);
		playerfileyaml.set("skills.secondary.weapons.gold", 0);
		playerfileyaml.set("skills.secondary.weapons.stone", 0);
		playerfileyaml.set("skills.secondary.weapons.wood", 0);
		playerfileyaml.set("skills.secondary.weapons.sword", 0);
		playerfileyaml.set("skills.secondary.weapons.axe", 0);
		playerfileyaml.set("skills.secondary.weapons.hoe", 0);
		playerfileyaml.set("skills.secondary.weapons.pickaxe", 0);
		playerfileyaml.set("skills.secondary.weapons.shovel", 0);
		playerfileyaml.set("skills.secondary.weapons.fists", 0);
		
		// secondary movement
		
		playerfileyaml.set("skills.secondary.movement.mountedspeed", 0);
		playerfileyaml.set("skills.secondary.movement.mountedfighting", 0);
		playerfileyaml.set("skills.secondary.movement.mountedarchery", 0);
		playerfileyaml.set("skills.secondary.movement.foodspeed", 0);
		playerfileyaml.set("skills.secondary.movement.breathingtechniques", 0);
		playerfileyaml.set("skills.secondary.movement.jumping", 0);
		playerfileyaml.set("skills.secondary.movement.swimming", 0);
		playerfileyaml.set("skills.secondary.movement.landingcontrol", 0);
		playerfileyaml.set("skills.secondary.movement.thickskin", 0);
		playerfileyaml.set("skills.secondary.movement.activeregeneration", 0);
		
		// secondary zoology
		
		playerfileyaml.set("skills.secondary.zoology.livestock", 0);
		playerfileyaml.set("skills.secondary.zoology.ocean", 0);
		playerfileyaml.set("skills.secondary.zoology.arachnid", 0);
		playerfileyaml.set("skills.secondary.zoology.canine", 0);
		playerfileyaml.set("skills.secondary.zoology.feline", 0);
		playerfileyaml.set("skills.secondary.zoology.humanoid", 0);
		playerfileyaml.set("skills.secondary.zoology.undead", 0);
		playerfileyaml.set("skills.secondary.zoology.dragon", 0);
		playerfileyaml.set("skills.secondary.zoology.construct", 0);
		playerfileyaml.set("skills.secondary.zoology.elemental", 0);
		
		try {
			  playerfileyaml.save(playerfile);
			} catch(IOException e) {
			  e.printStackTrace();
			}
	}
}
