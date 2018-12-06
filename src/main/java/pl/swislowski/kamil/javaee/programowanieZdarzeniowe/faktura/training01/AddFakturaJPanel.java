package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;
import java.awt.*;

public class AddFakturaJPanel extends JPanel {
    public AddFakturaJPanel() {
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(0, 2));

        JLabel nameJLabel = new JLabel("Nazwa: ");
        JTextField nameJTextField = new JTextField();

        JButton saveJButton = new JButton("Zapisz");
        saveJButton.addActionListener(e -> {
            System.out.println("Zapisuję");
        });

        add(nameJLabel);
        add(nameJTextField);
        add(saveJButton);
    }
}
