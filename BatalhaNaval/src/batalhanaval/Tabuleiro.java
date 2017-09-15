package batalhanaval;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Rodrigo Braz - ADS/Noite
 * */
public class Tabuleiro {
   private static int Esquadra = 5;
   private String[] Navios = new String[Esquadra];
   private String[] InimigoAbatido = new String[Esquadra];
   int Acertos = 0;

    public int getAcertos() {
        return Acertos;
    }

    public String[] getNavios() {
        return Navios;
    }
   
   private static String[] Posicoes = {
        "A1","A2","A3","A4","A5",
        "B1","B2","B3","B4","B5",
        "C1","C2","C3","C4","C5",
        "D1","D2","D3","D4","D5",
        "E1","E2","E3","E4","E5"
   };  
   
   public void PosicionarNavioPC(){
       SortearPosicoes();
       System.out.println("Os návios do pc estão posicionados");
   }
   
   public void PosicionarNavio(){
       Scanner sc = new Scanner(System.in);
       String posicao;
       
       for (int i = 0; i < Esquadra; i++) {
           int nomeNavio = i+1;
           
           do{
                System.out.println("Inserindo o navio[" + nomeNavio + "] entre nas posições[A1:E5]");
                posicao = sc.next();
           }while (!ValidarPosicao(posicao.toUpperCase(), true, Navios));
           
           Navios[0] = posicao.toUpperCase();
       }
       System.out.println("Seus návios estão posicionados");
   }
   
   public static boolean ValidarPosicao(String posicao, boolean ehHumano, String[] navios){
       
        for(String i : navios){
            if(i != null && i.equals(posicao)){
                
                if(ehHumano)
                    System.out.println("[!] -> JÁ EXISTE UM NAVIO NA POSIÇÃO " + posicao);
                
                return false;
            }
        }
              
       for(String j : Posicoes){
           if(j.equals(posicao)){
               return true;
           }
       }
       
       if(ehHumano){
            System.out.println("[!] -> POSICIONAMENTO INVÁLIDO");
            System.out.println("----------------------------------------------------------");
       }
       return false;
   }
   
   public static boolean ValidarPosicao(String posicao){
       for(String j : Posicoes){
           if(j.equals(posicao)){
               return true;
           }
       }
       System.out.println("[!] -> POSICIONAMENTO INVÁLIDO, PERDEU A VEZ");
       return false;
   }
   
   private void SortearPosicoes() {
       Random random = new Random();
       int navioPosicionado = 0;
       
       do{
           int i = random.nextInt(Posicoes.length);
           if(ValidarPosicao(Posicoes[i], false, Navios)){
               Navios[navioPosicionado] = Posicoes[i];
               navioPosicionado++;
           }
       }while(navioPosicionado != Esquadra);
    }
   
   private String SortearPosicoesPc() {
       Random random = new Random();
       int i = random.nextInt(Posicoes.length);
       return Posicoes[i];
   }
   
   public boolean EfetuarDisparo(String[] navios, boolean turnoHumano){
      
       Scanner sc = new Scanner(System.in);
      String posicao;
      
      if(turnoHumano){
        System.out.println("Coordenada do disparo[A1:E5]:");
        posicao = sc.next();
      }else{
          posicao = SortearPosicoesPc();
      }
      

      if(ValidarPosicao(posicao.toUpperCase())){
        for(String i : navios){
            if(i != null && i.equals(posicao.toUpperCase())){
                
                if(turnoHumano){
                    System.out.println("Navio inimigo atingido");
                }else{
                    System.out.println("Um de seus navios foi atingido");
                }
                
                if(AbaterInimigo(posicao.toUpperCase())){        
                    Acertos++;
                }

                return true;
            }
        }
      }
      
      if(turnoHumano){
        System.out.println("Você errou");
      }else{
        System.out.println("Ufa, seu inimigo errou");
      }
      return false;
   }
   
   public boolean AbaterInimigo(String posicao){
       boolean retorno = true;
       for (int i = 0; i < Acertos; i++) {

           if(Acertos==0){
               retorno = true;
               break;
           }
           if(InimigoAbatido[i].equals(posicao)){
               retorno = false;
           }
       }
       
       if(retorno){
            InimigoAbatido[Acertos] = posicao.toUpperCase();
       }
       
       return retorno;
   }
   
   
}
