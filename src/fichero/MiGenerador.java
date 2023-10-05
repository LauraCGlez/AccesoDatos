package fichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MiGenerador {
    private Document document;

    public MiGenerador() throws ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        document = b.newDocument();
    }

    public void generarDocument() {
        Element persona = document.createElement("persona");
        persona.setAttribute("profesion", "cantante");

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode("Elsa"));
        persona.appendChild(nombre);

        Element mujer = document.createElement("mujer");
        persona.appendChild(mujer);

        Element fechaDeNacimiento = document.createElement("fecha_de_nacimiento");

        Element dia = document.createElement("dia");
        dia.appendChild(document.createTextNode("18"));
        fechaDeNacimiento.appendChild(dia);

        Element mes = document.createElement("mes");
        mes.appendChild(document.createTextNode("6"));
        fechaDeNacimiento.appendChild(mes);

        Element anho = document.createElement("año");
        anho.appendChild(document.createTextNode("1996"));
        fechaDeNacimiento.appendChild(anho);

        persona.appendChild(fechaDeNacimiento);

        Element ciudad = document.createElement("ciudad");
        ciudad.appendChild(document.createTextNode("Pamplona"));
        persona.appendChild(ciudad);

        document.appendChild(persona);
    }

    public void generarXml() throws TransformerConfigurationException, IOException, TransformerException {
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);

        File file = new File("/home/lauracglez/Desktop/persona.xml"); //ELVIRA PUEDES CAMBIAR AQUI LA RUTA PARA ADAPTARLA A TU ORDENADOR
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result result = new StreamResult(pw);

        transformer.transform(source, result);

        pw.close();
        fw.close();
    }

    public static void main(String[] args) {
        try {
            MiGenerador miGenerador = new MiGenerador();
            miGenerador.generarDocument();
            miGenerador.generarXml();
            System.out.println("Fichero XML generado con éxito.");
        } catch (ParserConfigurationException | IOException
                 | TransformerException e) {
            e.printStackTrace();
        }
    }
}
