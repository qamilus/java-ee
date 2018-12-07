package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;

public class AddPozycjaFakturaJDialog extends JDialog {

    private AddFakturaJPanel addFakturaJPanel;

    public AddPozycjaFakturaJDialog(JDialog parent, AddFakturaJPanel addFakturaJPanel) {
        super(parent);
        this.addFakturaJPanel = addFakturaJPanel;

        initializeComponents();
    }

    private void initializeComponents() {
        setModalityType(ModalityType.APPLICATION_MODAL);

        AddPozycjaFakturaJPanel jPanel = new AddPozycjaFakturaJPanel(this.addFakturaJPanel, this);

        add(jPanel);
        pack();
    }
}
