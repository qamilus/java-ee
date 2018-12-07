package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.Kontrahent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddFakturaJPanel extends JPanel {

    private AddFakturaJDialog addFakturaJDialog;
    private ListFakturaJPanel listFakturaJPanel;
    private DefaultListModel<Faktura.Pozycja> fakturaPozycjeListModel;

    private Kontrahent kontrahent = new Kontrahent("ABS sp. z o.o. \nul. Platna 12, 00-000 Warszawa", "123-123-123");
    private Faktura nowaFaktura = new Faktura(kontrahent);

    public AddFakturaJPanel() {
        initializeComponents();
    }

    public void addPozycjaFakturyOnList(String nazwa, Faktura.Miara miara, double ilosc, double cena, Faktura.VAT podatek) {
        this.nowaFaktura.addPozycja(nazwa, Faktura.Miara.SZT, ilosc, cena, Faktura.VAT.s23);

        propagatePozycjeFaktury();
    }

    private void propagatePozycjeFaktury() {
        ArrayList<Faktura.Pozycja> pozycje = this.nowaFaktura.getPozycje();
        this.fakturaPozycjeListModel.removeAllElements();

        for (Faktura.Pozycja pozycja : pozycje) {
            this.fakturaPozycjeListModel.addElement(pozycja);
        }
    }

    public void setListFakturaJPanel(ListFakturaJPanel listFakturaJPanel) {
        this.listFakturaJPanel = listFakturaJPanel;
    }

    public void setAddFakturaJDialog(AddFakturaJDialog addFakturaJDialog) {
        this.addFakturaJDialog = addFakturaJDialog;
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        JPanel pageStartJPanel = new JPanel();
        JPanel centerJPanel = new JPanel();
        JPanel pageEndJPanel = new JPanel();

        fakturaPozycjeListModel = new DefaultListModel<>();

        JList<Faktura.Pozycja> fakturaPozycjeJList = new JList<>(fakturaPozycjeListModel);
        JScrollPane jScrollPane = new JScrollPane(fakturaPozycjeJList);

        JLabel numerJLabel = new JLabel("Nr: ");
        JTextField numerJTextField = new JTextField();
        numerJTextField.setColumns(8);
        numerJTextField.setText(nowaFaktura.getNr());
        numerJTextField.setEditable(false);

        JLabel kontrahentJLabel = new JLabel("Kontrahent: ");
        JTextField kontrahentJTextField = new JTextField();
        kontrahentJTextField.setColumns(36);
        kontrahentJTextField.setText(nowaFaktura.getKlient().toString());
        kontrahentJTextField.setEditable(false);

        JLabel dataWystawieniaJLabel = new JLabel("Data wystawienia: ");
        JTextField dataWystawieniaJTextField = new JTextField();
        dataWystawieniaJTextField.setColumns(8);
        dataWystawieniaJTextField.setText(nowaFaktura.getDataWystawienia().toString());
        dataWystawieniaJTextField.setEditable(false);

        JButton saveJButton = new JButton("Zapisz");
        saveJButton.addActionListener(e -> {
            System.out.println("Zapisuję");
            this.listFakturaJPanel.addFakturaOnList(nowaFaktura);
            this.addFakturaJDialog.setVisible(false);
        });

        JButton addItemJButton = new JButton("Nowa pozycja");
        addItemJButton.addActionListener(e -> {
            AddPozycjaFakturaJDialog jDialog = new AddPozycjaFakturaJDialog(this.addFakturaJDialog, this);
            jDialog.setVisible(true);
            System.out.println("Dodaję nową pozycję na fakturze.");
        });

        pageStartJPanel.add(numerJLabel);
        pageStartJPanel.add(numerJTextField);
        pageStartJPanel.add(kontrahentJLabel);
        pageStartJPanel.add(kontrahentJTextField);
        pageStartJPanel.add(dataWystawieniaJLabel);
        pageStartJPanel.add(dataWystawieniaJTextField);
        add(pageStartJPanel, BorderLayout.PAGE_START);

        centerJPanel.add(jScrollPane);
        add(centerJPanel, BorderLayout.CENTER);

        pageEndJPanel.add(saveJButton);
        pageEndJPanel.add(addItemJButton);
        add(pageEndJPanel, BorderLayout.PAGE_END);
    }
}
