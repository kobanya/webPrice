import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class webShopPrice {
    private JRadioButton radioButtonSor;
    private JRadioButton radioButtonKonyv;
    private JLabel total;
    private JButton buttonKartya;
    private JPanel web;
    private JButton ButtonKP;
    private JRadioButton radioButtonHagyma;
    private JRadioButton radioButtonMosogep;
    private JRadioButton radioButtonMikro;
    private JLabel subTotal€;
    private JLabel subTomeg;
    private JRadioButton radioButtonCoke;
    private JRadioButton radioButtonCoke6;
    private JLabel Kedvezmeny;
    private JLabel szaalitas;

    // Változók   definiálása
    public int totalTotal = 0;
    public int sor;
    public double sortomeg;
    public int coke03;
    public double coke3Tomeg;
    public int coke12;
    public double coke12Tomeg;
    public int hagyma;
    public double hagymaTomeg;
    public int konyv;
    public double konyvTomeg;
    // szamoláshoz szükséges  változók definiálása
    public int reszOszegAr = 0;
    public double reszOsszegTomeg = 0;
    public int mosogep;
    public double mosogeoTomeg;
    public int mikro;
    public double mikroTomeg;
    public double szallitasiDij;
    public double subTomegKg;

    // a SÖR kiválasztása
    public webShopPrice() {
        radioButtonSor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sor = 4;
                sortomeg = 0.2;
                ujraszamol();
                szallitasiDij();

            }
        });
        radioButtonCoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coke03 = 3;
                coke3Tomeg = 0.3;
                ujraszamol();
                szallitasiDij();
            }
        });
        radioButtonCoke6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coke12 = 10;
                coke12Tomeg = 12.0;
                ujraszamol();
                szallitasiDij();
            }
        });
        radioButtonHagyma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hagyma = 5;
                hagymaTomeg = 1.0;
                ujraszamol();
                szallitasiDij();
            }
        });
        radioButtonKonyv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konyv = 50;
                konyvTomeg = 1.0;
                ujraszamol();
                szallitasiDij();
            }
        });
        radioButtonMosogep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mosogep = 250;
                mosogeoTomeg = 10;
                ujraszamol();
                szallitasiDij();
            }
        });
        radioButtonMikro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mikro = 99;
                mikroTomeg = 1.5;
                ujraszamol();
                szallitasiDij();
            }
        });
    }

    // az ablak definiálása
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ár meghatározás / Price calculation");
        frame.setContentPane(new webShopPrice().web);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
// az ablak megnyitása a monitor közepén

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
    }


    void ujraszamol() {
        reszOszegAr = sor + coke03 + coke12 + hagyma + konyv + mosogep + mikro;
        subTotal€.setText(reszOszegAr + " €");
        // resz tömeg
        reszOsszegTomeg = sortomeg + coke3Tomeg + coke12Tomeg + hagymaTomeg + konyvTomeg + mosogeoTomeg + mikroTomeg;
        subTomeg.setText(reszOsszegTomeg + " Kg");
    }

    void szallitasiDij() {
        if (reszOszegAr > 100) {
            szallitasiDij = 0;
            szaalitas.setText(szallitasiDij + " €");
        } else {
            if (reszOsszegTomeg < 5.0) {
                szallitasiDij = 0;
                szaalitas.setText(szallitasiDij + " €");
            } else {
                szallitasiDij = reszOsszegTomeg;
                szaalitas.setText(szallitasiDij + " €");
            }

        }
    }
}