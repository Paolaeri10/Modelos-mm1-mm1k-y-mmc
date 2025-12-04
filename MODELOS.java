import java.util.Scanner;

public class FloreriaAustin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;  
        do {
            System.out.println("\n==============================\n");
            System.out.println("      FLORERIA AUSTIN - LÍNEAS DE ESPERA");
            System.out.println("=========================================");
            System.out.println("1. Modelo M/M/1");
            System.out.println("2. Modelo M/M/k/1 (capacidad limitada)");
            System.out.println("3. Modelo M/M/c (c servidores)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    mm1(sc);
                    break;
                case 2:
                    mmk1(sc);
                    break;
                case 3:
                    mmc(sc);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            
