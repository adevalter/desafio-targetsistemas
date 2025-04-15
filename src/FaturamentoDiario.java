import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import Model.FaturamentoDiarioModel;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDiario {

    public static void LerRegistro() {

        try {
            InputStream inputStream = FaturamentoDiario.class.getResourceAsStream("/dados.xml");

            if (inputStream == null) {
                System.out.println("Arquivo não encontrado!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            document.getDocumentElement().normalize();

            List<FaturamentoDiarioModel> faturamento = new ArrayList<FaturamentoDiarioModel>();

            NodeList nodeList = document.getElementsByTagName("row");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int dia = Integer.parseInt(element.getElementsByTagName("dia").item(0).getTextContent());
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                    FaturamentoDiarioModel faturamentoDiario = new FaturamentoDiarioModel();
                    faturamentoDiario.setValor(dia);
                    faturamentoDiario.setValor(valor);

                    faturamento.add(faturamentoDiario);
                }
            }

            // Cálculos
            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            for (FaturamentoDiarioModel dia : faturamento) {
                if (dia.getValor() > 0) {
                    if (dia.getValor() < menorFaturamento) {
                        menorFaturamento = dia.getValor();
                    }
                    if (dia.getValor() > maiorFaturamento) {
                        maiorFaturamento = dia.getValor();
                    }
                    somaFaturamento += dia.getValor();
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (FaturamentoDiarioModel dia : faturamento) {
                if (dia.getValor() > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias acima da média mensal: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}