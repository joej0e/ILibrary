package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import spring.controller.dto.UserDto;
import spring.entity.User;
import spring.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registrationView";
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("user") @Valid UserDto accountDto,
                                     BindingResult result,
                                     WebRequest request,
                                     Errors errors) {

        if (!result.hasErrors()) {
            createUserAccount(accountDto, result);
            return new ModelAndView("successRegister");
        }
        return new ModelAndView("registrationView", "user", accountDto);
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (AlreadyExistsException e) {
            return null;
        }
        return registered;
    }

}
