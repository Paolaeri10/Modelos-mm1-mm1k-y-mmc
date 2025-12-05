import java.util.Scanner;

public class FloreriaAustin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;  
        do {
            System.out.println("\n==============================");
            System.out.println("      Floreria Austin - Lineas de espera ");
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
            } while (opcion != 4);
    }

    // ---------------------------------------------------------
    //   MODELO M/M/1  (Un florista atendiendo)
    // ---------------------------------------------------------
    public static void mm1(Scanner sc) {
        System.out.println("\n--- MODELO M/M/1 (1 florista atendiendo) ---");

        System.out.print("Lambda (llegadas por minuto): ");
        double lambda = sc.nextDouble();
        System.out.print("Mu (ramos atendidos por minuto): ");
        double mu = sc.nextDouble();

        double p = lambda / mu;                // Utilización
        double Lq = (p * p) / (1 - p);         // Clientes en cola
        double L = p / (1 - p);                // Clientes en sistema
        double W = L / lambda;                 // Tiempo total
        double Wq = Lq / lambda;               // Tiempo en cola
        double variabilidad = 1 / (mu * mu);   // Variabilidad simple

        System.out.println("\nRESULTADOS FLORERÍA AUSTIN:");
        System.out.println("λ (tasa de llegada) = " + lambda);
        System.out.println("μ (tasa de servicio) = " + mu);
        System.out.println("ρ (p, utilización) = " + p);
        System.out.println("L = " + L + " clientes");
        System.out.println("Lq = " + Lq + " clientes en cola");
        System.out.println("W = " + W + " minutos");
        System.out.println("Wq = " + Wq + " minutos en cola");
        System.out.println("Variabilidad del servicio = " + variabilidad);
    }
    //---------------------------------------------------------
    // MODELO M/M/K/1   (Floreria con limite de cliente)
    //---------------------------------------------------------
    public static void mmk1(Scanner sc) {
        System.out.println("\n-- Modelo M/M/k/1 (Capacidad limitada en la florería) --");

        System.out.print("Lambda: ");
        double lambda = sc.nextDouble();
        System.out.print("Mu: ");
        double mu = sc.nextDouble();
        System.out.print("Capacidad máxima k: ");
        int k = sc.nextInt();

        double p = lambda / mu;
        double P0 = (1 - p) / (1 - Math.pow(p, k + 1));

        System.out.println("\n Resultados Floreria Austin:");
        System.out.println("ρ (p) = " + p);
        System.out.println("P0 (probabilidad de estar vacío) = " + P0);
        System.out.println("NOTA: En este modelo los clientes se rechazan si la florería está llena (k).");
    }   
    // 
    // Modelo M/M/c  (Varios floristas atendiendo 
    //
   public static void mmc(Scanner sc) {
       System.out.println("\n--- MODELO M/M/c (Varios floristas) ---");

        System.out.print("Lambda: ");
        double lambda = sc.nextDouble();
        System.out.print("Mu: ");
        double mu = sc.nextDouble();
        System.out.print("Número de floristas c: ");
        int c = sc.nextInt();

        double p = lambda / (c * mu);  // Utilización total 
      // Cálculo de P0
        double suma = 0;
        for (int n = 0; n < c; n++) {
            suma += Math.pow(lambda / mu, n) / factorial(n);
        }

        double parte2 = (Math.pow(lambda / mu, c) / factorial(c)) * (1 / (1 - p));
        double P0 = 1 / (suma + parte2);

        // Lq
        double Lq = (P0 * Math.pow(lambda / mu, c) * p) / (factorial(c) * Math.pow(1 - p, 2));

        double L = Lq + (lambda / mu);
        double W = L / lambda;
        double Wq = Lq / lambda;

        double variabilidad = 1 / (mu * mu);
        System.out.println("\n Resultados  Floreria Austin:");
        System.out.println("ρ (p) = " + p);
        System.out.println("P0 = " + P0);
        System.out.println("Lq = " + Lq + " clientes en cola");
        System.out.println("L = " + L + " clientes en sistema");
        System.out.println("W = " + W + " minutos");
        System.out.println("Wq = " + Wq + " minutos en cola");
        System.out.println("Variabilidad del servicio = " + variabilidad);
        }
        // Factorial simple
        public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
