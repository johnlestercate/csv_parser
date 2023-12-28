package in.purabtech.csvupload.controller;

import in.purabtech.csvupload.dto.ApplicationFormDto;
import in.purabtech.csvupload.helper.CSVHelper;
import in.purabtech.csvupload.model.ApplicationForm;
import in.purabtech.csvupload.repository.ApplicationFormRepository;
import in.purabtech.csvupload.service.ApplicationFormService;
import in.purabtech.csvupload.service.CSVService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
@Slf4j
public class CSVController {

    @Autowired
    ApplicationFormRepository applicationFormRepository;

    @Autowired
    ApplicationFormService applicationFormService;

    @Autowired
    CSVService fileService;


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);
                model.addAttribute("success", "Uploaded the file successfully ");
                return "upload";

            } catch (Exception e) {
                model.addAttribute("error", "Please Upload Valid files Only");
                return "upload";
            }
        }
        model.addAttribute("error", "Please Upload Valid files Only");
        return "upload";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("applicationForms", applicationFormRepository.findAll());
        return "fragments/listOfApplications";
    }


    @GetMapping("/{id}")
    public String getFile(@PathVariable Long id, Model model) {
        try {
            fileService.loadData(id);
            model.addAttribute("applicationForms", applicationFormRepository.findAll());
            model.addAttribute("success", "Successfully Downloaded file");
            return "fragments/listOfApplications";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to Download file");
            return "fragments/listOfApplications";
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFile(@PathVariable Long id) {
        ApplicationForm detail = this.applicationFormRepository.findById(id).orElse(null);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("fragments/editDetails");
        modelAndView.addObject("detail", detail);

        return modelAndView;
    }

    @PostMapping("/updateDetails/{id}")
    public String edit(@PathVariable Long id, ApplicationFormDto applicationForm,
                       BindingResult result, Model model, RedirectAttributes redirectAttributes) {


       var results = applicationFormService.updateDetails(id, applicationForm);

        model.addAttribute("applicationForms", applicationFormRepository.findAll());
        model.addAttribute("success", "Successfully Update ".concat(results.getPFname() + " " + results.getPLname()).concat(" Form."));
        return "fragments/listOfApplications";

    }

    @GetMapping(value ="/upload")
    public String getTemplate() {
        return "upload";
    }


}
