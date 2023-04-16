package org.springframework.samples.petclinic.booking;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.user.PricingPlan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/booking")
public class BookingController {
    public static final String CREATE_BOOKING = "booking/createBooking";
    public static final String LIST_BOOKINGS = "booking/listBookings";
    
    BookingService bookingService;

    PetService petService;

    @Autowired
    public BookingController(BookingService bookingService, PetService petService){
        this.bookingService = bookingService;
        this.petService = petService;
    }

    @GetMapping("/new")
    public ModelAndView createBooking(Principal principal,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes hacer reservas");
            return new ModelAndView("redirect:/");
        }else{ 
            Booking booking = new Booking();
            ModelAndView res = new ModelAndView(CREATE_BOOKING);
            List<Pet> petsFiltered = petService.getPetsByOwnerUsername(principal.getName());
            res.addObject("booking",booking);
            res.addObject("pets",petsFiltered);
            return res;
        }
    }

    @PostMapping("/new")
    public ModelAndView saveBooking(@Valid Booking booking,BindingResult br,Principal principal,Map<String,Object> model) throws BadDateException{
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes hacer reservas");
            return new ModelAndView("redirect:/");
        }else{     
            ModelAndView res = new ModelAndView(CREATE_BOOKING,br.getModel());
            List<Pet> petsFiltered = petService.getPetsByOwnerUsername(principal.getName());
            res.addObject("pets",petsFiltered);
            if(br.hasErrors()){
                res.addObject("pets",petsFiltered);
            }else{
                try{
                    this.bookingService.save(booking);
                    res = new ModelAndView("redirect:/booking/list");
                }catch(Exception e){
                    String mesage = badBoookingDatesMesage(booking);
                    res.addObject("mesage",mesage);
                }
            }
            return res;
        }
    }

    public String badBoookingDatesMesage(Booking booking){
        String mesage ="";
        if(booking.getFinishDate().isBefore(booking.startDate)){
            mesage = "La fecha de fin de la reserva no puede ser anterior a la fecha de inicio de la reserva";
        }else if(booking.getStartDate().isBefore(LocalDate.now())){
            mesage ="La fecha de inicio de la reserva no puede ser anterior a la fecha actual";
        }else if(booking.getFinishDate().isBefore(LocalDate.now())){
            mesage ="La fecha final de la reserva no puede ser anterior a la fecha actual";
        }else{
            mesage = "Ya existe una reserva para la mascota " + booking.getPet().getName() + " con fecha entre " + booking.getStartDate()
            + " y " + booking.getFinishDate();
        }
        return mesage;
    }

    @GetMapping("/list")
    public ModelAndView listBookings(Principal principal,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes ver las reservas");
            return new ModelAndView("redirect:/");
        }else{    
            List<Booking> bookings = bookingService.getAllBookings();
            List<Booking> auxiliar = bookings.stream()
                        .filter(x->x.getPet().getOwner().getUser().getUsername().equals(principal.getName()))
                        .collect(Collectors.toList());
            ModelAndView res = new ModelAndView(LIST_BOOKINGS);
            res.addObject("principal",principal.getName());
            res.addObject("bookings",auxiliar);
            return res;
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteBooking(@PathVariable("id") Integer id,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes cancelar reservas");
            return new ModelAndView("redirect:/");
        }else{     
            Booking booking = bookingService.getBookingById(id).orElse(null);
            if(booking != null){
                bookingService.deleteBookingById(id);
            }
            return new ModelAndView("redirect:/booking/list");
        }
    }
}
