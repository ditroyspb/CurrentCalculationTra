//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException {
        String[] columnMappingCable = {"diameter", "material", "resistance"};
        String[] columnMappingTrans = {"model", "power", "upVoltage", "downVoltage", "idleLoss", "shortCircuitLoss",
                "idleCurrent", "shortCircuitVoltage", "resistance"};
        String fileCableBaseName = "cableBaseTest.csv";
        String fileTransBaseName = "transBaseTest.csv";
        List<Cable> cableList = parseBase(columnMappingCable, fileCableBaseName);
        List<Cable> transList = parseBase(columnMappingTrans, fileTransBaseName);
        System.out.println(cableList);
        System.out.println(transList);
    }

    public static List<Cable> parseBase(String[] columnMapping, String fileName) {
        List<Cable> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Cable> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Cable.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Cable> csv = new CsvToBeanBuilder<Cable>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            list = csv.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}