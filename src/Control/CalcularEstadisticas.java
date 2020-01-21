/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.TicketDAO;
import DAO.VueloDAO;
import Entidad.Reserva;
import Entidad.Ticket;
import Entidad.Vuelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lucas
 */
public class CalcularEstadisticas {
    
    
    VueloDAO vDao = new VueloDAO();
    TicketDAO tckdao = new TicketDAO();
   
    
    public String trayectoMasVendido(){
        List<Ticket> tckList = null;
        if(tckdao.leerallcount() != 0){
            tckList = tckdao.leeralltolist();
        } else {
            return "No hay datos";
        }
        
        List<Vuelo> vuelos = new ArrayList<Vuelo>();
        for(Ticket t : tckList){
        }
        for(Ticket t : tckList){
            t.getReserva().getVueloIda().setSillasTotales(t.getReserva().getNumeroPuestos());
            vuelos.add(t.getReserva().getVueloIda());
            if(t.getReserva().isIdaVuelta()){
                t.getReserva().getVueloVuelta().setSillasTotales(t.getReserva().getNumeroPuestosVuelta());
                vuelos.add(t.getReserva().getVueloVuelta());
            }
        }

        List<Vuelo> uniques = new ArrayList<Vuelo>();
        
        for (Vuelo v : vuelos) {
            if(v.getId() != -1){
                Vuelo h = new Vuelo();
                h.setSillasTotales(0);
                h.setOrigen(v.getOrigen());
                h.setDestino(v.getDestino());
                uniques.add(h);
                for(Vuelo f: vuelos){
                    if(v.getOrigen().equals(f.getOrigen()) && v.getDestino().equals(f.getDestino()) && f.getId() != -2){
                        f.setId(-1);
                    }
                }
            }
        }    
                
        for (Vuelo v : uniques){
            for(Vuelo r : vuelos){
                if(r.getOrigen().equals(v.getOrigen()) && r.getDestino().equals(v.getDestino())){
                    v.setSillasTotales(v.getSillasTotales() + r.getSillasTotales());
                }
            }
        }
        System.out.println("-------");
        System.out.println("VUELOS PAGADOS POR NÚMERO DE ASIENTOS");
        for(Vuelo v : uniques){
            System.out.println("");
            System.out.println("Vuelo: "+v.getOrigen()+"-"+v.getDestino()+" = "+v.getSillasTotales()+" asientos vendidos");
        }
        System.out.println("-------");
        Vuelo ans = calcularMayor(uniques);
        return ans.getOrigen()+"-"+ans.getDestino()+" ("+ans.getSillasTotales()+" puestos)";
    }
    
    public int calcularVentas(Vuelo v){
        int ventas = v.getSillasTotales() - v.getSillasDisponibles().length;
        return ventas;
    }
        
    public Vuelo calcularMayor(List<Vuelo> arr){
        Vuelo max = new Vuelo();
        max.setOrigen("Bad");
        max.setDestino("Plane");
        max.setSillasTotales(0);
        for(Vuelo v : arr){
            if(v.getSillasTotales() > max.getSillasTotales()){
                max = v;
            }
        }
        return max;
    }
    
    public void fechaMasVendida(){
        
    }
    
    
    
    
    
}
