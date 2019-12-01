package core.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import core.model.Player;
import core.model.SlotMachine;

import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;


public class GameController implements Initializable {

    private PlayerController playerController;

    private Player player;

    private SlotMachine slotMachine;

    @FXML
    private Label userName;

    @FXML
    private Label tokens;

    @FXML
    private Spinner<Integer> bets;

    @FXML
    private Label message;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSlotMachine(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
    }

    public void setBets(Spinner<Integer> bets) {
        this.bets = bets;
    }

    public void setMessage(Label message) {
        this.message = message;
    }

    public GameController(){
        this.setPlayerController(PlayerController.getInstance());
        this.setSlotMachine(SlotMachine.getInstance());
        this.setPlayer(new Player("Stanley", 10000));
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initBets();
        userName.setText(player.getName());
        tokens.setText(Integer.toString(player.getTokens()));
        message.setWrapText(true);
        setImages(slotMachine.getImages());
    }


    public void start() {

        try{
            int wager = bets.getValue();
            if(wager > player.getTokens()){
                message.setText("You don't have so much tokens");
            }
            else if(wager<1){
                message.setText("You must enter some tokens");
            }
            else{
                this.playerController.loseMoney(player, wager);
                int odds = slotMachine.spin();
                setImages( slotMachine.getImages());
                if (odds > 0){
                    int winning = wager*odds;
                    playerController.addMoney(player,winning);
                    tokens.setText(Integer.toString(player.getTokens()));
                    message.setText(String.format("You win %d tokens",winning));
                }
                else{
                    tokens.setText(Integer.toString(playerController.getMoney(player)));
                    message.setText(String.format("You lose"));
                }
            }

        }catch (Exception e){
            message.setText("you must enter valid numeric bets");
        }
    }

    public boolean isBankrupt(Player player) {
        return player.getTokens() <= 0;
    }

    private void initBets() {
        bets.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

    }

    public void updateBets(Integer wager) {
        bets.getValueFactory().setValue(wager);
    }

    private void setImages(ArrayList<Image> imageList){
        image1.setImage(imageList.get(0));
        image2.setImage(imageList.get(1));
        image3.setImage(imageList.get(2));
        image4.setImage(imageList.get(3));
        image5.setImage(imageList.get(4));
        image6.setImage(imageList.get(5));
        image7.setImage(imageList.get(6));
        image8.setImage(imageList.get(7));
        image9.setImage(imageList.get(8));
    }

}