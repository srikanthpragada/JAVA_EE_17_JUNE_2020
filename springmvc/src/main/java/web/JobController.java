package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobController {
	@Autowired
	private JobRepo jobRepo;
	
	@RequestMapping("/jobs")
	public String job(ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		model.addAttribute("jobs", jobs);
		return "jobslist";
	}
	

	@RequestMapping("/addjob")
	public String addJob(ModelMap model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "addjob";
	}

	@RequestMapping(value = "/addjob", method = RequestMethod.POST)
	public String addJob(Job job, ModelMap model) {
		jobRepo.save(job);
		model.addAttribute("job", job);
		model.addAttribute("message", "Job has been added!");
		return "addjob";
	}

}
