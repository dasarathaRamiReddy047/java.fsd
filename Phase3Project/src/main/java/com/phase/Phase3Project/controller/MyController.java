package com.phase.Phase3Project.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.phase.Phase3Project.entity.Centers;
import com.phase.Phase3Project.entity.Citizens;
import com.phase.Phase3Project.entity.Login;
import com.phase.Phase3Project.repository.CentersRepository;
import com.phase.Phase3Project.repository.CitizensRepository;
import com.phase.Phase3Project.repository.LoginRepository;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	
	@Autowired
	CentersRepository cr;
	
	@Autowired
	CitizensRepository rc;
	
	@Autowired
	LoginRepository lg;
	

	// Login page View
	@GetMapping("/login")
	public String loginPage() {
		return "loginpage";
	}
	
	// Register Page  View
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	
	

	

	
	// Insert Register Details
	@PostMapping("/register")
	public String register(HttpServletRequest request) {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    try {
	        Login login = new Login(name, email, password);
	        lg.save(login);
	        return "loginpage";
	    } catch (DataIntegrityViolationException e) {
	    
	        String errorMessage = "Email address already exists. Please choose a different email.";
	        request.setAttribute("errorMessage", errorMessage);
	        return "register";
	    } catch (Exception e) {
	      
	        String errorMessage = "An error occurred during user registration. Please try again.";
	        request.setAttribute("errorMessage", errorMessage);
	        return "register";
	    }
	}
	


    //Get Center Details
    @GetMapping("/vaccinationcenter") 
    public String getCenters(Model model) {
    	List<Centers> centers = cr.findAll();
    	model.addAttribute("centers", centers);
    
    			
    	return "center";

    }
    
    // Get Add All cEnters  View
    @GetMapping("/vaccinationcenter/add")
    public String getAddCenter() {
    	return "addcenter";
    }
	
    
    // Add New Centers
    @PostMapping("/vaccinationcenter/add")
    public String addCenter(HttpServletRequest request, Model model) {
        String centerName = request.getParameter("centerName");
        String city = request.getParameter("city");
        
       Centers centers = cr.findByCityAndCenter(city, centerName);
        
        if(centers == null) {  
        Centers center = new Centers(city, centerName);
        cr.save(center);
        return "addcenter";
 
        }
        else {
       String errorMessage =  "Details Already Available";
       model.addAttribute("errorMessage", errorMessage);
       return "/vaccinationcenter/add";
        }
        	
        
    }
    
 
    
    // view Get By Id of center
    @GetMapping("/vaccinationcenter/citizens/center/{id}")
    public String getCenterByid(@PathVariable("id") Long id, Model model) {
        Optional<Centers> centers = cr.findById(id);
        if (centers.isPresent()) {
            Centers center = centers.get();
            String c = center.getCenter();
            String c1 = center.getCity();
            List<Citizens> citizen = rc.findByCityAndCenter(c1, c);
            model.addAttribute("center", center);
            model.addAttribute("citizen", citizen);
            return "viewCenter";
        } else {
        	String errorMessage = "Not Found";
        	model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }

    
    // Getting Edit Center Id
    @GetMapping("/vaccinationcenter/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Centers> centerOptional = cr.findById(id);

        if (centerOptional.isPresent()) {
            Centers center = centerOptional.get();

            
            model.addAttribute("center", center);

            return "editCenter"; 
        } else {
        	
        	String  errorMessage = "Center not found";
            
            model.addAttribute("errorMessage", errorMessage);

            return "errorPage"; 
        }
    }
    
    
    // Posting Edit DEtaills
    @PostMapping("/vaccinationcenter/edit/{id}")
    public String updateById(@PathVariable("id") Long id, @ModelAttribute("centerForm") Centers centerForm, Model model) {
        Optional<Centers> centerOptional = cr.findById(id);
        
        if (centerOptional.isPresent()) {
            Centers center = centerOptional.get();
            
           
            center.setCenter(centerForm.getCenter());
            center.setCity(centerForm.getCity());
           
            cr.save(center);
            
            return "redirect:/vaccinationcenter";
        } else {
        	String errorMessage = "Id Not found";
        	model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }
    
    
    // Delete Center By Id
    @PostMapping("/vaccinationcenter/delete/{id}")
    public String deleteById(@PathVariable("id") Long id , Model model) {
        Optional<Centers> centerOptional = cr.findById(id);
        
        if (centerOptional.isPresent()) {
            Centers center = centerOptional.get();
            
            
            cr.delete(center);
            
            return "redirect:/vaccinationcenter";
        } else {
            String errorMessage = "Id not found";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }
    
    
    // Getting ALl citizens
    @GetMapping("/citizens")
    public String getAllCitizens(Model model) {
        List<Citizens> citizens = rc.findAll();
        model.addAttribute("citizens", citizens);
        return "citizens";
    }

    
    // view Get By Id of citizens
    @GetMapping("/citizens/view/{id}")
    public String getCitizenByid(@PathVariable("id") Long id, Model model) {
    	Optional<Citizens> c = rc.findById(id);
    	if(c != null) {
    		
    		model.addAttribute("person", c.get());
    		return "viewCitizen";
    		
    	}else {
    		String errorMessage = "Id Not Found";
    		model.addAttribute("errorMessage", errorMessage);
    				
    		return "error";
    	}
    	
    }
    
    
    
    
    
    // Getting Edit citizens Id
    @GetMapping("/citizens/edit/{id}")
    public String showEditFormcitizens(@PathVariable("id") Long id, Model model) {
        Optional<Citizens> citizensOptional = rc.findById(id);

        if (citizensOptional.isPresent()) {
        	Citizens citizen = citizensOptional.get();

         
            model.addAttribute("citizen", citizen);

            return "editCitizen"; 
        } else {
        	String errorMessage = "CitiZens Not Found";
         model.addAttribute("errorMessage", errorMessage);

            return "errorPage"; 
        }
    }
    
    
 // Posting Edit Details citizens
    @PostMapping("/citizens/edit/{id}")
    public String updateById(@PathVariable("id") Long id, @ModelAttribute("centerForm") Citizens citizenForm, Model model) {
        Optional<Citizens> citizenOptional = rc.findById(id);
        
        if (citizenOptional.isPresent()) {
            Citizens citizen = citizenOptional.get();
            
            
            citizen.setName(citizenForm.getName());
            citizen.setCity(citizenForm.getCity());
            citizen.setDoses(citizenForm.getDoses());
            citizen.setStatus(citizenForm.getStatus());
            citizen.setCenter(citizenForm.getCenter());
          
            rc.save(citizen);
            
            return "redirect:/citizens";
        } else {
            String errorMessage =  "Id Not Found";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }

    
    
    
    // Delete Center By Id
    @PostMapping("/citizens/delete/{id}")
    public String deleteByIdcitizens(@PathVariable("id") Long id,Model model) {
        Optional<Citizens> citizensOptional = rc.findById(id);
        
        if (citizensOptional.isPresent()) {
        	Citizens citizens = citizensOptional.get();
            
            rc.delete(citizens);
            
            return "redirect:/citizens";
        } else {
            String errorMessage = "Id Not Found";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }
    
    // GEt Add ALl cEnters  View
    @GetMapping("/citizens/add")
    public String getAddCitizens(Model model) {
    	List<Centers> center = cr.findAll();
    	model.addAttribute("centers", center);
    	return "addcitizen";
    }
	
   
 //Insert new Citizen Details
 @PostMapping("/citizens/add")
 public String addCitizens(HttpServletRequest request, Model model) {
	    String name = request.getParameter("name");
	    String city = request.getParameter("city");
	    String doses = request.getParameter("doses");
	    String status = request.getParameter("status");
	    String center = request.getParameter("center");

	    String names = name.trim();
	   
	    List<Citizens> existingCitizens = rc.findByname(names);
	   
	    if (!existingCitizens.isEmpty()) {
	        
	        String errorMessage = "Citizen is already mapped to another vaccination center";
	        model.addAttribute("errorMessage", errorMessage);
	        return "error"; 
	    }

	    Citizens citizen = new Citizens();
	    citizen.setName(name);
	    citizen.setCity(city);
	    citizen.setDoses(doses);
	    citizen.setStatus(status);
	    citizen.setCenter(center);
	    model.addAttribute("message", "Citizen Added");

	    rc.save(citizen);
	    return "redirect:/citizens";
	}
 
 
 	// Logout
    @GetMapping("/logout")
    public String logout(){
    	return "loginpage";
    }


	
}
