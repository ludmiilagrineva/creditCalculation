package spring.dao;

import spring.entity.Calculation;

import java.util.List;

public interface CalculatorDAO {
    void saveCalculation(Calculation calculation);//сохраняет расчеты

    List<Calculation> getAllCalculations();// получает последние расчеты

    void deleteCalculations(int id);//удаляем выбранный расчет

    Calculation getCalculation(int id);//показывает выбранный расчет

}
