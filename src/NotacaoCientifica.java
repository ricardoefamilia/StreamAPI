import java.util.Scanner;

public class NotacaoCientifica {
    public static void main(String[] args) {
        //double numero = Math.random()*10;
        Scanner sc = new Scanner(System.in);
        double numero = sc.nextDouble();
        String numeroString = ""+numero;
        int aux, ponto, cont = 0;
        String expoente = "";
        String aux2="", aux3, decimal = "", nc = "";

        ponto = numeroString.indexOf(".");
        aux2 = numeroString.substring((ponto + 1),numeroString.length());
        aux = aux2.indexOf("E");
        if(aux != -1){
            if(aux < 5){
                expoente = aux2.substring((aux+1),aux2.length());
                if(numero>0) {
                    nc = "+" + numeroString.substring(0,ponto)+".";
                    aux2 = aux2.substring(0,aux);
                    if(expoente.length()>1){
                        if(expoente.substring(0,1).equals("-")){
                            nc += aux2+"000E"+expoente;
                        }else{
                            nc += aux2+"000E+"+expoente;
                        }
                    }else{
                        nc += aux2+"000E+0"+expoente;
                    }
                }else{
                    nc = numeroString.substring(0,ponto)+".";
                    if(Integer.parseInt(nc.substring(1,2))==0){
                        aux2 = aux2.substring(0,aux);
                        if(expoente.length()>1){
                            if(expoente.substring(0,1).equals("-")){
                                nc += aux2+"000E"+expoente;
                            }else{
                                nc += aux2+"000E+"+expoente;
                            }
                        }else{
                            nc += aux2+"000E-0"+expoente;
                        }
                    }else{
                        aux2 = aux2.substring(0,aux);
                        if(expoente.length()>1){
                            if(expoente.substring(0,1).equals("-")){
                                nc += aux2+"000E"+expoente;
                            }else{
                                nc += aux2+"000E+"+expoente;
                            }
                        }else{
                            nc += aux2+"000E+0"+expoente;
                        }
                    }
                }
            }else{
                if(numero>0) {
                    nc = "+" + numeroString.substring(0,ponto)+".";
                    if(aux2.length()>4){
                        aux = aux2.indexOf("E");
                        expoente = aux2.substring((aux+1),aux2.length());
                        if(aux != -1){
                            if(aux < 9){
                                nc += aux2.substring(0, 4) + "E+0" + expoente;
                            }else{
                                nc += aux2.substring(0, 4) + "E+" + expoente;
                            }
                        }else{
                            int u = Integer.parseInt(aux2.substring(4, 5));
                            int pu = Integer.parseInt(aux2.substring(3, 4));
                            if(u > 5){
                                pu++;
                                aux2 = aux2.substring(0,3)+pu;
                            }
                            nc += aux2.substring(0, 4) + "E+00";
                        }
                    }else{
                        aux = aux2.indexOf("E");
                        nc += aux2.substring(0, aux) + "E+0" + aux2.substring((aux2.length()-1), aux2.length());
                        nc = numeroString;
                    }
                }else {
                    nc = numeroString.substring(0,ponto)+".";
                    if(Integer.parseInt(nc.substring(1,2))==0){
                        if(aux2.length()>4){
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                if(aux < 9){
                                    nc += aux2.substring(0, 4) + "E-0" + aux2.substring((aux+1), (aux + 2));
                                }else{
                                    nc += aux2.substring(0, 4) + "E-"  +aux2.substring(aux, aux2.length());
                                }
                            }
                        }else{
                            nc += aux2.substring(0, 4) + "E-0" + aux2.substring((aux2.length()-1), aux2.length());
                            nc = numeroString;
                        }
                    }else {
                        if(aux2.length()>4){
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                if(aux < 9){
                                    nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux+1), (aux + 2));
                                }else{
                                    nc += aux2.substring(0, 4) + "E+"  +aux2.substring(aux, aux2.length());
                                }
                            }
                        }else{
                            nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux2.length()-1), aux2.length());
                            nc = numeroString;
                        }
                    }
                }
            }
        }else{
            if(numeroString.length()>6){
                if(numero>0) {
                    nc = "+" + numeroString.substring(0,ponto)+".";
                    if(aux2.length()>4){
                        aux = aux2.indexOf("E");
                        if(aux != -1){
                            if(aux < 9){
                                nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux+1), (aux + 2));
                            }else{
                                nc += aux2.substring(0, 4) + "E+" + aux2.substring(aux, aux2.length());
                            }
                        }else{
                            int u = Integer.parseInt(aux2.substring(4, 5));
                            int pu = Integer.parseInt(aux2.substring(3, 4));
                            if(u > 5){
                                pu++;
                            }
                            aux2 = aux2.substring(0,3)+pu;
                            nc += aux2.substring(0, 4) + "E+00";
                        }
                    }else{
                        aux = aux2.indexOf("E");
                        if(aux != -1){
                            nc += aux2.substring(0, aux) + "E+0" + aux2.substring((aux2.length()-1), aux2.length());
                        }else{
                            nc = numeroString;
                        }
                    }
                }else {
                    nc = numeroString.substring(0,ponto)+".";
                    if(nc.equals("-0.")){
                        if(aux2.length()>4){
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                if(aux < 9){
                                    nc += aux2.substring(0, 4) + "E-0" + aux2.substring((aux+1), (aux + 2));
                                }else{
                                    nc += aux2.substring(0, 4) + "E-"  +aux2.substring(aux, aux2.length());
                                }
                            }else{
                                int u = Integer.parseInt(aux2.substring(4, 5));
                                int pu = Integer.parseInt(aux2.substring(3, 4));
                                if(u > 5){
                                    pu++;
                                }
                                aux2 = aux2.substring(0,3)+pu;
                                nc += aux2.substring(0, 4) + "E-00";
                            }
                        }else{
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux2.length()-1), aux2.length());
                            }else{
                                nc = numeroString;
                            }
                        }
                    }else{
                        if(aux2.length()>4){
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                if(aux < 9){
                                    nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux+1), (aux + 2));
                                }else{
                                    nc += aux2.substring(0, 4) + "E+"  +aux2.substring(aux, aux2.length());
                                }
                            }else{
                                int u = Integer.parseInt(aux2.substring(4, 5));
                                int pu = Integer.parseInt(aux2.substring(3, 4));
                                if(u > 5){
                                    pu++;
                                }
                                aux2 = aux2.substring(0,3)+pu;
                                nc += aux2.substring(0, 4) + "E+00";
                            }
                        }else{
                            aux = aux2.indexOf("E");
                            if(aux != -1){
                                nc += aux2.substring(0, 4) + "E+0" + aux2.substring((aux2.length()-1), aux2.length());
                            }else{
                                nc = numeroString;
                            }
                        }
                    }
                }
            }else{
                nc = numeroString;
            }
        }
    System.out.println(nc);
    }
}
