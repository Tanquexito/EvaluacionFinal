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
import mx.utng.session26.model.entity.Empleado;
import mx.utng.session26.model.service.IEmpleadoService;


@Controller
@SessionAttributes("empleado")
public class EmpleadoController {
        @Autowired
    private IEmpleadoService service;

    @GetMapping({"/empleado", "/empleado/", "/empleado/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Empleados");
        model.addAttribute("empleados", service.list());
        return "empleado-list";
    }

    @GetMapping("/empleado/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Empleados");
        model.addAttribute("empleado", new Empleado());
        return "empleado-form";
    }

    @PostMapping("/empleado/form")
    public String save(@Valid Empleado empleado, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Empleados");
            return "empleado-form";
        }
        service.save(empleado);
        return "redirect:/empleado/list";
    }

    @GetMapping("/empleado/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Empleado empleado = null;
        if(id>0){
            empleado = service.getById(id);
        }else{
            return "redirect:/empleado/list";
        }
        model.addAttribute("title", "Editar Empleado");
        model.addAttribute("empleado", empleado);
        return "empleado-form";
    }

    @GetMapping("/empleado/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/empleado/list";
    }
}
