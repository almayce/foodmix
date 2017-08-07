package appwork.almayce.foodmix.model.ingredients;

/**
 * Created by almayce on 30.05.17.
 */

public class Ingredient {
    private String fullName;
    private String shortName;
    private String searchName;
    private String type;
    private int imageId;
    private int boilingTime;
    private int fryingTime;
    private int stewingTime;
    private int backingTime;
    private int backingTemp;

    public Ingredient(String fullName, String shortName, String searchName, String type, int imageId, int boilingTime, int fryingTime, int stewingTime, int backingTime, int backingTemp) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.searchName = searchName;
        this.type = type;
        this.imageId = imageId;
        this.boilingTime = boilingTime;
        this.fryingTime = fryingTime;
        this.stewingTime = stewingTime;
        this.backingTime = backingTime;
        this.backingTemp = backingTemp;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSearchName() {
        return searchName;
    }

    public String getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public int getBoilingTime() {
        return boilingTime;
    }

    public int getFryingTime() {
        return fryingTime;
    }

    public int getStewingTime() {
        return stewingTime;
    }

    public int getBackingTime() {
        return backingTime;
    }

    public int getBackingTemp() {
        return backingTemp;
    }
}
