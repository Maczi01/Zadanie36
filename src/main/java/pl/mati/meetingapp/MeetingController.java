package pl.mati.meetingapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MeetingController {

    private MeetingRepository meetingRepository;

    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping("/")
    public String allMeetngs(Model model){
        List<Meeting> allmeetngs = meetingRepository.findAll();
        model.addAttribute("allmeetings", allmeetngs);
        return "homepage";
    }

    @GetMapping("/meeting/{id}")
    public String meetingDetails(@PathVariable Long id, Model model){
        Optional<Meeting> optional = meetingRepository.findById(id);
        if (optional.isPresent()) {
            Meeting meeting = optional.get();
            model.addAttribute("meeting", meeting);
            return "meeting";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/addmeeting")
    public String addMeetingForm(Model model){
        model.addAttribute("meeting", new Meeting());
        return "addmeetingform";
    }

    @PostMapping("/addmeeting")
    public String addMeeting(Meeting meeting){
        meetingRepository.save(meeting);
          return "redirect:/";
    }

    @GetMapping("/deletemeeting/{id}")
    public String deleteMeeting(@PathVariable Long id){
        meetingRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editmeeting/{id}")
    public String editMeeting(@PathVariable Long id, Model model){
        Optional<Meeting> optional = meetingRepository.findById(id);
        if(optional.isPresent()){
            Meeting meeting = optional.get();
            model.addAttribute("meeting", meeting);
            return "editmeeting";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/editmeeting")
    public String edit(Meeting meeting) {
        meetingRepository.save(meeting);
        return "redirect:/";
    }
    
}
