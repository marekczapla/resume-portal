package pl.markopolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.markopolo.models.MyUserDetails;
import pl.markopolo.models.UserProfile;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException(userId + " not found"));

        model.addAttribute("userId", userId);
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfileOptional);

        return "profile-templates/" + userProfile.getId() + "/index";
    }
}
