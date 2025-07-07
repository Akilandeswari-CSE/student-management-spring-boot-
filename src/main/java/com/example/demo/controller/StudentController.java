package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.UserRepo;

import jakarta.servlet.http.HttpSession;



@Controller
public class StudentController {

    @Autowired
    private StudentRepo repo;
    
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/form")
    public String showForm() {
        return "Student_det"; 
    }

    @PostMapping("/students/save")
    public String saveFromForm(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/students"; 
    }

    @GetMapping("/students")
    public String viewAllStudents(Model model) {
        model.addAttribute("students", repo.findAll()); 
        return "Student_list"; 
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        Student student = repo.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student) {
        repo.save(student); 
        return "redirect:/students";  
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/students";  
    }
    
    //userrepo
    
    
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        User existingUser = userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());

        if (existingUser != null) {
            model.addAttribute("error", "Username already exists. Please login.");
            return "signup"; // return back to signup.jsp with error
        }

        userRepo.save(user);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userRepo.findByUsernameAndPassword(username,password);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

   @GetMapping("/home")
  public String homePage() {
    return "home";
}
    

}

/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@RestController
@RequestMapping ("/students")

public class StudentController {
	
	@ Autowired
	StudentRepo repo;
	/*
	@PostMapping("/add")
	
	public String add(@RequestBody Student stud)
	{
		 repo.save(stud);
		return "Student details saved";
		
	}
	

	
	@GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
*/
