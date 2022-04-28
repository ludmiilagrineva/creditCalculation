package spring.rest.dao;

import spring.rest.entity.Calculation;

import java.util.List;

public interface CalculatorDAO {
    public void saveCalculation(Calculation calculation);//сохраняет рассчеты
  public List<Calculation> getAllCalculations();//В меоде получает последние рассчеты

   public void deleteCalculations(int id);//удаляем выбранный рассчет
   public Calculation getCalculation(int id);

}
