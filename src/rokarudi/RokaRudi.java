
package rokarudi;

import java.util.Scanner;

public class RokaRudi {
    
    private final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        new RokaRudi().program();
        
    }
    private void program() {
        String[] pakli = pakliosszeallit();
        int sor;
        
        for (int i = 0; i < 3; i++) {
            kirak(pakli);
            System.out.print("Sor(1-3):");
            sor = SC.nextInt();
            pakli = kever(pakli, sor);
        }
        
        ezVolt(pakli);
    }
    
    private String[] pakliosszeallit() {
        String[] szinek = {"P", "T", "L", "M"};
        String[] ertekek = {"K", "A", "F", "X", "IX", "VIII"};
        String[] pakli = new String[22];
        int j = 1;
        
        for (String szin : szinek) {
            for (int i = 0; i < ertekek.length && j < pakli.length; i++) {
                pakli[j++] = "%s_%s".formatted(szin, ertekek[i]);
            }
        }
        
        
        return pakli;
    }
    
    private String[] kever(String[] pakli, int sor) {
        String[] ujTomb = new String[pakli.length];
        
        switch (sor) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    ujTomb[i] = pakli[20 - (i - 1) * 3];
                    ujTomb[i + 7] = pakli[19 - (i - 1) * 3];
                    ujTomb[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    ujTomb[i] = pakli[19 - (i - 1) * 3];
                    ujTomb[i + 7] = pakli[20 - (i - 1) * 3];
                    ujTomb[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    ujTomb[i] = pakli[20 - (i - 1) * 3];
                    ujTomb[i + 7] = pakli[21 - (i - 1) * 3];
                    ujTomb[i + 14] = pakli[19 - (i - 1) * 3];
                }
                break;
        }
        
        return ujTomb;
    }
    
    private void kirak(String[] lapok) {
        String txt = "";
        
        for (int i = 1; i < lapok.length; i++) {
            txt += "%10s".formatted(lapok[i]);
            if (i % 3 == 0) {
                txt += "\n";
            }
        }
        
        
        System.out.println(txt);
    }
    
    
    private void ezVolt(String[] pakli) {
        System.out.printf("A kiválasztott lap: %s\n", pakli[11]);
    }
    
}
