package de.milkonomy.models;

import de.milkonomy.elements.Map;
import processing.core.PImage;

public class Country {
    private Map map;
    private Double monthlyIncome;
    private Double tax;
    private int rank;
    private Double cost;
    private Double CostsOfLivingIndex;
    private int monthlyIncomeDifference;
    private String name;
    private Map compareMap;
    private String continent;

    public static class Builder {
        private PImage map;
        private Double monthlyIncome;
        private Double tax;
        private int rank;
        private Double cost;
        private Double CostsOfLivingIndex;
        private int monthlyIncomeDifference;
        private String name;
        private PImage compareMap;
        private String continent;

        public Builder setContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public Builder setCompareMap(PImage map) {
            this.compareMap = map;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMap(PImage map) {
            this.map = map;
            return this;
        }

        public Builder setMonthlyIncome(Double monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder setTax(Double tax) {
            this.tax = tax;
            return this;
        }

        public Builder setRank(int rank) {
            this.rank = rank;
            return this;
        }

        public Builder setCost(Double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setCostsOfLivingIndex(Double costsOfLivingIndex) {
            CostsOfLivingIndex = costsOfLivingIndex;
            return this;
        }

        public Builder setMonthlyIncomeDifference(int monthlyIncomeDifference) {
            this.monthlyIncomeDifference = monthlyIncomeDifference;
            return this;
        }

        public Country build() {
            Country country = new Country();
            country.cost = this.cost;
            country.CostsOfLivingIndex = this.CostsOfLivingIndex;
            country.map = new Map(0, 0, this.map);
            country.monthlyIncome = this.monthlyIncome;
            country.monthlyIncomeDifference = this.monthlyIncomeDifference;
            country.rank = this.rank;
            country.tax = this.tax;
            country.name = this.name;
            country.compareMap = new Map(0, 0, this.compareMap);
            country.continent = this.continent;

            return country;
        }
    }

    private Country() {
    }

    public String getContinent() {
        return continent;
    }

    public Map getCompareMap() {
        return compareMap;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCostsOfLivingIndex() {
        return CostsOfLivingIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCostsOfLivingIndex(Double costsOfLivingIndex) {
        CostsOfLivingIndex = costsOfLivingIndex;
    }

    public int getMonthlyIncomeDifference() {
        return monthlyIncomeDifference;
    }

    public void setMonthlyIncomeDifference(int monthlyIncomeDifference) {
        this.monthlyIncomeDifference = monthlyIncomeDifference;
    }
}
