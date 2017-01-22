package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.ATV;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.SportBikes;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.TouristBike;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class XMLReader implements IReader {

    @Override
    public ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto, String pathToReadXML) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.parse(new File(pathToReadXML));
            doc.normalizeDocument();


            Element root = doc.getDocumentElement();

            NodeList moto = root.getElementsByTagName("moto");
            for (int i = 0; i < moto.getLength(); i++) {
                Element item = (Element) moto.item(i);
                Element brand_element = (Element) item.getElementsByTagName("brand").item(0);
                Element model_element = (Element) item.getElementsByTagName("model").item(0);
                Element max_speed_element = (Element) item.getElementsByTagName("maxSpeed").item(0);
                Element weight_element = (Element) item.getElementsByTagName("weight").item(0);
                Element power_element = (Element) item.getElementsByTagName("power").item(0);
                Element wheels_element = (Element) item.getElementsByTagName("wheels").item(0);
                Element case_cap_element = (Element) item.getElementsByTagName("caseCapacity").item(0);
                Element cost_element = (Element) item.getElementsByTagName("cost").item(0);

                String brand = brand_element.getTextContent();
                String model = model_element.getTextContent();
                int max_speed = Integer.parseInt(max_speed_element.getTextContent());
                int weight = Integer.parseInt(weight_element.getTextContent());
                int power = Integer.parseInt(power_element.getTextContent());
                int wheels = Integer.parseInt(wheels_element.getTextContent());
                int case_cap = Integer.parseInt(case_cap_element.getTextContent());
                double cost = Double.parseDouble(cost_element.getTextContent());


                Mototechnics newMotoFromDB;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromDB = new ATV(brand, model, max_speed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromDB = new TouristBike(brand, model, max_speed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromDB = new SportBikes(brand, model, max_speed, weight, power, cost);
                }
                arrayMoto.add(newMotoFromDB);

            }

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Unable to parse file!");
        } catch (IOException e) {
            System.out.println("Unable to read file!");
        }

        return arrayMoto;
    }
}