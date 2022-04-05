import java.util.Scanner;

public class NotacaoCientificaString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos, qtdCaracteres, qtdDecimais;
        String mantissa, corpo, nc;
        String numero = sc.next();
        qtdCaracteres = numero.length();
        if(qtdCaracteres > 110){
            pos = numero.indexOf(",");
            qtdDecimais = Integer.parseInt(numero.substring(pos,numero.length()));
            if(qtdDecimais <= 6){
                if(numero.substring(0,1).equals("-")){//números negativos
                    mantissa = numero.substring(0,2) + ",";
                    corpo = numero.substring(2,pos);
                    if(mantissa.equals("-0,")){

                    }else{

                    }
                    if(corpo.length() > 4){
                       corpo = corpo.substring(0,4)+"E";
                       if(pos != -1){

                       }else{

                       }
                    }else{
                        if(pos != -1){

                        }else{

                        }
                        nc = mantissa + corpo;
                    }

                }else{ //números positivos
                    mantissa = numero.substring(0,1) + ",";
                    corpo = numero.substring(1,pos);
                    if(corpo.length() > 4){
                        corpo = corpo.substring(0,4)+"E+";
                        if(pos != -1){

                        }else{

                        }
                    }else{
                        if(pos != -1){

                        }else{

                        }
                        nc = mantissa + corpo;
                    }
                }
            }else{
                System.out.println("Número de casas decimais acima de 6.");
            }
        }else{
            System.out.println("Número com caracteres acima de 110.");
        }
    }
}
