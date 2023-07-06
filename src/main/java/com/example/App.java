package com.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        String userType;
        int input;

        Shop shop = new Shop();

        System.out.println("Ingrese el tipo de usuario con el que quiere acceder al sistema (ingrese el número)");
        System.out.println("1. Administrador");
        System.out.println("2. Cliente");

        while (true) {
            input = scanner.nextInt();
            if (input == 1) {
                userType = "admin";
                break;
            }
            else if (input == 2){
                userType = "client";
                break;
            }
            else{
                System.out.println("Usuario inválido");
            }
        }

        while (true){
            String gameName;
            int gameAmmount;

            if (userType == "client") {
                
                try {
                    System.out.println("Escriba el nombre del juego que quiere comprar");
                    gameName = scanner.nextLine();
                    System.out.println("Ingrese la cantidad de copias que quiere comprar");
                    gameAmmount = scanner.nextInt();
                    
                    shop.makeSale(gameName, gameAmmount);

                } catch (Exception e) {
                    System.out.println("Se produjo un error en la operación");
                }

            }
            else if (userType == "admin") {
                
                System.out.println("Indique que operación quiere realizar (Ingrese el número)");
                System.out.println("1. Vender juego");
                System.out.println("2. Comprar Juego");
                System.out.println("3. Visualizar inventario");
                System.out.println("4. Visualizar reporte");

                int operation; // 1 para venta, 2 para compra
                operation = scanner.nextInt();
                if (operation == 1) {

                    try {
                        System.out.println("Escriba el nombre del juego que quiere vender");
                        gameName = scanner.nextLine();
                        System.out.println("Ingrese la cantidad de copias que quiere vender");
                        gameAmmount = scanner.nextInt();
                        
                        shop.makeSale(gameName, gameAmmount);

                    } catch (Exception e) {
                        System.out.println("Se produjo un error en la operación");
                    }

                
                }
                else if(operation == 2) {

                    try {

                        System.out.println("Escriba el nombre del juego que se va a comprar");
                        gameName = scanner.nextLine();
                        System.out.println("Ingrese la cantidad de copias");
                        gameAmmount = scanner.nextInt();

                        shop.makePurchase(gameName, gameAmmount);

                    } catch (Exception e) {
                        System.out.println("Se produjo un error en la operación");
                    }

                    
                }
                else if (operation == 3){
                    shop.checkInventory();
                }
                else if (operation == 4) {
                    shop.makeReport();
                }
            }
        }


    }

     
}
