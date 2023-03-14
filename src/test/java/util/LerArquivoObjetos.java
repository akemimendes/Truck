package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static util.Variaveis.nomepc;

public class LerArquivoObjetos {
    private List<Variaveis> listaPessoa;

    public Variaveis lerArquivoNr(String nrlinha) throws IOException {

        Variaveis v = new Variaveis();
        File file = new File("/home/" + nomepc + "/Truck/arquivos/" + nrlinha);
        System.out.println(file);
        if (file.exists()) {
            Scanner ler = new Scanner("/home/" + nomepc + "/Truck/arquivos/" + nrlinha);
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            v.setNome("jose maria");
            v.setEmail(lerArq.readLine());
            v.setCelular(lerArq.readLine());
            v.setEstado(lerArq.readLine());
            v.setTipoVeiculo(lerArq.readLine());
            v.setMarcaVeiculo(lerArq.readLine());
            v.setAnoVeiculo(lerArq.readLine());
            v.setModelo(lerArq.readLine());
            v.setPlaca(lerArq.readLine());
            v.setCpf(lerArq.readLine());
            v.setCepper(lerArq.readLine());
            v.setSobrenome(lerArq.readLine());
            v.setDatacond(lerArq.readLine());
            v.setEstado_civ(lerArq.readLine());
            v.setSexo_condu(lerArq.readLine());
            v.setFranquia(lerArq.readLine());
            v.setAno_modelo(lerArq.readLine());
            v.setZero(lerArq.readLine());
            v.setBonus(lerArq.readLine());
            v.setCidade(lerArq.readLine());




        }
        return v;


    }
}
