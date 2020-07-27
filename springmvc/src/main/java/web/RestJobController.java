package web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rest/job")
public class RestJobController {

	@Autowired
	JobRepo jobRepo;

	@GetMapping() // For Http GET request
	public Iterable<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	@GetMapping("/{id}") // For Http GET request with id
	public Job getOneDept(@PathVariable("id") String id) {
		Optional<Job> dept = jobRepo.findById(id);
		if (dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException
			     (HttpStatus.NOT_FOUND,  "Department Id Not Found");
	}

	@PostMapping() // For Http POST request
	public Job addDept(Job job) {
		try {
			// check whether job id is already present
			// if so, throw exception 
			jobRepo.save(job);
			return job;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
			 
		}
	}

	@DeleteMapping("/{id}") // For Http DELETE request
	public void deleteJob(@PathVariable("id") String id) {
		Optional<Job> dept = jobRepo.findById(id);
		if (dept.isPresent()) {
			try {
				jobRepo.delete(dept.get());
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException
			     (HttpStatus.NOT_FOUND, "Job Id Not Found!");
		}
	}

	@PutMapping("/{id}") // For Http PUT request
	public Job updateDept(@PathVariable("id") String id, Job newJob) {
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			try {
				Job dbJob = job.get();
				dbJob.setTitle(newJob.getTitle());
		        jobRepo.save(dbJob);  	
		        return dbJob;
			} catch (Exception ex) {
				System.out.println("Error  " + ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException
			     (HttpStatus.NOT_FOUND, "Job Id Not Found!");
		}
	}

}
