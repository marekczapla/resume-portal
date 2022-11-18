package pl.markopolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.markopolo.models.Education;
import pl.markopolo.models.Job;
import pl.markopolo.models.MyUserDetails;
import pl.markopolo.models.UserProfile;

import java.security.Principal;
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
    public String edit(Model model, Principal principal, @RequestParam(required = false) String add) {
        String userId = principal.getName();
        model.addAttribute("userId", userId);
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));
        UserProfile userProfile = userProfileOptional.get();
        if ("job".equals(add)) {
            userProfile.getJobs().add(new Job());
        } else if ("education".equals(add)) {
            userProfile.getEducationList().add(new Education());
        } else if ("skill".equals(add)) {
            userProfile.getSkills().add("");
        }
        model.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, Principal principal, @ModelAttribute UserProfile userProfile) {
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userName);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userName));
        UserProfile savedUserProfile = userProfileOptional.get();
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(userName);
        userProfileRepository.save(userProfile);
        return "redirect:/view/" + userName;
    }

    @GetMapping("/view/{userId}")
    public String view(Principal principal, @PathVariable String userId, Model model) {
        if (principal != null && principal.getName() != "") {
            boolean currentUsersProfile = principal.getName().equals(userId);
            model.addAttribute("currentUsersProfile", currentUsersProfile);
        }
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        System.out.println(userProfile.getJobs());

        return "profile-templates/" + userProfile.getChosenTheme() + "/index";
    }
}
