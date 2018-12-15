package com.bank.welcometochase.controller.manager;

import com.bank.welcometochase.model.AccessTool;
import com.bank.welcometochase.model.AccessToolRepository;
import com.bank.welcometochase.model.StatusType;
import com.bank.welcometochase.model.ToolName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/manage-access-tools")
public class ManagerAccessToolsController {

    @Autowired
    private AccessToolRepository repository;

    @GetMapping
    public ModelAndView getAllAccessTools() {
        List<AccessTool> accessTools = repository.findAll();
        return new ModelAndView("manager/manageAccessTools", "accessTools", accessTools);
    }

    @PostMapping(value = "manager/manageAccessTools")
    public ModelAndView addNewAccessTool(@ModelAttribute("accessTool") AccessTool accessTool){

        // @ModelAttribute AccessTool request
            //(@RequestParam(name = "toolName") String toolName,
                                      //  @RequestParam(name= "accessType") String accessType){


        System.out.println("In the addNewAccessTool method: tool name " + accessTool.getAccessType());

        AccessTool accessTool2 = new AccessTool(ToolName.AIM, "Production", StatusType.NOT_SUBMITTED);
        repository.save(new AccessTool(ToolName.AIM, "Production", StatusType.NOT_SUBMITTED));
        List<AccessTool> accessTools = repository.findAll();
        return new ModelAndView("manager/manageAccessTools", "accessTools", accessTools);
    }



    @PutMapping
    public ModelAndView updateAccessTool() {
        return null;
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ModelAndView deleteAccessTool(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        List<AccessTool> accessTools = repository.findAll();
        return new ModelAndView("manager/manageAccessTools", "accessTools", accessTools);
    }
}
