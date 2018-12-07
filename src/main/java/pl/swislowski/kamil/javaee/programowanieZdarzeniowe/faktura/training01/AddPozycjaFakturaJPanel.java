package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;

public class AddPozycjaFakturaJPanel extends JPanel {

    public AddPozycjaFakturaJPanel(){
        initializeComponents();
    }

    private void initializeComponents() {
        JLabel nameJLabel = new JLabel("Nazwa: ");
        JTextField nameJTextField = new JTextField();
        nameJTextField.setColumns(8);

        JLabel miaraJLabel = new JLabel("Miara");
        JTextField miaraJTextField = new JTextField();
        miaraJTextField.setColumns(8);

        JLabel iloscJLabel = new JLabel("Ilosc");
        JTextField iloscJTextField = new JTextField();
        iloscJTextField.setColumns(8);

        JLabel cenaJLabel = new JLabel("Cena");
        JTextField cenaJTextField = new JTextField();
        cenaJTextField.setColumns(8);

        JLabel podatekJLabel = new JLabel("Podatek");
        JTextField podatekJTextField = new JTextField();
        podatekJTextField.setColumns(8);

        JButton saveJButton = new JButton("Zapisz");
        saveJButton.addActionListener(e->{
            System.out.println("Zapisuję nową pozycję...");
        });

        add(nameJLabel);
        add(nameJTextField);
        add(miaraJLabel);
        add(miaraJTextField);
        add(iloscJLabel);
        add(iloscJTextField);
        add(cenaJLabel);
        add(cenaJTextField);
        add(podatekJLabel);
        add(podatekJTextField);
        add(saveJButton);
    }
}
