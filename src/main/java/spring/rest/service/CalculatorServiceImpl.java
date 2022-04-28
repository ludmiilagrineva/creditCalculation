package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.dao.CalculatorDAO;
import spring.rest.entity.Calculation;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Autowired
    private CalculatorDAO calculatorDAO;

    @Override
    @Transactional
    public void saveCalculation(Calculation calculation) {
        calculatorDAO.saveCalculation(calculation);
    }

    @Override
    @Transactional
    public List<Calculation> getAllCalculations() {
        List<Calculation>allCalculation=calculatorDAO.getAllCalculations();
        return allCalculation;
    }

    @Override
    @Transactional
    public void deleteCalculations(int id) {
        calculatorDAO.deleteCalculations(id);

    }

    @Override
    @Transactional
    public Calculation getCalculation(int id){
        return calculatorDAO.getCalculation(id);
        }
    }

