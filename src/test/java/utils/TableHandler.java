package utils;

import co.boorse.seleniumtable.SeleniumTable;
import co.boorse.seleniumtable.SeleniumTableCell;
import co.boorse.seleniumtable.SeleniumTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHandler {
    public static List<WebElement> getTableRow(WebDriver driver, int rowNumber){
        return driver.findElements((By.cssSelector("tbody tr:nth-child(" + rowNumber + ") td")));
    }

    public static List<WebElement> getTableColumn(WebDriver driver, int columnNumber){
        return driver.findElements((By.cssSelector("tbody td:nth-child(" + columnNumber + ")")));
    }
    public static SeleniumTableRow getTableHeader(WebElement tableElement){
        SeleniumTable seleniumTable = SeleniumTable.getInstance(tableElement);
        return seleniumTable.headerRow();
    }

    public static SeleniumTableCell getTableHeaderCell(WebElement tableElement, int index){
        return getTableHeader(tableElement).get(index);
    }

    public static List<SeleniumTableRow> getAllRows(WebElement tableElement){
        SeleniumTable seleniumTable = SeleniumTable.getInstance(tableElement);
        return seleniumTable.rows();
    }

    public static SeleniumTableRow getRow(WebElement tableElement, int index){
        return getAllRows(tableElement).get(index);
    }

    public static SeleniumTableCell getRowCell(WebElement tableElement, int rowIndex, int cellIndex){
        return getAllRows(tableElement).get(rowIndex).get(cellIndex);
    }

    public static int getRowCount(WebElement tableElement){
        SeleniumTable seleniumTable = SeleniumTable.getInstance(tableElement);
        return seleniumTable.rowCount();
    }

    public static int getCellCount(WebElement tableElement){
        SeleniumTable seleniumTable = SeleniumTable.getInstance(tableElement);
        return seleniumTable.headerRow().cellCount();
    }

    public static List<SeleniumTableCell> getCells(WebElement tableElement, int rowIndex) {
        return getRow(tableElement, rowIndex).cells();
    }
    public static void selectRadioBtnByVisibleText(WebElement tableElement, int rowIndex, String labelName) {
        for(SeleniumTableCell cell : getCells(tableElement, rowIndex)) {
            WebElement label = cell.getElement().findElement(By.tagName("label"));
            if(label.getText().equals(labelName)) {
                label.click();
                break;
            }
        }
    }
}