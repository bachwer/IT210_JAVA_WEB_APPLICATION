package org.example.controller;

import org.example.service.TableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tables")
public class TableController {

    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String list(@RequestParam(value = "cap", required = false) Integer cap,
                       ModelMap model) {
        model.addAttribute("tables", service.filterByCapacity(cap));
        return "tableList";
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("tableDetail");
        mv.addObject("table", service.getById(id));
        return mv;
    }


    @PostMapping("/update-status")
    public String update(@RequestParam int id, @RequestParam String status) {
        service.updateStatus(id, status);
        return "redirect:/tables/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, ModelMap model) {
        model.addAttribute("msg", service.delete(id));
        model.addAttribute("tables", service.filterByCapacity(null));
        return "tableList";
    }
}