package engeto.DU.Plants;

import java.time.LocalDate;

public class Plant {
    private static final int INITIAL_WATERING_FREQUENCY_IN_DAYS = 7;
    private String name;
    private String notes;
    private int wateringFrequencyInDays;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;

    public Plant(String nameStr, String notesStr, String wateringFrequencyInDaysStr, String plantedDateStr, String lastWateringDateStr) throws PlantException {
        this.name = nameStr;
        this.notes = notesStr;

        try{
        this.plantedDate = LocalDate.parse(plantedDateStr);
        }catch (NumberFormatException e){
            throw new PlantException("Wrong format of plant date" + e.getLocalizedMessage()); }

        try {
            this.lastWateringDate = LocalDate.parse(lastWateringDateStr);
        }catch (NumberFormatException e){
            throw new PlantException("Wrong format of plant watering frequency in days " + e.getLocalizedMessage()); }

        try {
            this.wateringFrequencyInDays = Integer.parseInt(wateringFrequencyInDaysStr);
        }catch(NumberFormatException e) {
            throw new PlantException("Wrong format of plant watering frequency in days " + e.getLocalizedMessage()); }
    }

    public Plant(String name, String notes, int wateringFrequencyInDays, LocalDate plantedDate, LocalDate lastWateringDate) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringFrequencyInDays = wateringFrequencyInDays;
    }

    public Plant(String name, int wateringFrequencyInDays, LocalDate plantedDate) {
        this(name, "", wateringFrequencyInDays, plantedDate, LocalDate.now());
    }

    public Plant(String name, LocalDate plantedDate) {
        this(name, "", INITIAL_WATERING_FREQUENCY_IN_DAYS, plantedDate, LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDate plantedDate) {
        this.plantedDate = plantedDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) throws PlantException {
        if (lastWateringDate.isBefore(plantedDate)){
            throw new PlantException("Last watering date mustn't be older then planet date. Was set: " + lastWateringDate);
        }
        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringFrequencyInDays() {return wateringFrequencyInDays;}

    public void setWateringFrequencyInDays(int wateringFrequencyInDays) throws PlantException {
        if (wateringFrequencyInDays < 1) {
            throw new PlantException("Watering frequency mustn't be zero or negative. Was set " + wateringFrequencyInDays);
        }
        this.wateringFrequencyInDays = wateringFrequencyInDays;
    }

    public String getWateringInfo() {
        return name + ": Last watering day:" + lastWateringDate + " Recommended watering day:" + lastWateringDate.plusDays(INITIAL_WATERING_FREQUENCY_IN_DAYS);
    }

}
