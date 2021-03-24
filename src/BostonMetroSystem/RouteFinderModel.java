package BostonMetroSystem;

import java.util.ArrayList;

public class RouteFinderModel {
    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public int getCalculationValue(){
        return calculationValue;
    }

    public ArrayList parseFile(){

        Parser parse = new Parser();
        ArrayList<Station> stations = parse.parseFile();

        return stations;
    }

}
