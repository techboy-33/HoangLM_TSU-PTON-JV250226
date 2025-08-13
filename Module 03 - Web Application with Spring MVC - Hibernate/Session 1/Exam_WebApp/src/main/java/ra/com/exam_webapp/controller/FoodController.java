package ra.com.exam_webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.exam_webapp.model.Food;
import ra.com.exam_webapp.repository.FoodRepository;
import ra.com.exam_webapp.service.FoodService;

import java.util.List;

@Controller
@RequestMapping("/foodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/findAll")
    public String findAllFood(Model model) {
        List<Food> listFood = foodService.findAll();
        model.addAttribute("listFood", listFood);
        return "food";
    }

    @GetMapping("/initCreate")
    public String initCreateFood(Model model) {
        Food food = new Food();
        model.addAttribute("food", food);
        return "newFood";
    }

    @PostMapping("/create")
    public String createFood(Food food) {
        boolean result = foodService.create(food);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public String initUpdateFood(Model model, int foodId) {
        Food food = foodService.findById(foodId);
        model.addAttribute("food", food);
        return "updateFood";
    }

    @PostMapping("/update")
    public String updateFood(Food food) {
        boolean result = foodService.update(food);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteFood(int foodId) {
        boolean result = foodService.delete(foodId);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
