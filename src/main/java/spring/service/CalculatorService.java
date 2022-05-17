package spring.service;
//будет содержать методы

import spring.entity.Calculation;

import java.util.List;

public interface CalculatorService {
    void saveCalculation(Calculation calculation);//сохраняет расчет

    List<Calculation> getAllCalculations(); // В меоде получает последние расчеты

    void deleteCalculations(int id);

    Calculation getCalculation(int id);
}
