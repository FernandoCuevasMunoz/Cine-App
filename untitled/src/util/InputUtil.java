package util;

import java.util.Scanner;

public class InputUtil {
    public static int readInt(Scanner scanner, String message){
        while (true){
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Error: Debes ingresar un número entero válido");
            }
        }
    }

    public static String readText(Scanner scanner, String message){
        while (true){
            System.out.print(message);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()){
                return text;
            }
            System.out.println("Error: el texto no puede estar vacío");
        }
    }
}
