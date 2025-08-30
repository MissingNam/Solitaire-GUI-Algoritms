package org.sunburn.solitairegui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.sunburn.solitairegui.DeckOfCards.CartaInglesa;
import org.sunburn.solitairegui.DeckOfCards.Palo;

public class GraficCard extends ImageView {
    private CartaInglesa origen;
    private Image backImage = new Image((getClass().getResource("cardBack.jpg").toExternalForm()));
    private Image imagen;

    public GraficCard(CartaInglesa origen){
        this.origen = origen;

        Palo palo = origen.getPalo();
        int valor = origen.getValor();
        int fila = 0;
        int columna = 0;

        columna = valor-1;

        switch(palo.getFigura())
        {
            case "❤\uFE0F" -> {fila = 1;}

            case "♣\uFE0E" -> {fila = 2;}

            case "♦\uFE0F" -> {fila = 3;}

            case "♠\uFE0F" -> {fila = 4;}
        }

        String ubicacion = "fila-"+fila+"-columna-"+columna+".png";
        imagen = new Image((getClass().getResource("Cartas/"+ubicacion).toExternalForm()));

        if(origen.isFaceup()) {
            setImage(imagen);
        } else {
            setImage(backImage);
        }

    }

    public void actualizeView(){
        if(!origen.isFaceup())
        {
            setImage(backImage);
        } else {
            setImage(imagen);
        }
    }



}
