package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.zaliczenie.FakturaVat;

import javax.swing.*;
import java.awt.*;

public class AddFakturaJPanel extends JPanel {
    private ListFakturaJPanel listFakturaJPanel;

    public AddFakturaJPanel() {
        initializeComponents();
    }

    public void setListFakturaJPanel(ListFakturaJPanel listFakturaJPanel) {
        this.listFakturaJPanel = listFakturaJPanel;
    }

    private void initializeComponents() {
        setLayout(new GridLayout(0, 2));

        JLabel nameJLabel = new JLabel("Nazwa: ");
        JTextField nameJTextField = new JTextField();

        JButton saveJButton = new JButton("Zapisz");
        saveJButton.addActionListener(e -> {
            System.out.println("Zapisuję");
            this.listFakturaJPanel.addFakturaOnList(new FakturaVat("nowa faktura", 1, false));
        });

        add(nameJLabel);
        add(nameJTextField);
        add(saveJButton);
    }
}
