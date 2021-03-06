package com.progeny.controllers;

import com.progeny.model.Group;
import com.progeny.repositories.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditGroupController {

    // --------- INITIALIZE ------------
    private GroupRepository groupsRepo;


    // ------------ CONSTRUCTOR METHOD ---------------
    // --------- AKA DEPENDENCY INJECTION ------------
    public EditGroupController(GroupRepository groupsRepo) {
        this.groupsRepo = groupsRepo;
    }


    // --------- EDIT GROUP (GET) ------------
    @GetMapping("/group/{id}/edit")
    public String showCreateGroup(@PathVariable long id, Model model) {

        System.out.println(id);
        Group editGroup = groupsRepo.getGroupById(id);
        System.out.println(id);

        model.addAttribute("editGroup", editGroup);
        System.out.println(editGroup);

        return "groups/editGroup"; // HTML PATH
    }

    // --------- EDIT GROUP (POST)------------
    @PostMapping("/group/{id}/edit")
    public String createGroupForm(@PathVariable long id, @ModelAttribute Group editGroup){

        Group currentGroupEdits = groupsRepo.getGroupById(id); // get the id of the Group

        currentGroupEdits.setName(editGroup.getName());
        currentGroupEdits.setDescription(editGroup.getDescription());

        groupsRepo.save(editGroup);

        return "redirect:/group/{id}"; // REDIRECT: URL PATH
    }

}
