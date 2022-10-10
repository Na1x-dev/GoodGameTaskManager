package com.example.demo.controllers.work;

import com.example.demo.models.Work;
import com.example.demo.services.task.TaskService;
import com.example.demo.services.user.UserService;
import com.example.demo.services.work.WorkService;
import com.sun.xml.bind.v2.schemagen.xmlschema.Particle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    WorkService workService;

    @GetMapping("/mainPage/index")
    public String mainPage(Model model, Principal user) {
        List<Work> works = workService.readAll(user.getName());
        model.addAttribute("works", works);
        return "mainPage/index";
    }

    @GetMapping("/workPage/index/id={id}")
    public String workPage(Model model, @PathVariable(name="id") Long workId){
        Work currentWork = workService.read(workId);
        model.addAttribute("currentWork", currentWork);
        model.addAttribute("tasks", taskService.readAll(workId));
        return "workPage/index";
    }

    @GetMapping("/newWorkPage/index")
    public String createNewWork(Model model){
        Work newWork = new Work();
        model.addAttribute("newWork",newWork);
        return "newWorkPage/index";
    }

    @PostMapping("/newWorkPage/index")
    public String createNewWork(Model model, Principal user, Work newWork){
        workService.create(newWork, userService.findByUsername(user.getName()));
        return "redirect:/mainPage/index";
    }


}
