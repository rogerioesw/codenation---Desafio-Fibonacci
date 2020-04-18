package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        String textoMinusculo = texto.toLowerCase();
        String textoCriptografado = "";

        List<Character> alfabeto = new ArrayList<Character>();
        List<Character> texto_c = new ArrayList<Character>();

        if(validaTexto(texto)) {

            for (char i = 'a'; i <= 'z'; i++) {
                alfabeto.add(i);
            }


            for (int i = 0; i < textoMinusculo.length(); i++) {
                texto_c.add(textoMinusculo.charAt(i));
            }

            char aux;
            int pos = 0;

            for (int i = 0; i < texto_c.size(); i++) {
                if (alfabeto.contains(texto_c.get(i))) {
                    pos = alfabeto.indexOf(texto_c.get(i));
                    pos = pos + 3;
                    aux = alfabeto.get(pos);
                    texto_c.remove(i);
                    texto_c.add(i, aux);
                }
            }
        }
        for(int i=0; i<texto_c.size(); i++) {
            textoCriptografado = textoCriptografado + texto_c.get(i);
        }
        //textoCriptografado = texto_c.toString();
        return textoCriptografado;
    }

    @Override
    public String descriptografar(String texto){
            String textoMinusculo = texto.toLowerCase();
            String textoDescriptografado = "";

            List<Character> alfabeto = new ArrayList<Character>();
            List<Character> texto_c = new ArrayList<Character>();

            if (validaTexto(texto)) {

                for (char i = 'a'; i <= 'z'; i++) {
                    alfabeto.add(i);
                }


                for (int i = 0; i < textoMinusculo.length(); i++) {
                    texto_c.add(textoMinusculo.charAt(i));
                }

                char aux;
                int pos = 0;

                for (int i = 0; i < texto_c.size(); i++) {
                    if (alfabeto.contains(texto_c.get(i))) {
                        pos = alfabeto.indexOf(texto_c.get(i));
                        pos = pos - 3;
                        aux = alfabeto.get(pos);
                        texto_c.remove(i);
                        texto_c.add(i, aux);
                    }
                }
            }
        for(int i=0; i<texto_c.size(); i++) {
            textoDescriptografado = textoDescriptografado + texto_c.get(i);
        }

        return textoDescriptografado;
    }

    public boolean validaTexto(String texto) {
        if(texto == "") {
            throw new IllegalArgumentException();
        }
        else if(texto == null) {
            throw new NullPointerException();
        }
        return true;
    }
}
