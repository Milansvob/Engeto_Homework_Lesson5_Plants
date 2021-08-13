package engeto.DU.Plants;

import java.time.LocalDate;

public class Main {

    public static final String PLANTS_TXT = "plants.txt";
    public static final String PLANTS_OUTPUT_TXT = "plantsOutput.txt";
    public static final String ENTER = "\n";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) {
	Plant rose = new Plant("Rose","living room",7, LocalDate.of(2002,11,11),LocalDate.of(2021,8,5));
	Plant tulip = new Plant("Tulip","living room",7, LocalDate.of(2002,11,11),LocalDate.of(2021,8,5));

       // Test wateringFrequency exception
        try {
            rose.setWateringFrequencyInDays(0);
            System.out.println(rose.getWateringFrequencyInDays() + ENTER);
        }catch(PlantException ex){
            System.err.println(ex.getLocalizedMessage() + ENTER);
        }

        // Test setLastWateringDate exception
        try{
            rose.setLastWateringDate(LocalDate.of(2001,5,5));
            System.out.println(rose.getLastWateringDate() + ENTER);
        }catch (PlantException e) {
            System.err.println(e.getLocalizedMessage() + ENTER);
        }

        //Instance of Class Plantlist to be created
        PlantList plantList = new PlantList();

        //Download plants form PLANTS_TXT
        try{
            plantList = PlantList.importFromTextFile(PLANTS_TXT);
        } catch (PlantException ex){
            System.err.println("Loading data from file failed" + ex.getLocalizedMessage());
        }

        // Information about watering
            for (Plant list : plantList.getplantArrayList()) {
                System.out.println(list.getWateringInfo());
            }

        // Two plants to be added into plantList
        plantList.addPlant(rose);
        plantList.addPlant(tulip);

        // one plant to be removed
        plantList.removePlant(2);


        // Import into PLANTS_OUTPUT_TXT
        try {
            plantList.exportToFile(PLANTS_OUTPUT_TXT);
        } catch (PlantException e) {
            System.err.println("Uploading data into file failed" + e.getLocalizedMessage());
        }

        //Empty row to be inserted
        System.out.println();

         //Final report printed into console "equal to PLANTS_OUTPUT_TXT"
       for (int i = 0; i < plantList.getplantArrayList().size(); i++) {
           System.out.println(plantList.getPlant(i).getName() + DELIMITER
                            + plantList.getPlant(i).getNotes() + DELIMITER
                            + plantList.getPlant(i).getWateringFrequencyInDays() + DELIMITER
                            + plantList.getPlant(i).getPlantedDate() + DELIMITER
                            + plantList.getPlant(i).getLastWateringDate() + DELIMITER);
       }
    }
}
