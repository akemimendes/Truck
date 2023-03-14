package test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.*;
import org.sikuli.script.Pattern;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;

import static com.google.common.base.Predicates.and;
import static java.lang.Thread.sleep;

public class TruckPrincipal {
    @Test
    public void iniciarSiteTruck()throws IOException, InterruptedException{
        WebDriver navegador = null;
        ArrayList<String> listaNr = null;
        WebDriverWait wait = null;

        System.out.println("Iniciando");
        NrArquivo nrlinha = new NrArquivo();
        LerArquivoObjetos arquivo = new LerArquivoObjetos();
        Distribuir distribuir = new Distribuir();
        distribuir.distribuirArquivos();

        int temArq = 999;
        while (temArq == 999) {
            listaNr = nrlinha.carregarArquivos();
            if (listaNr.size() == 0) {
                JOptionPane.showMessageDialog(null, "Acabou");
            } else {
                Variaveis v = arquivo.lerArquivoNr(listaNr.get(0));
                try {
                    navegador = Navegador.retornarNavegador();
                    wait = new WebDriverWait(navegador, Duration.ofSeconds(5));
                    sleep(1000);
                    System.out.println("preencher dados");
                    //Preechendo Dados
                    navegador.findElement(By.id("pwrAssocNm")).sendKeys(v.getNome());
                    sleep(2000);
                    navegador.findElement(By.id("pwrAssocEml")).sendKeys(v.getEmail());
                    sleep(2000);
                    navegador.findElement(By.id("pwrAssocPhn")).sendKeys(v.getCelular());
                    sleep(2000);
                    //Estado/Cidade
                    if (v.getEstado().contains("São Paulo")) {
                        //Estado
                        navegador.findElement(By.id("pwrStt")).click();
                        navegador.findElement(By.id("pwrStt")).sendKeys("s");
                        sleep(1000);
                        navegador.findElement(By.id("pwrStt")).sendKeys("s");
                        sleep(1000);

                        navegador.findElement(By.id("pwrStt")).sendKeys("s");
                        sleep(1000);
                        navegador.findElement(By.id("pwrStt")).sendKeys(Keys.ENTER);
                        sleep(2000);
                        //Cidade
                        navegador.findElement(By.id("pwrCty")).click();
                        sleep(2000);
                        navegador.findElement(By.id("pwrCty")).sendKeys("São");
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ENTER);

                    }
                    else if (v.getEstado().contains("Rio de Janeiro")) {
                        //Estado
                        navegador.findElement(By.id("pwrStt")).click();
                        navegador.findElement(By.id("pwrStt")).sendKeys("r");
                        sleep(2000);
                        //Cidade
                        navegador.findElement(By.id("pwrCty")).click();
                        sleep(1000);
                        navegador.findElement(By.id("pwrCty")).sendKeys("Rio");
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        sleep(500);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ENTER);

                    }
                    else if (v.getEstado().contains("Minas Gerais")) {
                        //Estado
                        navegador.findElement(By.id("pwrStt")).click();
                        navegador.findElement(By.id("pwrStt")).sendKeys("m");
                        navegador.findElement(By.id("pwrStt")).sendKeys("m");
                        sleep(2000);
                        //Cidade
                        navegador.findElement(By.id("pwrCty")).click();
                        sleep(2000);
                        navegador.findElement(By.id("pwrCty")).sendKeys("Belo");
                        sleep(1500);
                        navegador.findElement(By.id("pwrCty")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    //Tipo do Veiculo
                    if (v.getTipoVeiculo().contains("carro")){
                        navegador.findElement(By.id("pwrVhclTp")).click();
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }

                    else if (v.getTipoVeiculo().contains("moto")){
                        navegador.findElement(By.id("pwrVhclTp")).click();
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    else if (v.getTipoVeiculo().contains("caminhao")){
                        navegador.findElement(By.id("pwrVhclTp")).click();
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ARROW_DOWN);
                        navegador.findElement(By.id("pwrVhclTp")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    //Marca

                    if (v.getMarcaVeiculo().contains("GM")){
                        navegador.findElement(By.id("pwrVhclBrnd")).click();
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys("gm");
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    else if (v.getMarcaVeiculo().contains("VW")){
                        navegador.findElement(By.id("pwrVhclBrnd")).click();
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys("vw");
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    else if (v.getMarcaVeiculo().contains("FORD")){
                        navegador.findElement(By.id("pwrVhclBrnd")).click();
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys("ford");
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    else if (v.getMarcaVeiculo().contains("RENAULT")){
                        navegador.findElement(By.id("pwrVhclBrnd")).click();
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys("RENAULT");
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    else if (v.getMarcaVeiculo().contains("HYUNDAI")){
                        navegador.findElement(By.id("pwrVhclBrnd")).click();
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys("HYUNDAI");
                        sleep(1000);
                        navegador.findElement(By.id("pwrVhclBrnd")).sendKeys(Keys.ENTER);
                        sleep(2000);
                    }
                    //Versão
                    navegador.findElement(By.id("pwrVhclVrsn")).click();
                    navegador.findElement(By.id("pwrVhclVrsn")).sendKeys(v.getAnoVeiculo());
                    sleep(1000);
                    navegador.findElement(By.id("pwrVhclVrsn")).sendKeys(Keys.ENTER);
                    sleep(2000);
                    //Modelo
                    navegador.findElement(By.id("pwrVhclMdl")).click();
                    sleep(1000);
                    navegador.findElement(By.id("pwrVhclMdl")).sendKeys(v.getModelo());
                    sleep(500);
                    navegador.findElement(By.id("pwrVhclMdl")).sendKeys(Keys.ENTER);
                    sleep(1000);
                    //Placa do carro
                    navegador.findElement(By.id("pwrVhclPlts")).click();
                    sleep(1000);
                    navegador.findElement(By.id("pwrVhclPlts")).sendKeys(v.getPlaca());
                    //Botão FINAL
                    navegador.findElement(By.id("pwrActnSnd")).click();
                    sleep(5000);
                    //HORA DO PRINT
                    Robot r = new Robot();

                    r.keyPress(KeyEvent.VK_CONTROL);
                    r.keyPress(KeyEvent.VK_P);
                    r.keyRelease(KeyEvent.VK_P);
                    r.keyRelease(KeyEvent.VK_CONTROL);
                    sleep(2000);
                    System.out.println("vai imprimir");


                    Pattern salvarpdf = new Pattern("/home/robertinho/Truck/images/SalvarBotao.png");
                    Pattern salvarLinux=new Pattern("/home/robertinho/Truck/images/salvarbtnlinux.png");

                    System.out.println("carregou imagens");


                    System.out.println("vai clicar");
                    Screen screen = new Screen();
                    int teste = 0;
                    while (teste == 0) {
                        try {
                            screen.click(salvarpdf);
                            teste = 999;
                        } catch (Exception e) {
                            System.out.println("esperando imagem para imprimir");
                        }
                    }

                    Thread.sleep(2000);
                    String nome= listaNr.get(0);
                    String nomearq=nome.replace(".TXT","");
                    screen.type("/home/robertinho/Truck/pdf/" +nomearq);
                    Thread.sleep(1000);
                    screen.click(salvarLinux);

                    Thread.sleep(2000);
                    int x = 0;
                    while (x <= 3) {
                        screen.type(Key.ESC);
                        x++;
                    }

                    //mover para prontos


                    File filearquivo = new File( "/home/robertinho/Truck/arquivos/" + nomearq+".TXT" );
                    File filepdf = new File( "/home/robertinho/Truck/pdf/" + nomearq+".pdf" );
                    System.out.println( filepdf );

                    if (filepdf.exists() && filepdf.isFile()) {
                        filearquivo.renameTo( new File( "/home/robertinho/Truck/prontos/" + nomearq+".TXT" ) );
                        filearquivo.delete();


                    }


                } catch (Exception e) {
                    String nomeComputador = System.getProperty("user.name");
                    File file = new File("/home/robertinho/Truck/arquivos/" +  listaNr.get(0));
                    FileWriter arq = new FileWriter("/home/" + nomeComputador + "/Truck/erro/" +  listaNr.get(0));
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.println("erro em alguma coisa");
                    gravarArq.flush();
                    gravarArq.close();

                    File fileerro = new File("/home/" + nomeComputador + "/Truck/erro/" +  listaNr.get(0));
                    File filearquivo = new File("/home/" + nomeComputador + "/Truck/arquivos/" +  listaNr.get(0));

                    if (fileerro.exists() && fileerro.isFile()) {
                    filearquivo.delete();
                    }
                }finally {
                    navegador.close();
                }
            }
        }
    }
}

