package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;

public class ListFakturaJFrame extends JFrame {
    public ListFakturaJFrame() {
        initializeComponents();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        AddFakturaJPanel jPanel = new AddFakturaJPanel();
        ListFakturaJPanel jPanel = new ListFakturaJPanel();
        jPanel.setListFakturaJFrame(this);  // nie rozumiem konstrukcji

        add(jPanel);
        pack();
    }
}
