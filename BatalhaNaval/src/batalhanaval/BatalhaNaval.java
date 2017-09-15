/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

/**
 *
 * @author Rodrigo Braz Rodrigues
 */
public class BatalhaNaval {
    
    private static boolean FimJogo;
    public static boolean TurnoHumano;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TurnoHumano = true;
        FimJogo = false;
        
        System.out.println("----------------------------------------------------------");                
        System.out.println("\t\t\tBATALHA NAVAL");
        System.out.println("----------------------------------------------------------");
        
        Tabuleiro tPessoa = new Tabuleiro();
        tPessoa.PosicionarNavio();
        
        Tabuleiro tMaquina = new Tabuleiro();
        tMaquina.PosicionarNavioPC();
        
        System.out.println("--------------------------------------------------------------");                
        System.out.println("\t\t\tEfetue os disparos informando as coordenadas alvo [A1:E5");
        System.out.println("--------------------------------------------------------------");
        
        do{
            if(TurnoHumano){                   
                tPessoa.EfetuarDisparo(tMaquina.getNavios(), TurnoHumano);
                if(tPessoa.getAcertos() == 5){
                    System.out.println("VOCÊ VENCEU!");
                    FimJogo = true;
                }
                    
            }else{
                tMaquina.EfetuarDisparo(tPessoa.getNavios(), TurnoHumano);
                if(tMaquina.getAcertos() == 5){
                    System.out.println("VOCÊ PERDEU!");
                    FimJogo = true;
                }
            }
            TurnoHumano = !TurnoHumano;
        }while(!FimJogo);
    }
    
    
}
