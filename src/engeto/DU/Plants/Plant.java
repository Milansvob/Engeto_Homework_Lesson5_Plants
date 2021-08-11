package engeto.DU.Plants;

import java.time.LocalDate;

public class Plant {
    private static final int InitialWateringFequencyInDays = 7;
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringFequencyInDays;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, int wateringFequencyInDays) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringFequencyInDays = wateringFequencyInDays;
    }

    public Plant(String name, LocalDate plantedDate, int wateringFequencyInDays) {
        this(name, "", plantedDate, LocalDate.now(), wateringFequencyInDays);
    }

    public Plant(String name, LocalDate plantedDate) {
        this(name, "", plantedDate, LocalDate.now(), InitialWateringFequencyInDays);
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

    public void setLastWateringDate(LocalDate lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringFequencyInDays() {return wateringFequencyInDays;}

    public void setWateringFequencyInDays(int wateringFequencyInDays) throws PlantException {
        this.wateringFequencyInDays = wateringFequencyInDays;
        try{
        this.wateringFequencyInDays > 0;

    }catch(
    PlantException ex)

    {
        throw new PlantException("Špatně zadaná cena: " + ex.getLocalizedMessage());
    }

    public String getWateringInfo() {
        return name + ": Last watering day:" + lastWateringDate + " Recommended watering day:" + lastWateringDate.plusDays(InitialWateringFequencyInDays);
    }

}
