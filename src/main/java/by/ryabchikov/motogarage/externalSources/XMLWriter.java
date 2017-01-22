package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class XMLWriter implements IWriter {

    @Override
    public void write(ArrayList<Mototechnics> arrayMoto, String pathToWriteXML) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            //define root element
            Element rootElement = document.createElement("motoList");
            document.appendChild(rootElement);

            for (Mototechnics m : arrayMoto) {

                //define subroot element
                Element moto = document.createElement("moto");
                rootElement.appendChild(moto);

                //define child elements for branch
                Element brand = document.createElement("brand");
                brand.appendChild(document.createTextNode(m.getBrand()));
                moto.appendChild(brand);

                Element model = document.createElement("model");
                model.appendChild(document.createTextNode(m.getModel()));
                moto.appendChild(model);

                Element maxSpeed = document.createElement("maxSpeed");
                maxSpeed.appendChild(document.createTextNode(String.valueOf(m.getMaxSpeed())));
                moto.appendChild(maxSpeed);

                Element weight = document.createElement("weight");
                weight.appendChild(document.createTextNode(String.valueOf(m.getWeight())));
                moto.appendChild(weight);

                Element power = document.createElement("power");
                power.appendChild(document.createTextNode(String.valueOf(m.getPower())));
                moto.appendChild(power);

                Element wheels = document.createElement("wheels");
                wheels.appendChild(document.createTextNode(String.valueOf(m.getWheels())));
                moto.appendChild(wheels);

                Element caseCapacity = document.createElement("caseCapacity");
                caseCapacity.appendChild(document.createTextNode(String.valueOf(m.getCaseCapacity())));
                moto.appendChild(caseCapacity);

                Element cost = document.createElement("cost");
                cost.appendChild(document.createTextNode(String.valueOf(m.getCost())));
                moto.appendChild(cost);
            }

            document.normalizeDocument();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            Result result = new StreamResult(new File(pathToWriteXML));

            transformer.transform(domSource, result);
        } catch (TransformerException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}