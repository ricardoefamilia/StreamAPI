import java.util.Scanner;

public class NotacaoCientifica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Double numero = sc.nextDouble();
            //System.out.println(numero);
            String numString = ""+numero;
            int virgula = numString.indexOf(".");
            String mantissa = numString.substring(0,virgula);
            String sinalMantissa = mantissa.substring(0,1);
            String corpo = numString.substring(virgula+1);
            String nc = "";
            int E = corpo.indexOf("E");

            if(E != -1) {
                String Efinal = corpo.substring(E);
                String sinalE = Efinal.substring(1,2);
                int semE = Integer.parseInt(Efinal.substring(1));
                if(semE > 110) {
                    System.out.println("*** Número inteiro acima de 110 caracteres ***");
                    return;
                }
                String corpoSemE = corpo.substring(0,E);
                if(semE < 10) {
                    if(sinalE.charAt(0)=='-') {
                        semE = Integer.parseInt(Efinal.substring(2));
                        if(Efinal.length()>1) {
                            Efinal = "E-"+semE;
                        }else {
                            Efinal = "E-0"+semE;
                        }

                    }else {
                        if(Efinal.length()>1) {
                            Efinal = "E+"+semE;
                        }else {
                            Efinal = "E+0"+semE;
                        }
                    }

                }else {
                    if(sinalE.charAt(0)=='-') {
                        Efinal = "E-"+semE;
                    }else {
                        Efinal = "E+"+semE;
                    }
                }
                int tamanhoCorpo = corpoSemE.length();
                if(tamanhoCorpo > 4) {
                    String quatro = corpo.substring(0,3);
                    int quarto = Integer.parseInt(corpo.substring(3,4));
                    int quinto = Integer.parseInt(corpo.substring(4,5));
                    if(quinto >= 5) {
                        quarto++;
                    }
                    corpo = quatro+quarto+Efinal;
                }else {
                    switch(tamanhoCorpo) {
                        case 1: corpo = corpoSemE+"000"+Efinal; break;
                        case 2: corpo = corpoSemE+"00"+Efinal; break;
                        case 3: corpo = corpoSemE+"0"+Efinal; break;
                        case 4: corpo = corpoSemE+Efinal; break;
                    }
                }
            }else {
                int tamanhoCorpo = corpo.length();
                String semSinalMantissa = mantissa.substring(0,1);
                if(sinalMantissa.charAt(0)=='-') {
                    semSinalMantissa = mantissa.substring(1);
                }else {
                    semSinalMantissa = mantissa.substring(0);
                }
                if(semSinalMantissa.charAt(0)=='0') {
                    int zeros = 0;
                    int outros = 0;
                    for(int x=0; x < tamanhoCorpo; x++) {
                        if(corpo.charAt(x)=='0') {
                            zeros++;
                        }else {
                            outros++;
                            break;
                        }
                    }
                    if(zeros > 0 && outros > 0){
                        corpo = corpo.substring(zeros);
                    }else if(zeros == 1 && outros == 0) {
                        corpo = "0000E+00";
                        if(sinalMantissa.charAt(0)!='-') {
                            nc = "+"+mantissa+"."+corpo;
                        }else {
                            nc = mantissa+"."+corpo;
                        }
                        System.out.println(nc);
                        System.exit(0);
                    }
                    if(sinalMantissa.charAt(0)=='-') {
                        mantissa = sinalMantissa+corpo.substring(0,1);
                    }else {
                        mantissa = corpo.substring(0,1);
                    }
                    corpo = corpo.substring(1);
                    tamanhoCorpo = corpo.length();
                    if(tamanhoCorpo > 4) {
                        String quatro = corpo.substring(0,3);
                        int quarto = Integer.parseInt(corpo.substring(3,4));
                        int quinto = Integer.parseInt(corpo.substring(4,5));
                        if(quinto >= 5) {
                            quarto++;
                        }
                        //corpo = quatro+quarto;
                        if(zeros < 9) {
                            corpo += "E-0"+(zeros+1);
                        }else{
                            corpo += "E-"+(zeros+1);
                        }

                    }else {
                        switch(tamanhoCorpo) {
                            case 1: corpo += "000E-0"+(zeros+1); break;
                            case 2: corpo += "00E-0"+(zeros+1); break;
                            case 3: corpo += "0E-0"+(zeros+1); break;
                            case 4: corpo += "E-0"+(zeros+1); break;
                        }
                    }
                }else {
                    if(tamanhoCorpo > 4) {
                        int quatro = Integer.parseInt(corpo.substring(0,4));
                        int quinto = Integer.parseInt(corpo.substring(4,5));
                        if(quinto >= 5) {
                            quatro++;
                        }
                        corpo = ""+quatro+"E+00";
                    }else {
                        switch(tamanhoCorpo) {
                            case 1: corpo += "000"; break;
                            case 2: corpo += "00"; break;
                            case 3: corpo += "0"; break;
                        }
                    }
                }
            }
            if(corpo.equals("0000")) {
                if(sinalMantissa.charAt(0)=='-') {
                    if(mantissa.length() > 2) {
                        corpo = mantissa.substring(2);
                        mantissa = mantissa.substring(0,2);
                        if(corpo.length()>4) {
                            String quatro = corpo.substring(0,3);
                            int quarto = Integer.parseInt(corpo.substring(3,4));
                            int quinto = Integer.parseInt(corpo.substring(4,5));
                            if(quinto >= 5) {
                                quarto++;
                            }
                            corpo = quatro+quarto+"E+04";
                        }else {
                            int aux = corpo.length();
                            switch(aux) {
                                case 1: corpo += "000E+01"; break;
                                case 2: corpo += "00E+02"; break;
                                case 3: corpo += "0E+03"; break;
                                case 4: corpo += "E+04"; break;
                            }
                        }
                    }else {
                        corpo += "E+00";
                    }
                }else {
                    if(mantissa.length() > 1) {
                        corpo = mantissa.substring(1);
                        mantissa = mantissa.substring(0,1);
                        if(corpo.length()>4) {
                            String quatro = corpo.substring(0,3);
                            int quarto = Integer.parseInt(corpo.substring(3,4));
                            int quinto = Integer.parseInt(corpo.substring(4,5));
                            if(quinto >= 5) {
                                quarto++;
                            }
                            corpo = quatro+quarto+"E+04";
                        }else {
                            int aux = corpo.length();
                            switch(aux) {
                                case 1: corpo += "000E+01"; break;
                                case 2: corpo += "00E+02"; break;
                                case 3: corpo += "0E+03"; break;
                                case 4: corpo += "E+04"; break;
                            }
                        }
                    }else {
                        corpo += "E+00";
                    }
                }
            }
            if(sinalMantissa.charAt(0)!='-') {
                nc = "+"+mantissa+"."+corpo;
            }else {
                nc = mantissa+"."+corpo;
            }

            System.out.println(nc);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
