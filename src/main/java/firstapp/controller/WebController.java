package firstapp.controller;

import firstapp.user.Role;
import firstapp.userService.RoleService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import firstapp.user.User;
import firstapp.userService.UserService;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class WebController {

    private UserService userService;
    private RoleService roleService;

    public WebController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }




    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        return model.addObject("users", userService.getAllUsers());
    }

    @RequestMapping(value = "admin/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
     modelAndView.addObject("user", userService.getUserById(id));
     return  modelAndView;
    }

    @RequestMapping(value = "admin/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, @RequestParam(value = "role") Set<Role> roles){
        Set<Role> r = new HashSet<>();
        if (roles.contains(new Role("[admin"))){
            r.add(roleService.getRoleById(1L));
            r.add(roleService.getRoleById(2L));
        }else {
            r.add(roleService.getRoleById(2L));
        }
        user.setRole(r);
        userService.editUser(user);
        return "redirect:/admin";
    }




    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }


    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role){
        Set<Role> r = new HashSet<>();
        if (role.equals("admin")){
            r.add(roleService.getRoleById(1L));
            r.add(roleService.getRoleById(2L));
        }else {
            r.add(roleService.getRoleById(2L));
        }
        user.setRole(r);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.GET)
    public String newUser(){
        return "add";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("loginError", "true");
        }
         if (logout != null) {
            model.addObject("logout", "true");
        }
        model.setViewName("login");
        return model;
    }



    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showUserPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user1 = userService.getUserByLogin(user.getLogin());
        ModelAndView model = new ModelAndView("user");
        model.addObject("user", user1);
        return model;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView accessDenied(@AuthenticationPrincipal User user) {

        ModelAndView model = new ModelAndView("error");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("login", userDetail.getUsername());

        }


        return model;

    }

    private Set<Role> getRoles(String role) {
        Set<Role> roles = new HashSet<>();

        switch (role) {
            case "admin":
                roles.add(roleService.getRoleById(1L));
                roles.add(roleService.getRoleById(2L));
                break;
            case "user":
                roles.add(roleService.getRoleById(2L));
                break;
        }

        return roles;
    }


}

