package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.zaliczenie.FakturaVat;

import javax.swing.*;

public class ListFakturaJPanel extends JPanel {
    private JFrame listFakturaJFrame;
    private  DefaultListModel<FakturaVat> listModel;

    public ListFakturaJPanel() {
        initializeComponents();
    }

    public void addFakturaOnList(FakturaVat fakturaVat) {
        this.listModel.addElement(fakturaVat);
    }

    private void initializeComponents() {
        listModel = new DefaultListModel<>();
        listModel.addElement(new FakturaVat("Klej", 5, true));
        listModel.addElement(new FakturaVat("Nożyczki", 15, false));

        JList<FakturaVat> jList = new JList<>(listModel);
        JScrollPane jScrollPane = new JScrollPane(jList);

        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(e -> {
            System.out.println("Dodaję...");
            AddFakturaJDialog jDialog = new AddFakturaJDialog(this.listFakturaJFrame, this);
            jDialog.setVisible(true);
        });

        JButton editJButton = new JButton("Edytuj");
        editJButton.addActionListener(e -> {
            System.out.println("Editing...");
        });

        JButton detailsJButton = new JButton("Szczegóły");
        detailsJButton.addActionListener(e -> {
            System.out.println("Wyświetlam szczegóły...");
        });

        JButton removeJButton = new JButton("Usuń");
        removeJButton.addActionListener(e -> {
            int index = jList.getSelectedIndex();

            if (index != -1) listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { // no item on the list
                removeJButton.setEnabled(false);
            } else {
                if (index == size) {
                    //removed item in last position
                    index--;
                }

                jList.setSelectedIndex(index);
                jList.ensureIndexIsVisible(index);
            }
            System.out.println("Removing...");
        });

        JButton closeJButton = new JButton("Zamknij FV");
        closeJButton.addActionListener(e -> {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Czy zamknąć fakturę?", "Zamknięcie faktury", dialogButton);
            if (dialogResult == 0) {
                System.out.println("Yes option");
                int index = jList.getSelectedIndex();
                FakturaVat fakturaVat = jList.getSelectedValue();
                boolean closed = fakturaVat.isClosed();
                if (!closed) {
                    fakturaVat.setClosed(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Faktura jest już zamknięta");
                }
//                jList.setSelectedIndex(index);
//                jList.ensureIndexIsVisible(index);
                jList.updateUI();   //pozwala na odświeżenie wartości listy po zmianie fakturyVat
            } else {
                System.out.println("No Option");
            }
            System.out.println("Zamykam fakturę...");
        });

        add(jScrollPane);
        add(addButton);
        add(editJButton);
        add(detailsJButton);
        add(removeJButton);
        add(closeJButton);
    }

    public void setListFakturaJFrame(JFrame listFakturaJFrame) {
        this.listFakturaJFrame = listFakturaJFrame;
    }
}
