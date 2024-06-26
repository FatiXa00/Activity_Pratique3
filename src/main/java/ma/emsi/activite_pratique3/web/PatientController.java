package ma.emsi.activite_pratique3.web;

import lombok.AllArgsConstructor;
import ma.emsi.activite_pratique3.entities.Patient;
import ma.emsi.activite_pratique3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor //injection se fait via constructeur (lambok)
public class PatientController {

     private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0") int p,
                        @RequestParam(name="size",defaultValue = "4") int s,
                        @RequestParam(name = "keyword",defaultValue = "")String kw
            ){
        Page<Patient> pagePatients= patientRepository.findByNomContains(kw,PageRequest.of(p,s));
        model.addAttribute("ListPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patients";
    }


    @GetMapping("/delete")
    public String delete (Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home (){
        return "redirect:/index";
    }
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> ListPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/formPatients")
    public String formPatient(Model model ){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }

    @PostMapping(path="/save")
    public String save(Model model, Patient patient){
        patientRepository.save(patient);
        return "formPatients";

    }
}
