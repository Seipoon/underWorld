/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underworld.save;

import java.util.HashMap;

/**
 *
 * @author Jeffrey Oh
 */
public class save {

    private int classType;
    private String name;
    private int storyPoint;

    private HashMap<String, Integer> saveValues;

    public save() {
        this.name = this.getName();
        classType = this.getClassType();

        saveValues = new HashMap<>();
    }

    public save(String n, int cType, int sp) {
        storyPoint = sp;
        name = n;
        classType = cType;

        saveValues.put(name, 0);
        saveValues.put(Integer.toString(classType), 1);
        saveValues.put(Integer.toString(storyPoint), 2);
    }

    public final int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoryPoint(int storyPoint) {
        this.storyPoint = storyPoint;
    }

    @Override
    public String toString() {
        return name + "///" + classType + "///" + storyPoint;
    }

}
