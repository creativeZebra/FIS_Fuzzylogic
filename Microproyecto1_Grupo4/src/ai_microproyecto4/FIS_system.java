/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai_microproyecto4;

import net.sourceforge.jFuzzyLogic.FIS;

        
/**
 *
 * @author julian
 */
public class FIS_system {
    private String path_FIS = "src/ai_microproyecto4/FIS_source.fcl";
    private FIS fis_var;
    
    public FIS_system(){
        this.fis_var = FIS.load(this.path_FIS, true);
   
        if(this.fis_var == null){
            System.out.println("Error al cagar el FIS");
        }
    }
    
    // EMISSIONES
    //
    //
    public double evaluar_emisiones(double cantidad, double distancia, double presupuesto, double hora){
        this.fis_var.setVariable("cantidad", cantidad);
        this.fis_var.setVariable("distancia", distancia);
        this.fis_var.setVariable("presupuesto", presupuesto);
        this.fis_var.setVariable("hora", hora);
        
        this.fis_var.evaluate();
        
        return this.fis_var.getVariable("emisiones").getLatestDefuzzifiedValue();
    }
    
        public double evaluar_disponsibilidad(double cantidad, double distancia, double presupuesto, double hora){
        this.fis_var.setVariable("cantidad", cantidad);
        this.fis_var.setVariable("distancia", distancia);
        this.fis_var.setVariable("presupuesto", presupuesto);
        this.fis_var.setVariable("hora", hora);
        
        this.fis_var.evaluate();
        
        return this.fis_var.getVariable("disponsibilidad").getLatestDefuzzifiedValue();
    }
    
    public String get_CD_emisiones(){
        String[] CD_salida_emisiones = {"bici_electrica", "coche_electrico", "bus", "moto", "coche_combustion"}; 
        
        String result_emisiones = "";
        
        //double output[] = new double[5]; // only for debug reasons
        double max = 0;
        int max_index = 0;

        
        for(int i = 0; i < CD_salida_emisiones.length; i++){
            //output[i] = this.fis_var.getVariable("emisiones").getMembership(CD_salida[i]);
            if(this.fis_var.getVariable("emisiones").getMembership(CD_salida_emisiones[i]) > 0){
                //old code:
                //result_emisiones += CD_salida[i] + ",";
                //System.out.println(this.fis_var.getVariable("emisiones").getMembership(CD_salida[i]));
                //System.out.println(output[i]);
                // get result with the highest degree of membership
                  if(max < this.fis_var.getVariable("emisiones").getMembership(CD_salida_emisiones[i]))
                  {
                     max = this.fis_var.getVariable("emisiones").getMembership(CD_salida_emisiones[i]);
                     max_index = i;
                  }
            }
        }
        result_emisiones = CD_salida_emisiones[max_index];
        //only for debug reasons:
        //System.out.println("Analysis:");
        //System.out.println("Highest value: " + max);
        //System.out.println("At CD Index no.: " + max_index);
        return result_emisiones;
    }
    
        public String get_CD_disponsibilidad(){
        String[] CD_salida_disponsibilidad = {"muy_poco", "poco", "media", "alto"}; 
        
        String result_disponsibilidad = "";
        
        //double output[] = new double[4]; // only for debug reasons
        double max = 0;
        int max_index = 0;

        
        for(int i = 0; i < CD_salida_disponsibilidad.length; i++){
            //output[i] = this.fis_var.getVariable("disponsibilidad").getMembership(CD_salida[i]);
            if(this.fis_var.getVariable("disponsibilidad").getMembership(CD_salida_disponsibilidad[i]) > 0){
                //old code:
                //result_emisiones += CD_salida[i] + ",";
                //System.out.println(this.fis_var.getVariable("emisiones").getMembership(CD_salida[i]));
                //System.out.println(output[i]);
                // get result with the highest degree of membership
                  if(max < this.fis_var.getVariable("disponsibilidad").getMembership(CD_salida_disponsibilidad[i]))
                  {
                     max = this.fis_var.getVariable("disponsibilidad").getMembership(CD_salida_disponsibilidad[i]);
                     max_index = i;
                  }
            }
        }
        result_disponsibilidad = CD_salida_disponsibilidad[max_index];
        //only for debug reasons:
        //System.out.println("Analysis:");
        //System.out.println("Highest value: " + max);
        //System.out.println("At CD Index no.: " + max_index);
        return result_disponsibilidad;
    }

    // DISPONSIBILIDAD
    //
    //
    
}
