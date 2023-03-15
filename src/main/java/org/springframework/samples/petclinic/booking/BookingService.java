package org.springframework.samples.petclinic.booking;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
    
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository br){
        this.bookingRepository = br;

    }

    @Transactional(rollbackFor = BadDateException.class)
    public Booking save(Booking booking) throws BadDateException{
        try{
            if(booking.getFinishDate().isBefore(booking.startDate)){
                throw new BadDateException();
            }else if(booking.getStartDate().isBefore(LocalDate.now())){
                throw new BadDateException();
            }else if(booking.getFinishDate().isBefore(LocalDate.now())){
                throw new BadDateException();
            }else{
                for(Booking existingBooking: getAllBookings()){
                    if(existingBooking.getStartDate().isBefore(booking.getStartDate()) && 
                    existingBooking.getFinishDate().isAfter(booking.getFinishDate()) ||
                    existingBooking.getStartDate().isAfter(booking.getStartDate()) && 
                    existingBooking.getFinishDate().isAfter(booking.getFinishDate()) && 
                    existingBooking.getStartDate().isBefore(booking.getFinishDate()) || 
                    existingBooking.getStartDate().isBefore(booking.getStartDate()) && 
                    existingBooking.getFinishDate().isBefore(booking.getFinishDate()) && 
                    existingBooking.getFinishDate().isAfter(booking.getStartDate()) ||
                    existingBooking.getStartDate().isAfter(booking.getStartDate()) && 
                    existingBooking.getFinishDate().isBefore(booking.getFinishDate()) ||
                    existingBooking.getStartDate().isEqual(booking.getStartDate()) ||
                    existingBooking.getFinishDate().isEqual(booking.getFinishDate())){
                        throw new BadDateException();    
                    }
                }
            }
        }catch(Exception e){
            throw new BadDateException();
        }
        
        return bookingRepository.save(booking);
    }

    @Transactional(readOnly = true)
    public List<Booking> getAllBookings(){
        return (List<Booking>) bookingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Booking> getBookingById(Integer id){
        return bookingRepository.findById(id);
    }

    @Transactional
    public void deleteBookingById(Integer id){
        bookingRepository.deleteById(id);
    }

}
