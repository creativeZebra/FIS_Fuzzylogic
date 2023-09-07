/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ai_microproyecto4;

import ai_microproyecto4.FIS_Emovilidad;
import java.util.Scanner;

/**
 *
 * @author julian
 */
public class EMovilidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FIS_Emovilidad fis = new FIS_Emovilidad();
        
        System.out.println("Microproyecto 1 - FIS con jFuzzyLogic:");
        System.out.println("Ingrese la CANTIDAD de personas1 (1-50)");
        double cantidad = scan.nextDouble();
        System.out.println("Ingrese la DISTANCIA en km (0-100)");
        double distancia = scan.nextDouble();
        System.out.println("Ingrese el PRESUPUESTO en miles de pesos colombianos por persona (1-100)");
        double presupuesto = scan.nextDouble();
        System.out.println("Ingrese la HORA de salida (0-24)");
        double hora = scan.nextDouble();
        
        double result_emisiones = fis.evaluar_emisiones(cantidad, distancia, presupuesto, hora);
        String CD_emisiones = fis.get_CD_emisiones();
        
        double result_disponsibilidad = fis.evaluar_disponsibilidad(cantidad, distancia, presupuesto, hora);
        String CD_disponsibilidad = fis.get_CD_disponsibilidad();
        
        System.out.println(" ");
        System.out.println("FIS Output:");
        System.out.println("Predecimos que estas son las emisiones de su medio de transporte: " + result_emisiones + " gCO2 / pKm");
        System.out.println("Este se considerar el medio de transporte: " + CD_emisiones);
        System.out.println(" ");
        System.out.println("Predecimos que esta la disponsibilidad de su medio de transporte: " + result_disponsibilidad + " %");
        System.out.println("Este se considerar una disponsibilidad: " + CD_disponsibilidad);
        
        
    }
    
}
