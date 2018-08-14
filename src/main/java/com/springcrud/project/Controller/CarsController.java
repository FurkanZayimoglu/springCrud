package com.springcrud.project.Controller;


import com.springcrud.project.Model.Cars;
import com.springcrud.project.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarsController {

    @Autowired
    CarsService carsService;


    @RequestMapping(value = "/")
    public String carsList(Model model){
        model.addAttribute("carsList",carsService.getAll());
        return "carsList";
    }

    @RequestMapping(value = {"/carsEdit", "/carsEdit/{id}"}, method = RequestMethod.GET)
    public String carsEditForm(Model model, @PathVariable(required = false, name = "id") Integer id){
        if (id != null) {
            model.addAttribute("cars", carsService.getId(id));
        }else {
            model.addAttribute("cars", new Cars());
        }
        return "carsEdit";
        }

     @RequestMapping(value = "/carsEdit",method = RequestMethod.POST)
        public String carsEdits(Model model, Cars cars) {
         carsService.saveCars(cars);
         model.addAttribute("carsList",carsService.getAll());
         return "carsList";

     }

     @RequestMapping(value = "/carsDelete/{id}" , method = RequestMethod.GET)
    public String carsDelete(Model model, @PathVariable(required = true, name = "id") int id) {
         carsService.delete(id);
         model.addAttribute("carsList", carsService.getAll());
         return "carsList";
     }

    }

