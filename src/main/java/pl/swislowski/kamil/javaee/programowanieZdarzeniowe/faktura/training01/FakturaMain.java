package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import javax.swing.*;
import java.awt.*;

public class FakturaMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame fakturaJFrame = new ListFakturaJFrame();
            fakturaJFrame.setVisible(true);

        });

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
}
