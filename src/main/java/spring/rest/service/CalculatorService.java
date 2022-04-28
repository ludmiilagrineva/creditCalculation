package spring.rest.service;
//будет содержать методы

import spring.rest.entity.Calculation;

import java.util.List;

public interface CalculatorService {
    public void saveCalculation(Calculation calculation);//сохраняет рассчеты
   public List<Calculation> getAllCalculations(); // В меоде получает последние рассчеты

    public void deleteCalculations(int id);//удаляем все рассчеты
    // ????????
    public Calculation getCalculation(int id);
}
