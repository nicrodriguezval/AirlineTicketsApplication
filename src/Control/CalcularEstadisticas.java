/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.VueloDAO;
import Entidad.Vuelo;
import java.util.List;
/**
 *
 * @author lucas
 */
public class CalcularEstadisticas {
    
    
    VueloDAO vDao = new VueloDAO();
    
   
    
    public String trayectoMasVendido(){
        String tr = null;
        List<String> vList = vDao.trayectotolist();
        int i = 0;
        
        int ventas = 0;
        int[] indx = new int[vList.size()];
        List<Vuelo> trayecto;
        for (String string : vList) {
            trayecto = vDao.vuelosTrayecto(string);
            for (Vuelo vuelo : trayecto) {
                ventas += calcularVentas(vuelo);
            }
            indx[i] = ventas;
            i++;
            ventas = 0;
            trayecto.clear();
        }
        tr = vList.get(calcularMayor(indx));
        return tr;
    }
    
    public int calcularVentas(Vuelo v){
        int ventas = v.getSillasTotales() - v.getSillasDisponibles().length;
        return ventas;
    }
    
    public int calcularMayor(int[] arr){
        int i=0;
        int max = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]>max){
                max=arr[j];
                i=j;
            }
        }
        return i;
    }
    
    public void fechaMasVendida(){
        
    }
    
    
    
    
    
}
