/*
 * Remove unused code! Trust the process.
 */
package underworld.creature;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jeffrey Oh
 */
public class Mob {

    Map<Integer, String> mobList = new HashMap<>();
    Map<String, Integer> hpArray = new HashMap<>();
    Map<String, Integer> atkArray = new HashMap<>();

    public Mob() {
        mobList.put(1, "Slime");
        mobList.put(2, "Goblin");
        mobList.put(3, "Kobold");
        mobList.put(4, "Null Pointer Exception");

        hpArray.put("Slime", 8);
        hpArray.put("Goblin", 15);
        hpArray.put("Kobold", 20);
        hpArray.put("Null Pointer Exception", 100);

        atkArray.put("Slime", 2);
        atkArray.put("Goblin", 4);
        atkArray.put("Kobold", 6);
        atkArray.put("Null Pointer Exception", 0);
    }

    public int getHp(String mobName) {
        return hpArray.get(mobName);
    }

    public int getAtk(String mobName) {
        return atkArray.get(mobName);
    }

}
