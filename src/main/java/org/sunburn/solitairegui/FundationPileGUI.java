package org.sunburn.solitairegui;
import javafx.scene.layout.AnchorPane;
import org.sunburn.solitairegui.DeckOfCards.CartaInglesa;
import org.sunburn.solitairegui.DeckOfCards.Palo;
import org.sunburn.solitairegui.solitaire.FoundationDeck;

import java.util.ArrayList;

public class FundationPileGUI {

    ArrayList<FoundationDeck> fundacion;
    GraficCard carta1;
    GraficCard carta2;
    GraficCard carta3;
    GraficCard carta4;

    public FundationPileGUI(ArrayList<FoundationDeck> fundacion) {
        this.fundacion = fundacion;
    }

    public void actualizeView(AnchorPane root)
    {
        // Obtener las Cartas
        CartaInglesa base = fundacion.get(0).getUltimaCarta();
        if(base != null)
        {
            carta1 = new GraficCard(base);

            carta1.setX(10);
            carta1.setY(45);
            carta1.setScaleX(0.75);
            carta1.setScaleY(0.75);

            root.getChildren().add(carta1);
        }

        base = fundacion.get(1).getUltimaCarta();
        if(base != null)
        {
            carta2 = new GraficCard(base);

            carta2.setX(70);
            carta2.setY(45);
            carta2.setScaleX(0.75);
            carta2.setScaleY(0.75);

            root.getChildren().add(carta2);
        }

        base = fundacion.get(2).getUltimaCarta();
        if(base != null)
        {
            carta3 = new GraficCard(base);

            carta3.setX(140);
            carta3.setY(45);
            carta3.setScaleX(0.75);
            carta3.setScaleY(0.75);

            root.getChildren().add(carta3);
        }

        base = fundacion.get(3).getUltimaCarta();
        if(base != null)
        {
            carta4 = new GraficCard(base);

            carta4.setX(220);
            carta4.setY(45);
            carta4.setScaleX(0.75);
            carta4.setScaleY(0.75);

            root.getChildren().add(carta4);
        }

    }


}
