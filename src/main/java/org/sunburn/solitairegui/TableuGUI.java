package org.sunburn.solitairegui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.sunburn.solitairegui.DeckOfCards.CartaInglesa;
import org.sunburn.solitairegui.solitaire.TableauDeck;

import java.util.ArrayList;

public class TableuGUI {

    ArrayList<TableauDeck> tableu;
    SolitaireGUI sgui;

    public TableuGUI(ArrayList<TableauDeck> tableu,SolitaireGUI sgui) {
        this.sgui=sgui;
        this.tableu = tableu;
    }

    // coloca las cartas, de izquierda a derecha, de arriba a abajo
    public void actualizeView(AnchorPane root)
    {
        clear(sgui.getRoot());

        for(int i = 0; i< tableu.size();i++)
        {
            TableauDeck td=tableu.get(i);

            ArrayList<CartaInglesa> cartas = td.getCards();
            for(int j = 0; j<cartas.size();j++)
            {
                GraficCard ct = new GraficCard(cartas.get(j));

                ct.setX((85*i));
                ct.setY(180+(64*j));
                ct.setScaleX(0.75);
                ct.setScaleY(0.75);

                root.getChildren().add(ct);
            }

        }

    }

    // crea un cuadrado para limpiar lo que habia antes.
    public void clear(AnchorPane root){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(1000);
        rectangle.setWidth(800);
        rectangle.setFill(Color.DARKGREEN);

        rectangle.setX(0);
        rectangle.setY(190);

        root.getChildren().add(rectangle);
    }




}
