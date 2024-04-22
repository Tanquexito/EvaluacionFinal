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
import mx.utng.session26.model.entity.HistorialMedico;
import mx.utng.session26.model.service.IHistorialMedicoService;


@Controller
@SessionAttributes("historial")
public class HistorialMedicoController {
        @Autowired
    private IHistorialMedicoService service;

    @GetMapping({"/historial", "/historial/", "/historial/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Historiales Medicos");
        model.addAttribute("historiales", service.list());
        return "historial-list";
    }

    @GetMapping("/historial/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Historiales Medicos");
        model.addAttribute("historial", new HistorialMedico());
        return "historial-form";
    }

    @PostMapping("/historial/form")
    public String save(@Valid HistorialMedico historial, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Historiales Medicos");
            return "historial-form";
        }
        service.save(historial);
        return "redirect:/historial/list";
    }

    @GetMapping("/historial/form/{id}")
    public String update(@PathVariable Long id, Model model){
        HistorialMedico historial = null;
        if(id>0){
            historial = service.getById(id);
            System.out.println(historial);
        }else{
            return "redirect:/historial/list";
        }
        model.addAttribute("title", "Editar Historiales Medicos");
        model.addAttribute("historial", historial);
        return "historial-form";
    }

    @GetMapping("/historial/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/historial/list";
    }
}
