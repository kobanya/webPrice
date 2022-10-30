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
    private JLabel szallitSzovegMezo;
    private JLabel subKedvezmeny;
    private JLabel reszOsszegTotal;
    private JLabel LabelReszosszeg;
    private JLabel LkartyaKedvezmeny;

    private JLabel LkartyakedvezmenyOsszeg;
    private JButton ClearButton;


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
    public double termekKedvezmeny;
    public double reszosszegMinuszKedvezmeny;
    public double  katryaKedvezmeny;
    public double  kartyKedvezmenyOsszeg;

    // a SÖR kiválasztása
    public webShopPrice() {
        LkartyaKedvezmeny.setVisible(false);
        LkartyakedvezmenyOsszeg.setVisible(false);
    // termékválasztás
        radioButtonSor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sor = 4;
                sortomeg = 0.2;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();

            }
        });
        radioButtonCoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coke03 = 3;
                coke3Tomeg = 0.3;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        radioButtonCoke6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coke12 = 10;
                coke12Tomeg = 12.0;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        radioButtonHagyma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hagyma = 5;
                hagymaTomeg = 1.0;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        radioButtonKonyv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konyv = 50;
                konyvTomeg = 1.0;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        radioButtonMosogep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mosogep = 250;
                mosogeoTomeg = 10;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        radioButtonMikro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mikro = 99;
                mikroTomeg = 1.5;
                ujraszamol();
                szallitasiDij();
                kedvezmeny();
                reszosszeg();
            }
        });
        buttonKartya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            kartyKedvezmenyOsszeg=reszOszegAr*0.13;
            LkartyakedvezmenyOsszeg.setText(Math.round(kartyKedvezmenyOsszeg)+" €");
            katryaKedvezmeny = reszOszegAr-reszOszegAr * 0.13  ;
            total.setText(Math.round(katryaKedvezmeny )+" €");
                LkartyaKedvezmeny.setVisible(true);
                LkartyakedvezmenyOsszeg.setVisible(true);
            }
        });
        ButtonKP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            total.setText(reszosszegMinuszKedvezmeny + " €");
                LkartyaKedvezmeny.setVisible(false);
                LkartyakedvezmenyOsszeg.setVisible(false);
            }
        });

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        // törlés
                ujValasztas();
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
        subTomeg.setText(reszOsszegTomeg + " kg");
    }

    void szallitasiDij() {
        if (reszOszegAr > 100) {
            szallitasiDij = 0;
            szallitSzovegMezo.setForeground(Color.red);
            szallitSzovegMezo.setText("Díjmentes szállítás/ Free");
            szaalitas.setForeground(Color.red);
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
    void kedvezmeny() {
        if (reszOszegAr>200){
            termekKedvezmeny = reszOszegAr *  0.10;

            // kerekített kedvezmény
            subKedvezmeny.setText(Math.round(termekKedvezmeny) + " €");
        }
    }

    void reszosszeg() {
        reszosszegMinuszKedvezmeny = reszOszegAr+ szallitasiDij- termekKedvezmeny;
        LabelReszosszeg.setText(reszosszegMinuszKedvezmeny+" €");
    }
    void ujValasztas(){
        radioButtonSor.setSelected(false);
        radioButtonCoke.setSelected(false);
        radioButtonHagyma.setSelected(false);
        radioButtonCoke6.setSelected(false);
        radioButtonKonyv.setSelected(false);
        radioButtonMikro.setSelected(false);
        radioButtonMosogep.setSelected(false);
        // árak törlése
        sor=0;
        sortomeg=0;
        coke12=0;
        coke12Tomeg=0;
        coke03=0;
        coke3Tomeg=0;
        hagyma=0;
        hagymaTomeg=0;
        konyv=0;
        konyvTomeg=0;
        mosogep=0;
        mosogeoTomeg=0;
        mikro=0;
        mikroTomeg=0;
        reszOsszegTomeg=0;
        reszOszegAr=0;
        subTomegKg=0;
        katryaKedvezmeny=0;
        szallitasiDij=0;
        termekKedvezmeny=0;
        reszosszegMinuszKedvezmeny=0;
        LabelReszosszeg.setText("0,- €");
        subKedvezmeny.setText("0,- €");
        szaalitas.setText("0,- €");
        subTomeg.setText("0,0 Kg");
        subTotal€.setText("0,- €");
        szallitSzovegMezo.setText("Szállítási díj");
        szaalitas.setForeground(Color.black);
        LkartyaKedvezmeny.setVisible(false);
        LkartyakedvezmenyOsszeg.setVisible(false);
        szallitSzovegMezo.setForeground(Color.black);
        total.setText(" 0,- €");

    }
}