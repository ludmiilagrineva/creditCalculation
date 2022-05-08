package spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.rest.dao.CalculatorDAO;
import spring.rest.entity.Calculation;
import spring.rest.service.CalculatorService;


import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String mainPage(Model model) {
        Calculation calculation = new Calculation();
        model.addAttribute("calculate", calculation);
        return "main-page";
    }

    @RequestMapping("/calculations")
    public String showAllCalculations(Model model) {
        List<Calculation> allCalculations = calculatorService.getAllCalculations();
        model.addAttribute("allCalc", allCalculations);
        return "all-calculation";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("calcId") int id) {
        calculatorService.deleteCalculations(id);
        return "redirect:/calculations";
    }


    @RequestMapping("/newCalculate")
    public String newCalculate(@Valid @ModelAttribute("calculate") Calculation calculation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "main-page";
        } else {
            calculatorService.saveCalculation(calculation);

            return "redirect:/calculations";
        }
    }

    @RequestMapping("/currentCalcul")
    public String currentCalculate(@ModelAttribute("calculate") Calculation calculation){
        return "currentCalc";
    }

    @RequestMapping("/show-calculation")
    public String showCalculation(@RequestParam("calcId") int id, Model model) {
        Calculation calculation = calculatorService.getCalculation(id);
        model.addAttribute("calculation", calculation);

        return "show-calculation";
    }
}




