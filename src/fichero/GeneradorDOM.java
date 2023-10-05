package fichero;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class GeneradorDOM {
    private Document document; //atributo
    public GeneradorDOM() throws ParserConfigurationException { //constructor
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b =f.newDocumentBuilder();
        document = b.newDocument();
    }
    public void generarDocument(){
        Element productos = document.createElement("productos"); //creamos el elemento producto
        document.appendChild(productos); // lo convertimos en elemento raiz

        Element producto = document.createElement("producto"); //Etiquetas
        productos.appendChild(producto);
        producto.setAttribute("codigo", "1");

        Element nombre = document.createElement("nombre");

        nombre.appendChild(document.createTextNode("Mesa"));
        producto.appendChild(nombre);
    }

    public void generarXml() throws TransformerConfigurationException, FileNotFoundException, IOException, TransformerException {
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();

        Source source = new DOMSource(document);
        File file = new File("\\home\\lauracglez\\Desktop");
        FileWriter fw = new FileWriter (file);
        PrintWriter pw = new PrintWriter (fw);
        Result r = new StreamResult(pw);

        transformer.transform(source, r);
    }

    public static void main(String[] args) {
        try {
            GeneradorDOM generador = new GeneradorDOM();
            generador.generarDocument();
            generador.generarXml();
            System.out.println("Fichero XML generado con éxito.");
        } catch (ParserConfigurationException | IOException
                 | TransformerException e) {
            e.printStackTrace();
        }
    }

}