package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import poly.edu.entity.StudentVLD;

@Controller
public class StudentVLDController {
	@RequestMapping("/student/form")
    public String showForm(Model model, @ModelAttribute StudentVLD student) {
		model.addAttribute("student", student);
        model.addAttribute("message", "Vui lòng nhập thông tin sinh viên");
        return "/demo/studentvld";
    }
    
    @RequestMapping("/student/save")
    public String validateForm(Model model,
                              @Valid @ModelAttribute StudentVLD student, 
                              Errors errors) {
    	model.addAttribute("student", student);
        if(errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng");
        }
        return "/demo/studentvld";
    }
}
