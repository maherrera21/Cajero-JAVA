/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MIGUELH
 */
public class Cajero {
public static Scanner entrada = new Scanner(System.in);
 static double money;
 
  public static void Inicio(){
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$                                                                         $$$$");
 System.out.println("$$$$                       Cajero Automático v.:1.0                          $$$$");
 System.out.println("$$$$                                                                         $$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$                          ____--== MENU ==--____                         $$$$");
 System.out.println("$$$$        1. Consultar balance                                             $$$$");
 System.out.println("$$$$        2. Retirar efectivo                                              $$$$");
 System.out.println("$$$$        3. Salir                                                         $$$$");
 System.out.println("$$$$                           <---- END MENU ---->                          $$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 }
 public static void Balance(){
  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 System.out.println("$$$$                                                                         $$$$");
 System.out.println("       Su balance actual es: "        + money +        " pesos dominicanos.      ");
 System.out.println("$$$$                                                                         $$$$");
 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
 }
 public static void Retiro(){
  double cantidad;
 System.out.println("Introduzca la cantidad a retirar: ");
 cantidad = entrada.nextDouble();
 if(cantidad > money){
     System.out.println("La cantidad ingresada sobrepasa a su balance actual.");
     System.out.println("Lo sentimos, su transaccion no puede ser completada.");
 }else if(cantidad % 100 != 0 ){
     System.out.println("Lo sentimos, su transaccion no puede ser completada.");
     System.out.println("Solo se aceptan cantidades multiplos de 100.");
 }else{
     int dosm = 0;
     int mil =  0;
     int quin = 0;
     int dosc = 0;
     int cien = 0;
     double monto = cantidad; 
     money -= cantidad;
  while(cantidad != 0){
    if(cantidad >= 2000){
        cantidad -= 2000;
        dosm++;
    }else if((cantidad < 2000) && (cantidad >= 1000)){
       cantidad -= 1000;
       mil++;
    }else if((cantidad < 1000) && (cantidad >= 500)){
       cantidad -= 500;
       quin++;
    }else if((cantidad < 500) && (cantidad >= 200)){
      cantidad -= 200;
      dosc++;
    }else{  
      cantidad -= 100;
      cien++;
   }
  }
  if(dosm != 0){
   if(dosm == 1){
      System.out.println("Enviando 1 papeleta de 2000");
      
   }else{
      System.out.println("Enviando " + dosm + " papeletas de 2000");
            }
  } 
  if(mil != 0){
      System.out.println("Enviando 1 papeleta de 1000");
  }
  if(quin != 0){
      System.out.println("Enviando 1 papeleta de 500");
  }
  if(dosc != 0){
   if(dosc == 1){
      System.out.println("Enviando 1 papeleta de 200");
   }else{
      System.out.println("Enviando " + dosc + " papeletas de 200");
   }
  } 
  if(cien != 0){
    System.out.println("Enviando 1 papeleta de 100");
  }
   System.out.println("La transacción ha sido completada.");
   System.out.println("Usted ha retirado " + monto + "0 de su cuenta.");
   System.out.println("Su balance actual es " + money + "\n");
   
     
   }
 } 
   
  public static void main(String[] arg) 
  {
  byte opt;
 // Hacemos este bucle para asegurarnos de que el monto sea mayor o igual que el sueldo minimo en RD, 7000
 do{
 money = (Math.random()*200000+1);   // Sueldo maximo  200,000
 }while(money < 7000);
 money = (double)Math.round(money*100)/100; // Esto es para que la cantidad sea mostrada solo con dos digitos despues del punto.
 do{
   opt = 0;
   Inicio();
   try{
   System.out.println("\nPor favor, seleccione su opcion segun lo que quiera hacer: ");
   opt = entrada.nextByte();
   } catch(InputMismatchException e){
     System.out.println("Error de entrada! Numero demasiado grande o ni siquiera es un numero!!!");
     System.out.println("Saque su tarjeta e ingresela de nuevo(reinicia el programa) " +
     "y asegurese de elegir una opcion presente en el menu!!!");
     System.out.println("Error: " + e.getMessage() );
     break;
 }
 switch(opt){
  case 1:
    Balance();
    break;
  case 2:
    Retiro();
    break;
  case 3:
    System.out.println("Gracias por preferirnos!!!");
    System.out.println("Bye...");
    break;
  default: 
    System.out.println("Opcion invalida!");   
  }
 }while(opt != 3);
   }
} 
