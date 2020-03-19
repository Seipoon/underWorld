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
import javafx.scene.text.Text;
import underworld.creature.Mob;
import underworld.mainMenu.characterCreatorController;
import underworld.character.Character;

/**
 *
 * @author Jeffrey Oh
 */
public class stageThreeController implements Initializable {

    @FXML
    private Button attackBtn, quitBtn, nextBtn, abilityBtn;
    @FXML
    private TextArea tArea;
    @FXML
    private Text mobHpText, playerHpText;
    
    private final characterCreatorController ccc;
    private int currentHp;
    private final underworld.character.Character chara;
    
    private final Mob mob = new Mob();
    private int mobHp = mob.getHp("Kobold");
    private final int mobAtk = mob.getAtk("Kobold");

    public stageThreeController() {
        playerHpText = new Text();
        mobHpText = new Text();
        currentHp = 20;
        playerHpText.setText(Integer.toString(currentHp));
        mobHpText.setText(Integer.toString(mobHp));
        
        ccc = new characterCreatorController();
        chara = ccc.fetchChara();
    }

    private void playerToMobDmg() {
        final int atk = chara.getAttr().get("Strength");
        mobHp -= atk;
        mobHpText.setText(Integer.toString(mobHp));
    }
    
    private void playerToMobAbilityDmg(String statType, int dmgBoost){
        final int atk = chara.getAttr().get(statType);
        mobHp -= (atk + dmgBoost);
        mobHpText.setText(Integer.toString(mobHp));
    }

    public Character fetchChara() {
        return chara;
    }
    
    private void setCurrentHp(){
        chara.getAttr().put("Health", currentHp);
        playerHpText.setText(Integer.toString(currentHp));
    }
    
    private void mobToPlayerDmg(){
        tArea.appendText("\nThe Kobold slashes at you! It dealt " + mobAtk + " damage!");
        currentHp -= mobAtk;
    }
    
    private boolean checkIfMobDead(){
        if (mobHp == 0 || mobHp < 0) {
            tArea.appendText("\nYou have slain the Kobold!\nYou smell treasures!");
            nextBtn.setVisible(true);
            nextBtn.setOpacity(1);
            attackBtn.setDisable(true);
            abilityBtn.setDisable(true);
            return true;
        }
        else return false;
    }

    @FXML
    protected void handleAttackBtn(final ActionEvent e) throws IOException, Exception {
        if (mobHp > 0) {
            tArea.setText("You attacked the Kobold!");
            tArea.appendText(" You dealt " + chara.getAttr().get("Strength") + " damage!");
            playerToMobDmg();
            if(checkIfMobDead()){
            
            }
            else{
                mobToPlayerDmg();
                setCurrentHp();
            }
        }  
    }

    @FXML
    protected void handleAbilityBtn(final ActionEvent e) throws IOException, Exception {
        if (mobHp > 0) {
            if (chara.getAttr().get("Class").equals(1)) {
                tArea.setText("You used crippling strike! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Strength") + 3) + " damage!");
                playerToMobAbilityDmg("Strength",3);
                if(checkIfMobDead()){
            
                }
                else{
                    mobToPlayerDmg();
                    setCurrentHp();
                }
            }
            
            if (chara.getAttr().get("Class").equals(2)) {
                tArea.setText("You used fireball! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Intelligence") + 3) + " damage!");
                playerToMobAbilityDmg("Intelligence",3);
                if(checkIfMobDead()){
            
                }
                else{
                    mobToPlayerDmg();
                    setCurrentHp();
                }
            }
            
            if (chara.getAttr().get("Class").equals(3)) {
                tArea.setText("You used backstab! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Dexterity") + 3) + " damage!");
                playerToMobAbilityDmg("Dexterity",3);
                if(checkIfMobDead()){
            
                }
                else{
                    mobToPlayerDmg();
                    setCurrentHp();
                }
            }
        }
    }

    @FXML
    protected void handleQuitBtn(final ActionEvent e) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("mmScene");
        resetAllFields();
    }

    @FXML
    protected void handleNextBtn(final ActionEvent e) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("savePointThreeScene");
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        playerHpText.setText(Integer.toString(currentHp));
        mobHpText.setText(Integer.toString(mobHp));
        tArea.setText("A Kobold approaches you!");
        attackBtn.setDisable(false);
        abilityBtn.setDisable(false);
    }
    
    private void resetAllFields(){
        playerHpText.setText("20");
        mobHpText.setText(Integer.toString(mob.getHp("Kobold")));
        tArea.setText("A Kobold approaches you!");
        mobHp = mob.getHp("Kobold");
        currentHp = 20;
    }

}
