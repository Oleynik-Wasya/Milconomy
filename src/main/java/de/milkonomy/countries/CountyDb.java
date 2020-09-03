package de.milkonomy.countries;

import de.milkonomy.app.Application;
import de.milkonomy.models.Country;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountyDb {
    // static variable single_instance of type Singleton
    private static CountyDb single_instance = null;

    // variable of type String
    public Map<String, Country> counties;

    // private constructor restricted to this class itself
    private CountyDb() {
        counties = new HashMap<String, Country>();

        counties.put("Germany", new Country.Builder().setName("Germany")
                .setMonthlyIncome(3607.24)
                .setTax(7.)
                .setCost(0.75)
                .setRank(29)
                .setCostsOfLivingIndex(65.26)
                .setMonthlyIncomeDifference(31)
                .setMap(Application.processing.loadImage("maps/GermanyMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForGermany.png"))
                .setContinent("Europe")
                .build());

        counties.put("Morocco", new Country.Builder()
                .setName("Morocco")
                .setMonthlyIncome(377.25)
                .setTax(10.)
                .setCost(0.69)
                .setRank(104)
                .setCostsOfLivingIndex(34.32)
                .setMonthlyIncomeDifference(-25)
                .setMap(Application.processing.loadImage("maps/MoroccoMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForMorocco.png"))
                .setContinent("Africa")
                .build());

        counties.put("Switzerland", new Country.Builder()
                .setName("Switzerland")
                .setMonthlyIncome(6467.)
                .setTax(7.7)
                .setCost(1.46)
                .setRank(1)
                .setCostsOfLivingIndex(122.4)
                .setMonthlyIncomeDifference(135)
                .setMap(Application.processing.loadImage("maps/SwitzerlandMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForSwitzerland.png"))
                .setContinent("Europe")
                .build());

        counties.put("Pakistan", new Country.Builder()
                .setName("Pakistan")
                .setMonthlyIncome(201.23)
                .setTax(10.)
                .setCost(0.47)
                .setRank(132)
                .setCostsOfLivingIndex(21.98)
                .setMonthlyIncomeDifference(-88)
                .setMap(Application.processing.loadImage("maps/PakistanMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForPakistan.png"))
                .setContinent("Asia")
                .build());

        counties.put("Seychelles", new Country.Builder()
                .setName("Seychelles")
                .setMonthlyIncome(2282.66)
                .setTax(15.)
                .setCost(1.17)
                .setRank(19)
                .setCostsOfLivingIndex(71.59)
                .setMonthlyIncomeDifference(57)
                .setMap(Application.processing.loadImage("maps/SeychellesMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForSeychelles.png"))
                .setContinent("Africa")
                .build());

        counties.put("UK", new Country.Builder()
                .setName("UK")
                .setMonthlyIncome(2119.)
                .setTax(0.)
                .setCost(1.01)
                .setRank(27)
                .setCostsOfLivingIndex(67.28)
                .setMonthlyIncomeDifference(16)
                .setMap(Application.processing.loadImage("maps/UK.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForUK.png"))
                .setContinent("Europe")
                .build());

        counties.put("Japan", new Country.Builder()
                .setName("Japan")
                .setMonthlyIncome(2460.67)
                .setTax(8.)
                .setCost(1.85)
                .setRank(4)
                .setCostsOfLivingIndex(83.35)
                .setMonthlyIncomeDifference(203)
                .setMap(Application.processing.loadImage("maps/Japan.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForJapan.png"))
                .setContinent("Asia")
                .build());

        counties.put("China", new Country.Builder()
                .setName("China")
                .setMonthlyIncome(883.29)
                .setTax(8.)
                .setCost(1.6)
                .setRank(80)
                .setCostsOfLivingIndex(40.04)
                .setMonthlyIncomeDifference(-70)
                .setMap(Application.processing.loadImage("maps/ChinaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForChina.png"))
                .setContinent("Asia")
                .build());

        counties.put("India", new Country.Builder()
                .setName("India")
                .setMonthlyIncome(400.49)
                .setTax(0.)
                .setCost(0.7)
                .setRank(130)
                .setCostsOfLivingIndex(24.58)
                .setMonthlyIncomeDifference(-85)
                .setMap(Application.processing.loadImage("maps/IndiaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForIndia.png"))
                .setContinent("Asia")
                .build());

        counties.put("Australia", new Country.Builder()
                .setName("Australia")
                .setMonthlyIncome(2832.6)
                .setTax(0.)
                .setCost(0.78)
                .setRank(16)
                .setCostsOfLivingIndex(73.54)
                .setMonthlyIncomeDifference(81)
                .setMap(Application.processing.loadImage("maps/AustraliaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForAustralia.png"))
                .setContinent("worldwide")
                .build());

        counties.put("Egypt", new Country.Builder()
                .setName("Egypt")
                .setMonthlyIncome(234.28)
                .setTax(0.)
                .setCost(1.02)
                .setRank(121)
                .setCostsOfLivingIndex(29.54)
                .setMonthlyIncomeDifference(-32)
                .setMap(Application.processing.loadImage("maps/EgyptMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForEgypt.png"))
                .setContinent("Africa")
                .build());

        counties.put("Canada", new Country.Builder()
                .setName("Canada")
                .setMonthlyIncome(2961.)
                .setTax(5.)
                .setCost(1.91)
                .setRank(24)
                .setCostsOfLivingIndex(67.62)
                .setMonthlyIncomeDifference(12)
                .setMap(Application.processing.loadImage("maps/CanadaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForCanada.png"))
                .build());

        counties.put("USA", new Country.Builder()
                .setName("USA")
                .setMonthlyIncome(3384.)
                .setTax(5.)
                .setCost(1.06)
                .setRank(20)
                .setCostsOfLivingIndex(71.05)
                .setMonthlyIncomeDifference(37)
                .setMap(Application.processing.loadImage("maps/USAMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForUSA.png"))
                .setContinent("America")
                .build());

        counties.put("Venezuela", new Country.Builder()
                .setName("Venezuela")
                .setMonthlyIncome(22.26)
                .setTax(8.)
                .setCost(0.16)
                .setRank(125)
                .setCostsOfLivingIndex(27.17)
                .setMonthlyIncomeDifference(-70)
                .setMap(Application.processing.loadImage("maps/VenezuelaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForVenezuela.png"))
                .setContinent("America")
                .build());

        counties.put("Russia", new Country.Builder()
                .setName("Russia")
                .setMonthlyIncome(419.35)
                .setTax(10.)
                .setCost(0.92)
                .setRank(82)
                .setCostsOfLivingIndex(39.21)
                .setMonthlyIncomeDifference(-71)
                .setMap(Application.processing.loadImage("maps/RussiaMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForRussia.png"))
                .setContinent("Europe")
                .build());

        counties.put("Spain", new Country.Builder()
                .setName("Spain")
                .setMonthlyIncome(1334.24)
                .setTax(4.)
                .setCost(0.93)
                .setRank(44)
                .setCostsOfLivingIndex(53.77)
                .setMonthlyIncomeDifference(-18)
                .setMap(Application.processing.loadImage("maps/SpainMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForSpain.png"))
                .setContinent("Europe")
                .build());

        counties.put("Ukraine", new Country.Builder()
                .setName("Ukraine")
                .setMonthlyIncome(338.10)
                .setTax(0.)
                .setCost(0.96)
                .setRank(107)
                .setCostsOfLivingIndex(33.18)
                .setMonthlyIncomeDifference(-92)
                .setMap(Application.processing.loadImage("maps/UkraineMap.png"))
                .setCompareMap(Application.processing.loadImage("compareMaps/compareForUkraine.png"))
                .setContinent("Europe")
                .build());

    }

    // static method to create instance of Singleton class
    public static CountyDb getInstance() {
        if (single_instance == null)
            single_instance = new CountyDb();

        return single_instance;
    }
}
