package engeto.DU.Plants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    public static final String DELIMITER = "\t";

    private List <Plant> plantArrayList = new ArrayList<>();

    public static PlantList importFromTextFile(String fileName) throws PlantException {
        PlantList list = new PlantList();
        try (Scanner sc = new Scanner(new FileInputStream(fileName))){
            while (sc.hasNextLine()){
                String inputLine = sc.nextLine();
                // Parse of text into String[]items according DELIMITER
                String[] items = inputLine.split(DELIMITER);
                Plant plant = new Plant(items[0],items[1],items[2],items[3],items[4]);
                list.addPlant(plant);
               // System.out.println(inputLine);
            }
        } catch (FileNotFoundException ex){
            throw new PlantException("Soubor " + fileName + " nenalezen:" + ex.getLocalizedMessage());
        }
        return list;
    }

    public void exportToFile(String fileName) throws PlantException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            for (Plant plant : plantArrayList){
                writer.println(
                        plant.getName() + DELIMITER
                        +plant.getNotes() + DELIMITER
                        +plant.getWateringFrequencyInDays() + DELIMITER
                        +plant.getPlantedDate() + DELIMITER
                        +plant.getLastWateringDate());
            }
        } catch (FileNotFoundException e){
            throw new PlantException(("Soubor " + fileName + " nenalezen: " + e.getLocalizedMessage()));
        }
    }

    public void addPlant(Plant plant){
        plantArrayList.add(plant);
    }

    public Plant getPlant(int i) {
        return plantArrayList.get(i);
    }

    public void removePlant(int i){
        plantArrayList.remove(i);
    }

    public List<Plant> getplantArrayList(){
        return plantArrayList;
    }
}

