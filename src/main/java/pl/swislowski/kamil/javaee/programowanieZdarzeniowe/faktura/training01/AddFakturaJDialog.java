package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;
import java.awt.*;

public class AddFakturaJDialog extends JDialog {
    private JFrame parent;   // dlaczego to jest parent?

    public AddFakturaJDialog(JFrame parent) {
        super(parent);

        this.parent = parent;
        initializeComponents();
    }

    private void initializeComponents() {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel jPanel = new AddFakturaJPanel();

        add(jPanel);
    }

}
