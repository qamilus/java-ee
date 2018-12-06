package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;
import java.awt.*;

public class AddFakturaJDialog extends JDialog {

    private ListFakturaJPanel listFakturaJPanel;

    public AddFakturaJDialog(JFrame parent, ListFakturaJPanel listFakturaJPanel) {
        super(parent);
        this.listFakturaJPanel = listFakturaJPanel;

        initializeComponents();
    }

    private void initializeComponents() {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        AddFakturaJPanel jPanel = new AddFakturaJPanel();
        jPanel.setListFakturaJPanel(listFakturaJPanel);

        add(jPanel);
        pack();
    }

    public void setListFakturaJPanel(ListFakturaJPanel listFakturaJPanel) {
        this.listFakturaJPanel = listFakturaJPanel;
        System.out.println("####");
        System.out.println(this.listFakturaJPanel);
    }
}
