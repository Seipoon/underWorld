/*
 * Remove unused code! Trust the process.
 */
package underworld.floor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import underworld.creature.Mob;
import underworld.mainMenu.characterCreatorController;
import underworld.character.Character;
/**
 *
 * @author Jeffrey Oh
 */
public class stageOneController implements Initializable{
    @FXML private Button attackBtn;
    @FXML private Button abilityBtn;
    @FXML private Button quitBtn, nextBtn;
    @FXML private TextArea tArea;
    private final characterCreatorController ccc;
    
    private final underworld.character.Character chara;
    
    
    private final Mob mob = new Mob();
    private int mobHp = mob.getHp("Slime");
    private final int mobAtk = mob.getAtk("Slime");
    
    public stageOneController(){
//        chara = new Character();
        
        ccc = new characterCreatorController();
        chara = ccc.fetchChara();
    }
    
    private void playerToMobDmg(){
        int atk = chara.getAttr().get("Strength");
        mobHp -= atk;
    }
    
    public Character fetchChara(){
        return chara;
    }
    
    @FXML protected void handleAttackBtn(ActionEvent e) throws IOException, Exception{
        if(mobHp > 0){
            tArea.setText("You attacked the slime!");
            tArea.appendText(" You dealt " + chara.getAttr().get("Strength") + " damage!");
            playerToMobDmg();
        }
        
        if(mobHp == 0 || mobHp < 0){
            tArea.appendText(" You have slain the slime! You're cruel and definetly hate small animals...");
            nextBtn.setVisible(true);
            nextBtn.setOpacity(1);
            attackBtn.setDisable(true);
            abilityBtn.setDisable(true);
        }
    }
    
    @FXML protected void handleAbilityBtn(ActionEvent e) throws IOException, Exception{
        if(mobHp > 0){
            if(chara.getAttr().get("Class").equals(3)){
            tArea.setText("You used crippling strike!");
            tArea.appendText("You dealt " + (chara.getAttr().get("Strength") + 3) + " damage!");
            playerToMobDmg();
            }   
                if(mobHp == 0 || mobHp < 0){
                    tArea.appendText(" You have slain the slime! You're cruel and definetly hate small animals...");
                    nextBtn.setVisible(true);
                    nextBtn.setOpacity(1);
                    attackBtn.setDisable(true);
                    abilityBtn.setDisable(true);
                }
        }
    }
    
    @FXML protected void handleQuitBtn(ActionEvent e) throws IOException, Exception{
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }
    
    @FXML protected void handleNextBtn(ActionEvent e) throws IOException, Exception{
        underworldapp.UnderWorld.setActiveScene("savePointOneScene");
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tArea.setText("A slime has bounced up to you!");
        attackBtn.setDisable(false);
        abilityBtn.setDisable(false);
    }
    
}
