package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.PlanAlimentacion;
import mx.utng.session26.model.service.IPlanAlimentacionService;



@Controller
@SessionAttributes("plan")
public class PlanAlimentacionController {
        @Autowired
    private IPlanAlimentacionService service;

    @GetMapping({"/plan", "/plan/", "/plan/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Plan de alimentacion");
        model.addAttribute("planes", service.list());
        return "plan-list";
    }

    @GetMapping("/plan/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Plan de alimentacion");
        model.addAttribute("plan", new PlanAlimentacion());
        return "plan-form";
    }

    @PostMapping("/plan/form")
    public String save(@Valid PlanAlimentacion plan, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Plan de alimentacion");
            return "plan-form";
        }
        service.save(plan);
        return "redirect:/plan/list";
    }

    @GetMapping("/plan/form/{id}")
    public String update(@PathVariable Long id, Model model){
        PlanAlimentacion plan = null;
        if(id>0){
            plan = service.getById(id);
        }else{
            return "redirect:/plan/list";
        }
        model.addAttribute("title", "Editar Plan de alimentacion");
        model.addAttribute("plan", plan);
        return "plan-form";
    }

    @GetMapping("/plan/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/plan/list";
    }
}
