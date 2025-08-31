package org.sunburn.solitairegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    private SolitaireGUI solg;
    private Button reload = new Button("Reload");

    private int botonesPresionados = 0;
    private int boton1 = 0;
    private int boton2 = 0;

    @FXML
    Button tableu1;
    @FXML
    Button tableu2;
    @FXML
    Button tableu3;
    @FXML
    Button tableu4;
    @FXML
    Button tableu5;
    @FXML
    Button tableu6;
    @FXML
    Button tableu7;
    @FXML
    Button Fundation;
    @FXML
    Button Discard;

        // recibir el solitaireGUi para trabajar con el
    public void setSolg(SolitaireGUI solg) {
        this.solg = solg; }

    // llama a sacar cartas de SolitaireGame y actualiza la WastePileGUI
    public void sacarCartas()
    {
        solg.getSolitaireGame().drawCards();
        if(!solg.getSolitaireGame().getDrawPile().hayCartas())
        {
            solg.getCardBack().setVisible(false);
        }
        solg.actualizeWastePile();
    }

    // revisa que boton fue presionado y cuantos han sido
    // si ya presionaste 2 botones, segun cuales fueron, revisa que debe hacer
    @FXML
    public void buttonPressed(ActionEvent event)
    {
        // obtener que boton fue el activado
        Button botonPresionado = (Button) event.getSource();
        String id = botonPresionado.getId();
        int numero;
        if(id.equals("Fundation"))
        {
            numero = 8;
        } else if(id.equals("Discard"))
        {
            numero = 9;
        } else {
            String numeroStr = id.replaceAll("\\D+", "");
            numero = Integer.parseInt(numeroStr);
        }


        // revisar cuantos botones se han presionado
        if(botonesPresionados == 0)
        {
            boton1 = numero;
            botonesPresionados = 1;
        } else if(botonesPresionados == 1)
        {
            botonesPresionados = 0;
            boton2 = numero;
            if(boton1 < 8 && boton2 < 8)
            {
                solg.getSolitaireGame().moveTableauToTableau(boton1,boton2);
                solg.actualizeTableu();
            } else if ((boton1 == 8 || boton2 == 8) && (boton1 < 8 || boton2 < 8))
            {
                if(boton1 < 8)
                {
                    solg.getSolitaireGame().moveTableauToFoundation(boton1);
                    solg.actualizeFundationPile();
                    solg.actualizeTableu();
                    solg.checkGameEnd();
                } else {
                    solg.getSolitaireGame().moveTableauToFoundation(boton2);
                    solg.actualizeFundationPile();
                    solg.actualizeTableu();
                    solg.checkGameEnd();
                }
            } else if ((boton1 == 8 || boton2 == 8) && (boton1 == 9 || boton2 == 9))
            {
                solg.getSolitaireGame().moveWasteToFoundation();
                solg.actualizeFundationPile();
                solg.actualizeWastePile();
                solg.checkGameEnd();
            } else if((boton1 == 9 || boton2 == 9) && (boton1 < 8 || boton2 < 8))
            {
                if(boton1 < 8)
                {
                    solg.getSolitaireGame().moveWasteToTableau(boton1);
                    solg.actualizeWastePile();
                    solg.actualizeTableu();
                } else {
                    solg.getSolitaireGame().moveWasteToTableau(boton2);
                    solg.actualizeWastePile();
                    solg.actualizeTableu();
                }

            }
        }



    }

    // boton de recargar, recarga la pila y limpia lo grafico de WastePileGUI
    public void reloadButton()
    {
        solg.getSolitaireGame().getDrawPile().recargar(solg.getSolitaireGame().getWastePile().emptyPile());
        solg.actualizeWastePile();
        solg.getCardBack().setVisible(true);

    }
}
