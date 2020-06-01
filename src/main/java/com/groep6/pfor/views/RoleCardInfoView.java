package com.groep6.pfor.views;

import com.groep6.pfor.controllers.RoleCardInfoController;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.views.components.UICard;
import com.sun.tools.javac.comp.Flow;
import javafx.scene.layout.FlowPane;

/**
 * The view that shows a card's information
 * @author Mathijs
 */
public class RoleCardInfoView extends View {
    /** The roleCardInfoController */
    private RoleCardInfoController roleCardInfoController;

    /**
     * The constructor
     * @param roleCardInfoController the roleCardInfoController
     */
    public RoleCardInfoView(RoleCardInfoController roleCardInfoController) {
        this.roleCardInfoController = roleCardInfoController;
    }

    public void createView() {

        FlowPane flowPane = new FlowPane();

        for (RoleCard card: roleCardInfoController.getRoleCards()) {
            UICard uicard = new UICard(card.getName());
            flowPane.getChildren().add(uicard);
        }


    }
}
