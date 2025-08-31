package org.sunburn.solitairegui;


import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.sunburn.solitairegui.solitaire.SolitaireGame;


public class SolitaireGUI {

    private SolitaireGame sg = new SolitaireGame();
    private wastePileGUI wastePile;
    private FundationPileGUI fundationPile;
    private ImageView cardBack;
    private AnchorPane root;
    private TableuGUI tableu;


    SolitaireGUI(AnchorPane root)
    {
        this.root = root;
        cardBack = new ImageView(new Image(getClass().getResource("cardBack.jpg").toExternalForm()));
        cardBack.setX(515);
        cardBack.setY(45);
        cardBack.setScaleX(0.75);
        cardBack.setScaleY(0.75);
        root.getChildren().add(cardBack);

        wastePile = new wastePileGUI(sg.getWastePile());
        fundationPile = new FundationPileGUI(sg.getFoundation());
        tableu = new TableuGUI(sg.getTableau(), this);

        actualizeTableu();

    }

    // regresa raiz para que las demas clases puedan acceder a este
    public AnchorPane getRoot()
    {
        return root;
    }

    // da a SolitaireGame para que controller pueda acceder a el y hacer cosas
    public  SolitaireGame getSolitaireGame()
    {
        return sg;
    }

    // voltea las cartas
    public ImageView getCardBack()
    {
        return cardBack;
    }

    // llama a actualizar WastePileGUI y limpia lo que habia antes
    public void actualizeWastePile()
    {
        wastePile.actualizeView(root);
        if(!sg.getWastePile().hayCartas())
        {
            Rectangle block = new Rectangle();
            block.setX(425);
            block.setY(45);
            block.setWidth(75);
            block.setHeight(100);
            block.setFill(Color.DARKGREEN);
            root.getChildren().add(block);
        }
    }

    // llama a actualizar la fundacion
    public void actualizeFundationPile()
    {
        fundationPile.actualizeView(root);
    }

    public void actualizeTableu()
    {
        tableu.actualizeView(root);
    }

    // revisa si el juego termino de SOlitaireGame, si es asi muestra la pantalla de ganar
    // pero no cierra la ventana para que puedas presumir si quieres :P
    public void checkGameEnd()
    {
        if(sg.isGameOver())
        {
            Alert alert = new  Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Solitaire");
            alert.setHeaderText("Felicitaciones");
            alert.setContentText("HAS GANADO!");

            alert.showAndWait();
        }
    }

}
