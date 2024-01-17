package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("Audi",1996));
        cars.add(new Car("BMW",2005));
        cars.add(new Car("Mercedes",2016));
        cars.add(new Car("Mitsubishi",2004));
        cars.add(new Car("Toyota",1975));
    }

    public List<Car> getCarList(int count) {
        return cars.stream().limit(count).toList();
    }

    public int getCountCar() {
        return cars.size();
    }

}
