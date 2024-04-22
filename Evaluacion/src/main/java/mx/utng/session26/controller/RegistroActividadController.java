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
import mx.utng.session26.model.entity.RegistroActividad;
import mx.utng.session26.model.service.IRegistroActividadService;


@Controller
@SessionAttributes("registro")
public class RegistroActividadController {
        @Autowired
    private IRegistroActividadService service;

    @GetMapping({"/registro", "/registro/", "/registro/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Registro de actividades");
        model.addAttribute("registros", service.list());
        return "registro-list";
    }

    @GetMapping("/registro/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Registro de actividades");
        model.addAttribute("registro", new RegistroActividad());
        return "registro-form";
    }

    @PostMapping("/registro/form")
    public String save(@Valid RegistroActividad registro, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registro de actividades");
            return "registro-form";
        }
        service.save(registro);
        return "redirect:/registro/list";
    }

    @GetMapping("/registro/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroActividad registro = null;
        if(id>0){
            registro = service.getById(id);
        }else{
            return "redirect:/registro/list";
        }
        model.addAttribute("title", "Editar Registro de actividades");
        model.addAttribute("registro", registro);
        return "registro-form";
    }

    @GetMapping("/registro/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/registro/list";
    }
}
