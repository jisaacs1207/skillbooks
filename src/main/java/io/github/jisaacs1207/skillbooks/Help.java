package io.github.jisaacs1207.skillbooks;

import org.bukkit.event.Listener;
import java.util.*;

// All help entries break line at '%'

public class Help implements Listener {
    // create hash map
    public static HashMap<String, String> helpHash = new HashMap<>();

    static {
        helpHash.put("skillbooks", "Skillbooks allows players to find, buy,%" +
                "or teach skillbooks to engage in learning%" +
                "of skills, spells, and abilities. This%" +
                "type of learning is based on time both%" +
                "offline and online. Offline learning%" +
                "allows those that cannot play often an%" +
                "even chance against those who can.");

        helpHash.put("admin", "[A] Admin commands are restricted to staff and%" +
                "provide methods to help provide solutions%" +
                "to common problems in gameplay. Staff are%" +
                "not to abuse the commands.");

    }
}
