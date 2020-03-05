/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underworld.mainMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import underworld.save.save;
import underworld.character.Character;

/**
 *
 * @author Jeffrey Oh
 */
public class characterCreatorController {

    @FXML
    Button createBtn;
    @FXML
    TextField nameField;
    @FXML
    ToggleButton warriorBtn;
    @FXML
    ToggleButton mageBtn;
    @FXML
    ToggleButton thiefBtn;

    private save mainSave;
    public int classType;
    private final Character chara;

    public characterCreatorController() {
        chara = Character.getInstance();
    }

    public Character fetchChara() {
        return chara;
    }

    @FXML
    protected void handleCreateBtn(ActionEvent e) throws IOException, Exception {
        createSaveFile();
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }

    public String getCharacterName() {
        String cName = nameField.getText();
        return cName;
    }

    public save getMainSave() {
        return mainSave;
    }

    public void setClassType() {
        if (warriorBtn.isSelected()) {
            classType = 1;
        } else if (mageBtn.isSelected()) {
            classType = 2;
        } else if (thiefBtn.isSelected()) {
            classType = 3;
        }
        classType = 0;
    }

    public int getClassType() {

        if (warriorBtn.isSelected()) {
            return 1;
        } else if (mageBtn.isSelected()) {
            return 2;
        } else if (thiefBtn.isSelected()) {
            return 3;
        }
        return 0;
    }

    public void createSaveFile() throws Exception {
        mainSave = new save();
        mainSave.setClassType(getClassType());
        mainSave.setName(getCharacterName());
        mainSave.setStoryPoint(0);

        try {

            File file = new File("save.txt");
            String details = mainSave.toString();

            try (FileOutputStream saveFile = new FileOutputStream(file)) {
                if (file.exists()) {
                    file.createNewFile();
                }
                byte[] contents = details.getBytes();
                saveFile.write(contents);
            }

            try (FileReader reader = new FileReader("save.txt");
                    BufferedReader br = new BufferedReader(reader)) {

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] att = line.split(" ");
                    chara.setCharaName(att[0]);
                    chara.setCharaType(Integer.parseInt(att[1]));
                }

            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        resetSelections();
    }

    private void resetSelections() {
        nameField.setText("");
        warriorBtn.setSelected(false);
        mageBtn.setSelected(false);
        thiefBtn.setSelected(false);
    }

}
