import java.util.Scanner;

public class S26683PO1 {

    public static void main(String[] args) {

        int wygranaPrzekatna1A = 0b010000_000100_000001;
        int wygranaPrzekatna1B = 0b100000_001000_000010;

        int wygranaPrzekatna2A = 0b000001_000100_010000;
        int wygranaPrzekatna2B = 0b000010_001000_100000;

        int wygranaPozioma1A = 0b000000_000000_010101;
        int wygranaPozioma1B = 0b000000_000000_101010;

        int wygranaPozioma2A = 0b000000_010101_000000;
        int wygranaPozioma2B = 0b000000_101010_000000;

        int wygranaPozioma3A = 0b010101_000000_000000;
        int wygranaPozioma3B = 0b101010_000000_000000;

        int wygranaPionowa1A = 0b000001_000001_000001;
        int wygranaPionowa1B = 0b000010_000010_000010;

        int wygranaPionowa2A = 0b000100_000100_000100;
        int wygranaPionowa2B = 0b001000_001000_001000;

        int wygranaPionowa3A = 0b010000_010000_010000;
        int wygranaPionowa3B = 0b100000_100000_100000;

        Scanner scanner = new Scanner(System.in);
        int stanPlanszy = 0;
        int nrPola;
        int licznik = 0;
        String obecnyRuch = "A";

        while (licznik < 9) {
            System.out.println("Kolej gracza " + obecnyRuch);
            System.out.println("Wybierz pole [0 - 8]");
            nrPola = scanner.nextInt();
            int pierwszyBitPola = nrPola * 2;
            int drugiBitPola = nrPola * 2 + 1;
            boolean czyBitGraczaAJestZajety = (stanPlanszy & (1 << pierwszyBitPola)) > 0;
            boolean czyBitGraczaBJestZajety = (stanPlanszy & (1 << drugiBitPola)) > 0;
            boolean czyPoleJestWolne = !(czyBitGraczaAJestZajety || czyBitGraczaBJestZajety);


            if (obecnyRuch.equals("A") && czyPoleJestWolne) {

                int nrBit = nrPola * 2;
                stanPlanszy = ((1 << nrBit) | stanPlanszy);

                for (int i = 0; i <= 6; i += 3) {
                    for (int j = i; j < i + 3; j++) {
                        if ((stanPlanszy & (1 << j * 2)) > 0) {
                            System.out.print("x");
                        } else if ((stanPlanszy & (1 << j * 2 + 1)) > 0) {
                            System.out.print("o");
                        } else {
                            System.out.print(" ");
                        }
                        if (j != i + 2) {
                            System.out.print('\u2503');
                        }
                    }
                    System.out.println();
                    if (i != 6) {
                        System.out.println('\u2501' + " " + '\u2501' + " " + '\u2501');
                    }
                }

                licznik++;


                if (((stanPlanszy & wygranaPrzekatna1A) == wygranaPrzekatna1A) ||
                        ((stanPlanszy & wygranaPrzekatna2A) == wygranaPrzekatna2A) ||
                        ((stanPlanszy & wygranaPozioma1A) == wygranaPozioma1A) ||
                        ((stanPlanszy & wygranaPozioma2A) == wygranaPozioma2A) ||
                        ((stanPlanszy & wygranaPozioma3A) == wygranaPozioma3A) ||
                        ((stanPlanszy & wygranaPionowa1A) == wygranaPionowa1A) ||
                        ((stanPlanszy & wygranaPionowa2A) == wygranaPionowa2A) ||
                        ((stanPlanszy & wygranaPionowa3A) == wygranaPionowa3A)) {
                    System.out.println("Wygral gracz " + obecnyRuch);
                    break;
                }

                obecnyRuch = "B";

            } else if (obecnyRuch.equals("B") && czyPoleJestWolne) {

                int nrBit = nrPola * 2 + 1;
                stanPlanszy = ((1 << nrBit) | stanPlanszy);
                
                for (int i = 0; i <= 6; i += 3) {
                    for (int j = i; j < i + 3; j++) {
                        if ((stanPlanszy & (1 << j * 2)) > 0) {
                            System.out.print("x");
                        } else if ((stanPlanszy & (1 << j * 2 + 1)) > 0) {
                            System.out.print("o");
                        } else {
                            System.out.print(" ");
                        }
                        if (j != i + 2) {
                            System.out.print('\u2503');
                        }
                    }
                    System.out.println();
                    if (i != 6) {
                        System.out.println('\u2501' + " " + '\u2501' + " " + '\u2501');
                    }
                }

                licznik++;

                if (((stanPlanszy & wygranaPrzekatna1B) == wygranaPrzekatna1B) ||
                        ((stanPlanszy & wygranaPrzekatna2B) == wygranaPrzekatna2B) ||
                        ((stanPlanszy & wygranaPozioma1B) == wygranaPozioma1B) ||
                        ((stanPlanszy & wygranaPozioma2B) == wygranaPozioma2B) ||
                        ((stanPlanszy & wygranaPozioma3B) == wygranaPozioma3B) ||
                        ((stanPlanszy & wygranaPionowa1B) == wygranaPionowa1B) ||
                        ((stanPlanszy & wygranaPionowa2B) == wygranaPionowa2B) ||
                        ((stanPlanszy & wygranaPionowa3B) == wygranaPionowa3B)) {
                    System.out.println("Wygral gracz " + obecnyRuch);
                    break;
                }

                obecnyRuch = "A";
            } else {
                System.out.println("\nTo pole jest juz zajete\n");
            }
        }
        System.out.println("\nRemis");
    }
}