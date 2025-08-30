package org.sunburn.solitairegui;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.sunburn.solitairegui.solitaire.WastePile;
import org.sunburn.solitairegui.DeckOfCards.CartaInglesa;


public class wastePileGUI {
    GraficCard tope;
    WastePile pila;


    public wastePileGUI(WastePile pila)
    {
        this.pila = pila;
    }

    public void actualizeView(AnchorPane root)
    {
        CartaInglesa carta = pila.verCarta();
        if(carta != null) {
            tope = new GraficCard(carta);

            tope.setX(425);
            tope.setY(45);
            tope.setScaleX(0.75);
            tope.setScaleY(0.75);
            root.getChildren().add(tope);
        } else {
            root.getChildren().remove(tope);
        }
    }

    public GraficCard getTope()
    {
        return tope;
    }





}
