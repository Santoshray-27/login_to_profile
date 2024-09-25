package com.example.login_to_profile;

import java.io.IOException;
import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

@Controller
public class LoginCon {
    @Autowired
    LoginRepo lr;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("detail", new Login_form());
        return "ChatterHub";
    }

    @PostMapping("/save")
    public String saveFood(@ModelAttribute Login_form detail, @RequestParam("img") MultipartFile img)
            throws IOException {
        if (img != null && !img.isEmpty()) {
            detail.setProfilepic(img.getBytes());
        }
        lr.save(detail);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        List<Login_form> details = lr.findAll();
        for (Login_form food : details) {
            if (food.getProfilepic() != null) {
                String img = Base64.getEncoder().encodeToString(food.getProfilepic());
                food.setProfilepicurl(img);
            }
        }
        model.addAttribute("profiles", details);
        return "Profile";
    }

    // @GetMapping("/update/{id}")
    // public String updateProfile(@PathVariable(value = "id") long id, Model model)
    // {
    // Login_form lf = lr.findById(id).orElseThrow(() -> new
    // IllegalArgumentException("Invalid user Id:" + id));
    // model.addAttribute("update", lf);
    // return "updateprofile";
    // }

    // @PostMapping("/update/{id}")
    // public String updateUser(@PathVariable("id") Long id, @ModelAttribute("lf")
    // Login_form lf) {
    // lf.setId(id); // Ensures we update the correct user
    // lr.save(lf);
    // return "redirect:/profile";
    // }

    @GetMapping("/update/{id}")
    public String showEditProfileForm(Model model) {
        Login_form profile = new Login_form(); // Retrieve profile data from DB
        model.addAttribute("profile", profile);
        return "updateprofile";
    }

    @PostMapping("/updateProfile")  
    public String saveIMg(@ModelAttribute Login_form detail, @RequestParam("img") MultipartFile img) throws IOException {
        if (img != null && !img.isEmpty()) {
            detail.setProfilepic(img.getBytes());
        }
        lr.save(detail);
        return "redirect:/profile";
    }
}
