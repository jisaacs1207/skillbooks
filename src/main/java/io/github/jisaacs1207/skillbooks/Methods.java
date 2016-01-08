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
	
	public static void populateMapFromPFile(String playerName){
		File playerfile = new File(SkillBooks.plugin.getDataFolder()+"/players/"+playerName);
		YamlConfiguration playerfileyaml = YamlConfiguration.loadConfiguration(playerfile);
		PlayerConfig pConfig = new PlayerConfig();
		
		// ugly, I know, I should use a for but can't be assed at the moment
		pConfig.viplevel=playerfileyaml.getInt("vip.level");
		pConfig.vipteacher=playerfileyaml.getInt("vip.teacher");
		pConfig.skillpointscap=playerfileyaml.getInt("skillpoints.cap");
		pConfig.skillpointscurrent=playerfileyaml.getInt("skillpoints.current");
		pConfig.crafting=playerfileyaml.getInt("reading");
		pConfig.taming=playerfileyaml.getInt("readingbegan");
		pConfig.stabling=playerfileyaml.getInt("skills.primary.crafting.crafting");
		pConfig.creaturecontrol=playerfileyaml.getInt("skills.primary.crafting.taming");
		pConfig.skinning=playerfileyaml.getInt("skills.primary.crafting.stabling");
		pConfig.weaponcrafting=playerfileyaml.getInt("skills.primary.crafting.creaturecontrol");
		pConfig.legendaryweaponcrafting=playerfileyaml.getInt("skills.primary.crafting.skinning");
		pConfig.armorcrafting=playerfileyaml.getInt("skills.primary.crafting.weaponcrafting");
		pConfig.legendaryarmorcrafting=playerfileyaml.getInt("skills.primary.crafting.legendaryweaponcrafting");
		pConfig.alchemy=playerfileyaml.getInt("skills.primary.crafting.armorcrafting");
		pConfig.transmutation=playerfileyaml.getInt("skills.primary.crafting.legendaryarmorcrafting");
		pConfig.bowcrafting=playerfileyaml.getInt("skills.primary.crafting.alchemy");
		pConfig.legendarybowcrafting=playerfileyaml.getInt("skills.primary.crafting.transmutation");
		pConfig.fletching=playerfileyaml.getInt("skills.primary.crafting.bowcrafting");
		pConfig.engineering=playerfileyaml.getInt("skills.primary.crafting.legendarybowcrafting");
		pConfig.tinkering=playerfileyaml.getInt("skills.primary.crafting.fletching");
		pConfig.amateurwriting=playerfileyaml.getInt("skills.primary.crafting.engineering");
		pConfig.originalwriting=playerfileyaml.getInt("skills.primary.crafting.tinkering");
		pConfig.authorship=playerfileyaml.getInt("skills.primary.crafting.amateurwriting");
		pConfig.botany=playerfileyaml.getInt("skills.primary.crafting.originalwriting");
		pConfig.herbalism=playerfileyaml.getInt("skills.primary.crafting.authorship");
		pConfig.dendrology=playerfileyaml.getInt("skills.primary.botany.botany");
		pConfig.defense=playerfileyaml.getInt("skills.primary.botany.herbalism");
		pConfig.defensivestance=playerfileyaml.getInt("skills.primary.botany.dendrology");
		pConfig.shield=playerfileyaml.getInt("skills.primary.defense.defense");
		pConfig.shieldwall=playerfileyaml.getInt("skills.primary.defense.defensivestance");
		pConfig.twohandeddefense=playerfileyaml.getInt("skills.primary.defense.shield");
		pConfig.twohandedcleave=playerfileyaml.getInt("skills.primary.defense.shieldwall");
		pConfig.parry=playerfileyaml.getInt("skills.primary.defense.twohandeddefense");
		pConfig.dodge=playerfileyaml.getInt("skills.primary.defense.twohandedcleave");
		pConfig.riposte=playerfileyaml.getInt("skills.primary.defense.parry");
		pConfig.weapons=playerfileyaml.getInt("skills.primary.defense.dodge");
		pConfig.twohanded=playerfileyaml.getInt("skills.primary.defense.riposte");
		pConfig.brawling=playerfileyaml.getInt("skills.primary.defense.weapons");
		pConfig.shieldfighting=playerfileyaml.getInt("skills.primary.weapons.twohanded");
		pConfig.archery=playerfileyaml.getInt("skills.primary.defense.brawling");
		pConfig.onehanded=playerfileyaml.getInt("skills.primary.defense.shieldfighting");
		pConfig.movement=playerfileyaml.getInt("skills.primary.defense.archery");
		pConfig.athletics=playerfileyaml.getInt("skills.primary.defense.onehanded");
		pConfig.riding=playerfileyaml.getInt("skills.primary.movement.movement");
		pConfig.damageavoidance=playerfileyaml.getInt("skills.primary.movement.athletics");
		pConfig.endurance=playerfileyaml.getInt("skills.primary.movement.riding");
		pConfig.passiveregeneration=playerfileyaml.getInt("skills.primary.movement.damageavoidance");
		pConfig.balance=playerfileyaml.getInt("skills.primary.movement.endurance");
		pConfig.zoology=playerfileyaml.getInt("skills.primary.movement.passiveregeneration");
		pConfig.mimicry=playerfileyaml.getInt("skills.primary.movement.balance");
		pConfig.disguise=playerfileyaml.getInt("skills.primary.zoology.zoology");
		pConfig.animalcall=playerfileyaml.getInt("skills.primary.zoology.mimicry");
		pConfig.terrestria=playerfileyaml.getInt("skills.primary.zoology.disguise");
		pConfig.etheria=playerfileyaml.getInt("skills.primary.zoology.animalcall");
		pConfig.spiraria=playerfileyaml.getInt("skills.primary.zoology.terrestria");
		pConfig.beginnerwriting=playerfileyaml.getInt("skills.primary.zoology.etheria");
		pConfig.intermediarywriting=playerfileyaml.getInt("skills.primary.zoology.spiraria");
		pConfig.advancedwriting=playerfileyaml.getInt("skills.secondary.crafting.beginnerwriting");
		pConfig.mounting=playerfileyaml.getInt("skills.secondary.crafting.intermediarywriting");
		pConfig.creaturecommands=playerfileyaml.getInt("skills.secondary.crafting.advancedwriting");
		pConfig.improvedweaponcrafting=playerfileyaml.getInt("skills.secondary.crafting.mounting");
		pConfig.advancedweaponcrafting=playerfileyaml.getInt("skills.secondary.crafting.creaturecommands");
		pConfig.improvedarmorcrafting=playerfileyaml.getInt("skills.secondary.crafting.improvedweaponcrafting");
		pConfig.advancedarmorcrafting=playerfileyaml.getInt("skills.secondary.crafting.advancedweaponcrafting");
		pConfig.improvedalchemy=playerfileyaml.getInt("skills.secondary.crafting.improvedarmorcrafting");
		pConfig.advancedalchemy=playerfileyaml.getInt("skills.secondary.crafting.advancedarmorcrafting");
		pConfig.improvedbowcrafting=playerfileyaml.getInt("skills.secondary.crafting.improvedalchemy");
		pConfig.advancedbowcrafting=playerfileyaml.getInt("skills.secondary.crafting.advancedalchemy");
		pConfig.deconstruct=playerfileyaml.getInt("skills.secondary.crafting.improvedbowcrafting");
		pConfig.mycology=playerfileyaml.getInt("skills.secondary.crafting.advancedbowcrafting");
		pConfig.redmushroom=playerfileyaml.getInt("skills.secondary.crafting.deconstruct");
		pConfig.brownmushroom=playerfileyaml.getInt("skills.secondary.botany.mycology");
		pConfig.mooshroom=playerfileyaml.getInt("skills.secondary.botany.redmushroom");
		pConfig.greenery=playerfileyaml.getInt("skills.secondary.botany.brownmushroom");
		pConfig.reading=playerfileyaml.getInt("skills.secondary.botany.mooshroom");
		pConfig.readingbegan=playerfileyaml.getInt("skills.secondary.botany.greenery");
		pConfig.flower=playerfileyaml.getInt("skills.secondary.botany.flower");
		pConfig.vegetable=playerfileyaml.getInt("skills.secondary.botany.vegetable");
		pConfig.fruit=playerfileyaml.getInt("skills.secondary.botany.fruit");
		pConfig.melon=playerfileyaml.getInt("skills.secondary.botany.melon");
		pConfig.oak=playerfileyaml.getInt("skills.secondary.botany.oak");
		pConfig.spruce=playerfileyaml.getInt("skills.secondary.botany.spruce");
		pConfig.birch=playerfileyaml.getInt("skills.secondary.botany.birch");
		pConfig.jungle=playerfileyaml.getInt("skills.secondary.botany.jungle");
		pConfig.acacia=playerfileyaml.getInt("skills.secondary.botany.acacia");
		pConfig.shieldblock=playerfileyaml.getInt("skills.secondary.defense.shieldblock");
		pConfig.shieldbash=playerfileyaml.getInt("skills.secondary.defense.shieldbash");
		pConfig.twohandedblock=playerfileyaml.getInt("skills.secondary.defense.twohandedblock");
		pConfig.offhandparry=playerfileyaml.getInt("skills.secondary.defense.offhandparry");
		pConfig.sidestep=playerfileyaml.getInt("skills.secondary.defense.sidestep");
		pConfig.diamond=playerfileyaml.getInt("skills.secondary.weapons.diamond");
		pConfig.iron=playerfileyaml.getInt("skills.secondary.weapons.iron");
		pConfig.gold=playerfileyaml.getInt("skills.secondary.weapons.gold");
		pConfig.stone=playerfileyaml.getInt("skills.secondary.weapons.stone");
		pConfig.wood=playerfileyaml.getInt("skills.secondary.weapons.wood");
		pConfig.sword=playerfileyaml.getInt("skills.secondary.weapons.sword");
		pConfig.axe=playerfileyaml.getInt("skills.secondary.weapons.axe");
		pConfig.hoe=playerfileyaml.getInt("skills.secondary.weapons.hoe");
		pConfig.pickaxe=playerfileyaml.getInt("skills.secondary.weapons.pickaxe");
		pConfig.shovel=playerfileyaml.getInt("skills.secondary.weapons.shovel");
		pConfig.fists=playerfileyaml.getInt("skills.secondary.weapons.fists");
		pConfig.mountedspeed=playerfileyaml.getInt("skills.secondary.movement.mountedspeed");
		pConfig.mountedfighting=playerfileyaml.getInt("skills.secondary.movement.mountedfighting");
		pConfig.mountedarchery=playerfileyaml.getInt("skills.secondary.movement.mountedarchery");
		pConfig.foodspeed=playerfileyaml.getInt("skills.secondary.movement.foodspeed");
		pConfig.breathingtechniques=playerfileyaml.getInt("skills.secondary.movement.breathingtechniques");
		pConfig.jumping=playerfileyaml.getInt("skills.secondary.movement.jumping");
		pConfig.swimming=playerfileyaml.getInt("skills.secondary.movement.swimming");
		pConfig.landingcontrol=playerfileyaml.getInt("skills.secondary.movement.landingcontrol");
		pConfig.thickskin=playerfileyaml.getInt("skills.secondary.movement.thickskin");
		pConfig.activeregeneration=playerfileyaml.getInt("skills.secondary.movement.activeregeneration");
		pConfig.livestock=playerfileyaml.getInt("skills.secondary.zoology.livestock");
		pConfig.ocean=playerfileyaml.getInt("skills.secondary.zoology.ocean");
		pConfig.arachnid=playerfileyaml.getInt("skills.secondary.zoology.arachnid");
		pConfig.canine=playerfileyaml.getInt("skills.secondary.zoology.canine");
		pConfig.feline=playerfileyaml.getInt("skills.secondary.zoology.feline");
		pConfig.humanoid=playerfileyaml.getInt("skills.secondary.zoology.humanoid");
		pConfig.undead=playerfileyaml.getInt("skills.secondary.zoology.undead");
		pConfig.dragon=playerfileyaml.getInt("skills.secondary.zoology.dragon");
		pConfig.construct=playerfileyaml.getInt("skills.secondary.zoology.construct");
		pConfig.elemental=playerfileyaml.getInt("skills.secondary.zoology.elemental");
		
		SkillBooks.playerStats.put(playerName, pConfig);
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
