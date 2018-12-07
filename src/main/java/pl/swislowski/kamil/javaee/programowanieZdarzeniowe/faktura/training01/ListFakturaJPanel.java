package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;
import java.awt.*;

public class ListFakturaJPanel extends JPanel {
    private JFrame listFakturaJFrame;
    private  DefaultListModel<Faktura> fakturyListModel;

    public ListFakturaJPanel() {
        initializeComponents();
    }

    public void addFakturaOnList(Faktura faktura) {
        this.fakturyListModel.addElement(faktura);
    }

    public void setListFakturaJFrame(JFrame listFakturaJFrame) {
        this.listFakturaJFrame = listFakturaJFrame;
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        JPanel centerJPanel = new JPanel();
        JPanel pageEndJPanel = new JPanel();

        fakturyListModel = new DefaultListModel<>();

        JList<Faktura> jList = new JList<>(fakturyListModel);
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(900, 100));

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

            if (index != -1) fakturyListModel.remove(index);

            int size = fakturyListModel.getSize();

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
                Faktura faktura = jList.getSelectedValue();
                boolean closed = faktura.isZamknieta();
                if (!closed) {
                    faktura.zamknij();
                } else {
                    JOptionPane.showMessageDialog(this, "Faktura jest już zamknięta");
                }
                jList.updateUI();   //pozwala na odświeżenie wartości listy po zmianie faktury
            } else {
                System.out.println("No Option");
            }
            System.out.println("Zamykam fakturę...");
        });

        centerJPanel.add(jScrollPane);
        add(centerJPanel, BorderLayout.CENTER);

        pageEndJPanel.add(addButton);
        pageEndJPanel.add(editJButton);
        pageEndJPanel.add(detailsJButton);
        pageEndJPanel.add(removeJButton);
        pageEndJPanel.add(closeJButton);
        add(pageEndJPanel, BorderLayout.PAGE_END);
    }
}
