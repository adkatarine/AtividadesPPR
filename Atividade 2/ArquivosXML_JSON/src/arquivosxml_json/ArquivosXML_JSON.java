/*
 * Parser XML e escrita de arquivo no formato json. Você deve construir um parser para extrair objetos espaciais do arquivo 
 * XML(FeiraDeSantana.OSM) obtido através do OpenStreetMap. Todos os objetos devem ter uma categoria (amenity), um nome (você deve ignorar 
 * os estabelecimentos que não possuem nome) e uma localização (latitude, longitude). Os objetos obtidos devem ser armazenados em um arquivo 
 * JSON (clique aqui para obter um exemplo do JSON a ser produzido). Para checar se o JSON produzido é válido, utilize o JSONLint.
 */
package arquivosxml_json;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Adlla Katarine
 */
public class ArquivosXML_JSON {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        //Objetos para construir e fazer a leitura do documento
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse("src"); // Faz o parser de um documento xml
        Json json = new Json();
        String nome = null;
        String estabelecimento = null;
        
        NodeList listaEstabelecimentos = document.getElementsByTagName("node"); //Ler a tag Node e guarda em uma lista
        
        int tamLE = listaEstabelecimentos.getLength();

        for(int i = 0; i < tamLE; i++){ //for da tag node
            Node noNode = listaEstabelecimentos.item(i); // Pega cada item(node) como um nó

            if(noNode.getNodeType() == Node.ELEMENT_NODE){ // Verifica se a tag está vazia
                Element elementoNode = (Element)noNode; // Converte o nó em Element
                
                NodeList listaNodeFilhos = elementoNode.getChildNodes(); // Recupera os nó filhos do elemento

                int tamLNF = listaNodeFilhos.getLength();
                int num = 0; // Contador que verifica se contém amenity e name
                
                for(int j = 0; j < tamLNF; j++){ //for das tag's filhas de node
                    
                    Node noNodeFilho = listaNodeFilhos.item(j); //Cria um nó com cada tag filho

                    if(noNodeFilho.getNodeType() == Node.ELEMENT_NODE){ // Verifica se a tag está vazia
                        Element elementoNodeFilho = (Element)noNodeFilho; // Converte o nó filho em Element
                        
                        if(elementoNodeFilho.getAttribute("k").equals("amenity")){ // Verifica se contém o valor amenity
                            estabelecimento = elementoNodeFilho.getAttribute("v"); // Recupera o valor do atributo
                            num++;
                        }else if(elementoNodeFilho.getAttribute("k").equals("name")){ // Verifica se contém o valor name
                            nome = elementoNodeFilho.getAttribute("v"); // Recupera o valor do atributo
                            num++;
                        }
                    }
                } if(num == 2){
                    // Adiciona as informações no Json
                    json.addEstabelecimento(nome, estabelecimento, elementoNode.getAttribute("lat"), elementoNode.getAttribute("lon"));
                }
            }
        }
        System.out.println(json.getArrayEstabelecimentos());
        json.arquivoJson(); // Armazena as informações no arquivo Json
    }
}