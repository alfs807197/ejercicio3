import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class deck {

   public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[]arg) throws IOException{
     //   ArrayList<carta> listaDeck = new ArrayList<carta>();
        Carta dec[]=new Carta[52];
        Set <Carta> deck1 = new HashSet<Carta>(); //creacion de hashset de tamañño variable
        String [] palos={"Pica",  "Trebol","Diamante", "Corazon"};
        String [] colores={"Negro","Rojo"};
        String [] valores={"A", "2", "3", "4","5","6", "7","8","9","10","J","Q","K"};
        int sel;
        int ap=0;
        int p=0;
        int c=0;
        int v=0;
        boolean hacer=true;
        //se crea deck, todas las caertas y se guadan en un arreglo
        while(ap<dec.length){
            dec[ap]=new Carta(palos[p],colores[c], valores[v]);

            ap++;
            v++;
            if (v== valores.length){
                v=0;
                p++;
                if(p==2)
                    c++;
            }


        }
        while(hacer){
            System.out.println("Selecciona una acción");
            System.out.println("**MENU**\n1.shuffle\n2.head\n3.pick\n4.hand\n5.Salir");
            sel=Integer.parseInt(entrada.readLine());
            switch (sel){
                case 1:
                    shuffle(dec, (HashSet<Carta>) deck1);
                    break;
                case 2:
                    head(dec, (HashSet<Carta>) deck1);
                    break;
                case 3:
                    pick(dec,(HashSet<Carta>) deck1);
                    break;
                case 4:
                    hand(dec, (HashSet<Carta>) deck1);
                    break;
                case 5:
                    hacer=false;
                    break;
                default:
                    System.out.print("Opción invalida, vuelva a intentarlo");

            }
        }








    }//fin de main
    private static HashSet<Carta>hand(Carta[] dec, HashSet<Carta> deck1){
        int e = dec.length;
        for(int u=0;u<5;u++){
            int i=(int)Math.floor(Math.random()*(e+1));
            if(deck1.contains(dec[i])){
                dec[i].mostrarCartas();
                deck1.remove(dec[i]);
            }
            else u--;



        }
        System.out.println("Quedan "+deck1.size()+" cartas");

        return (HashSet<Carta>) deck1;
    }
    private static HashSet<Carta> pick(Carta [] dec, HashSet<Carta> deck1){
        int e = dec.length;
        int i=(int)Math.floor(Math.random()*(e+1));;
        dec[i].mostrarCartas();
        deck1.remove(dec[i]);
        System.out.println("Quedan "+deck1.size()+" cartas");


        return (HashSet<Carta>)deck1;
    }
    private static HashSet<Carta> head(Carta[] dec, HashSet<Carta> deck1) {
        int e=0;
        boolean h=true;
        while(h) {
            if(deck1.contains(dec[e])) {
                dec[e].mostrarCartas();//Saca la primera carta del deck
                deck1.remove(dec[e]);//retira la carta del deck
                System.out.println("Quedan " + deck1.size() + " cartas");
                return (HashSet<Carta>) deck1;
            }else e++;
        }
        return (HashSet<Carta>) deck1;
    }
    private static void despliega(Carta[] dec){
        System.out.println("comprobando deck");
        for(int i=0; i<dec.length;i++){
            dec[i].mostrarCartas();
        }

    }
    private static Carta [] shuffle(Carta[] dec, HashSet<Carta> deck1 ){
        for(int i=0; i<dec.length;i++){
            deck1.add(dec[i]);
        }
        int s=0;
        Iterator<Carta>itr=deck1.iterator();
        while(itr.hasNext()){
            Carta o= itr.next();
            dec[s]=o;
            s++;
        }
        System.out.println("Se mescló el Deck");


        return dec;
    }

     // Metodo para desordenar un arreglo
  /*  private static Carta [] barajear ( Carta [] dec){
        for(int i= dec.length-1;i>0; i--){
        //se creará un subindice para elejir un valor aleatorio
            int shuffled_index= (int)Math.floor(Math.random()*(i+1));
            //se respalda el dato en el arreglo
            Carta tmp= dec[i];
            //se utiliza el sub indice para para tomar un valor en otra posicion y se reemplaza por el respaldado
            dec [i]= dec[shuffled_index];
            //se intercambia en reemplazado en la posicion marcad por el subindice aleatorio
            dec [shuffled_index]=tmp;

        }
        return dec;
    }*/

}

