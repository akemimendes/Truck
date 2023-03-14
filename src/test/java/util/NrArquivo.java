package util;

import java.io.File;
import java.util.ArrayList;

import static util.Variaveis.nomepc;

public class NrArquivo {
    public ArrayList<String> carregarArquivos() {
        ArrayList<String> listaNrlinha = new ArrayList<String>();

        File[] files = new File("/home/" + nomepc + "/Truck/arquivos/").listFiles();
        try {
            for (File file : files) {
                listaNrlinha.add(file.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaNrlinha;
    }

    public void deleteArquivo(String nrtxt) {
        File file = new File("/home/robertinho/Truck/arquivos/" + nrtxt);

        if (file.exists() && file.isFile()) {
            boolean i = true;
            while (i) {
                if (file.delete()) {
                    i = false;
                } else {
                    System.gc();
                }
            }


        }

    }
}
