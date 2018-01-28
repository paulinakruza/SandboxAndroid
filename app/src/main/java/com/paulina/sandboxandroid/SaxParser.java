package com.paulina.sandboxandroid;

/**
 * Created by Paulina Kruża on 2018-01-28.
 */


import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {

    String     xmlFile;
    Meal       tmpMeal;
    Ingredient tmpIngredient;
    String     tmpString;
    int        ingredientFlag = 0;

    private Menu tmpMenu;

    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFile, this);
        } catch (ParserConfigurationException e) {
            System.out.println("Błąd ParserConfiguration");
        } catch (SAXException e) {
            System.out.println("SAXException: niepoprawny format XML");
        } catch (IOException e) {
            System.out.println("I/O error");
        }
    }

    private double stringToDouble(String string) {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = null;
        try {
            number = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }

    public SaxParser(String xmlFile) {
        this.xmlFile = xmlFile;
        parseDocument();
    }

    public void startElement(String uri, String localName, String elementName, Attributes attributes) throws SAXException {
        if (elementName.equalsIgnoreCase("menu")) {
            tmpMenu = new Menu();
        }

        if (elementName.equalsIgnoreCase("meal")) {
            tmpMeal = new Meal();
        }

        if (elementName.equalsIgnoreCase("ingredient")) {
            tmpIngredient = new Ingredient();
            ingredientFlag = 1;
        }
    }

    public void endElement(String uri, String localName, String elementName) {
        if (elementName.equalsIgnoreCase("meal")) {
            tmpMenu.addMeal(tmpMeal);
        }

        if (elementName.equalsIgnoreCase("recipe")) {
            tmpMeal.setRecipe(tmpString);
        }

        if (elementName.equalsIgnoreCase("ingredient")) {
            tmpMeal.addIngredient(tmpIngredient);
            ingredientFlag = 0;
        }

        if (elementName.equalsIgnoreCase("name")) {
            if (ingredientFlag == 0) {
                tmpMeal.setName(tmpString.trim());
            } else {
                tmpIngredient.setName(tmpString.trim());
            }
        }

        if (elementName.equalsIgnoreCase("calorie")) {
            tmpIngredient.setCalorie(stringToDouble(tmpString));
        }

        if (elementName.equalsIgnoreCase("amount")) {
            tmpIngredient.setAmount(stringToDouble(tmpString));
        }

        if (elementName.equalsIgnoreCase("unit")) {
            tmpIngredient.setUnit(tmpString);
        }

        if (elementName.equalsIgnoreCase("quantity")) {
            tmpIngredient.setQuantity(stringToDouble(tmpString));
        }

        if (elementName.equalsIgnoreCase("type")) {
            switch (tmpString.trim()) {
                case "Śniadanie":
                    tmpMeal.setType(MealType.BREAKFAST);
                    break;
                case "Drugie śniadanie":
                    tmpMeal.setType(MealType.ELEVENSES);
                    break;
                case "Przekąska II":
                    tmpMeal.setType(MealType.LUNCH);
                    break;
                case "Obiad":
                    tmpMeal.setType(MealType.DINNER);
                    break;
                case "Kolacja":
                    tmpMeal.setType(MealType.SUPPER);
                    break;
                default:
                    throw new IllegalArgumentException("Niepoprawny typ posiłku: " + tmpString);
            }
        }
    }

    public void characters(char[] ch, int start, int length) {
        tmpString = new String(ch, start, length);
    }

    public Menu getMenu() {
        return this.tmpMenu;
    }
}
