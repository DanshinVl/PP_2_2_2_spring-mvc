package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "5" ) int count, ModelMap model) {
        try {
            if (count >= 5) {
                model.addAttribute("cars", carService.getCarList(carService.getCountCar()));
            } else {
                model.addAttribute("cars", carService.getCarList(count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cars";
    }


//    @GetMapping(value = "/cars")
//    public String addCar(Car car) {
//        return "cars";
//    }
}
