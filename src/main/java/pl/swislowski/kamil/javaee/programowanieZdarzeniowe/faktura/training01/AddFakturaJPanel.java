package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.zaliczenie.FakturaVat;

import javax.swing.*;
import java.awt.*;

public class AddFakturaJPanel extends JPanel {

    private FakturaVat pozycja;
    private AddFakturaJDialog addFakturaJDialog;
    private ListFakturaJPanel listFakturaJPanel;
    private DefaultListModel<FakturaVat> listModel;

    public AddFakturaJPanel() {
        initializeComponents();
    }

    public void setListFakturaJPanel(ListFakturaJPanel listFakturaJPanel) {
        this.listFakturaJPanel = listFakturaJPanel;
    }

    public void setAddFakturaJDialog(AddFakturaJDialog addFakturaJDialog) {
        this.addFakturaJDialog = addFakturaJDialog;
    }

    private void initializeComponents() {
//        setLayout(new GridLayout(0, 2, 50, 50));
        setLayout(new BorderLayout());

        JPanel pageStartJPanel = new JPanel();
        JPanel centerJPanel = new JPanel();
        JPanel pageEndJPanel = new JPanel();

        listModel = new DefaultListModel<>();
        listModel.addElement(new FakturaVat("Klej", 5, true));
        listModel.addElement(new FakturaVat("Nożyczki", 15, false));

        JList<FakturaVat> jList = new JList<>(listModel);
        JScrollPane jScrollPane = new JScrollPane(jList);

//        JLabel idJLabel = new JLabel("id");
//        JTextField idJTextField = new JTextField();

        JLabel numerJLabel = new JLabel("Nr: ");
        JTextField numerJTextField = new JTextField();
        numerJTextField.setColumns(8);
        numerJTextField.setEditable(false);

        JLabel kontrahentJLabel = new JLabel("Kontrahent: ");
        JTextField kontrahentJTextField = new JTextField();
        kontrahentJTextField.setColumns(8);

        JLabel dataWystawieniaJLabel = new JLabel("Data wystawienia: ");
        JTextField dataWystawieniaJTextField = new JTextField();
        dataWystawieniaJTextField.setColumns(8);

        JButton saveJButton = new JButton("Zapisz");
        saveJButton.addActionListener(e -> {
            System.out.println("Zapisuję");
            this.listFakturaJPanel.addFakturaOnList(new FakturaVat("nowa faktura", 1, false));


        });

        JButton addItemJButton = new JButton("Nowa pozycja");
        addItemJButton.addActionListener(e -> {
            AddPozycjaFakturaJDialog jDialog = new AddPozycjaFakturaJDialog(this.addFakturaJDialog, this);
            jDialog.setVisible(true);
            System.out.println("Dodaję nową pozycję na fakturze.");
        });

//        add(idJLabel);
//        add(idJTextField);

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
