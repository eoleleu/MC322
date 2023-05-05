public class Validacao {

    static boolean valinarNOMEcliente(String nome){
        for(int i=0;i<nome.length();i++){
            char c = nome.charAt(i);
            if(Character.isLetter(c) || c == ' '){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    //O método validarCPF verifica se todos os dígitos são semelhantes, além
    // disso, calcular se o CPF de fato é válido calculando os dígitos finais.
    // Como também retira do CPF tudo aquilo que não for número.
    static boolean validarCPF(String cpf){
        int cont=10, soma=0, verificador =1, num,tamanhoCPF=0,cont_num_iguais=0;

        cpf = cpf.replaceAll("[^0-9]", "");

        for (int i=0;i<cpf.length();i++){
            tamanhoCPF = tamanhoCPF +1;
            if (cpf.charAt(i) == cpf.charAt(0)){
                cont_num_iguais+=1;
            }
        }
        if (tamanhoCPF ==11){
            for (int i=0;i<9;i++){
                num = Character.getNumericValue(cpf.charAt(i));
                soma = soma + num*cont;
                cont-=1;
            }
            int resto = soma%11;
            int digito = 11 - resto;

            if (resto < 2){
                if (cpf.charAt(9)!='0')
                    verificador =0;
            } else{
                if (digito != Character.getNumericValue(cpf.charAt(9))){
                    verificador =0;
                }

            }
            cont =11;
            soma =0;
            for (int i=0;i<10;i++){
                num = Character.getNumericValue(cpf.charAt(i));
                soma = soma + num*cont;
                cont-=1;
            }
            resto = soma%11;
            digito = 11-resto;
            if (resto<2){
                if (cpf.charAt(10)!='0'){
                    verificador=0;
                }
            } else {
                if (digito != Character.getNumericValue(cpf.charAt(10))){
                    verificador =0;
                }
            }
        } else {
            verificador =0;
        }

        if(verificador==1 && cont_num_iguais!= 11){
            return true;
        } else {
            return false;
        }


    }

    // Retira todos os caracteres que não são números do CNPJ e faz todos os cálculos para verificar se ele é válido
    static boolean validarCNPJ(String cnpj){
        int verificador=1;
        int[] NumerosVeriicadores = {5,4,3,2,9,8,7,6,5,4,3,2};
        cnpj = cnpj.replaceAll("[^0-9]", "");

        int soma=0, tamanhoCNPJ=0, num;
        for(int i=0;i<cnpj.length();i++){
            tamanhoCNPJ+=1;

        }

        if(tamanhoCNPJ==14){
            for(int i=0;i<NumerosVeriicadores.length;i++){
                num = Character.getNumericValue(cnpj.charAt(i));

                soma = soma + num*NumerosVeriicadores[i];
            }
            int resto = soma%11;
            int digito = 11-resto;

            if(resto <2){
                if(cnpj.charAt(12)!='0'){
                    verificador =0;
                }
            } else{
                if(digito != Character.getNumericValue(cnpj.charAt(12))){
                    verificador=0;
                }
            }
            int[] NumerosVerificadores2= {6,5,4,3,2,9,8,7,6,5,4,3,2};
            soma =0;
            for(int i=0;i<NumerosVerificadores2.length;i++){
                num = Character.getNumericValue(cnpj.charAt(i));
                soma = soma + num*NumerosVerificadores2[i];
            }
            resto = soma%11;
            digito = 11-resto;
            if(resto<2){
                if(cnpj.charAt(13)!=0){
                    verificador=0;
                }
            } else {
                if(digito != Character.getNumericValue(cnpj.charAt(13))){
                    verificador=0;
                }
            }

        } else {
            verificador=0;
        }


        if(verificador==1){
            return true;
        } else {
            return false;
        }


    }

}
