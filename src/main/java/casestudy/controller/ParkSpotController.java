package casestudy.controller;

import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.UserDAO;
import casestudy.database.Entity.ParkingSpot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ParkSpotController{


        @Autowired
        private ParkingSpotDAO parkingSpotDAO;


        @GetMapping( "/park/Search")
        public ModelAndView search( String state) {
            ModelAndView response = new ModelAndView();

            response.setViewName("park/Search");

            //List<ParkingSpot> parkingSpots = ParkingSpotDAO.findAll();

            List<ParkingSpot> parkingSpots = parkingSpotDAO.findByStateIgnoreCase( state);

            //List<ParkingSpot> = new ArrayList<>();
            log.info("{}", parkingSpots.size());
//            List<Object[]> info = parkingSpotDAO.getInfo( state); not working

           // List<ParkingSpot> allSpots = parkingSpotDAO.findAll();
            //@Query( value = ""
            //List<ParkingSpot> parkingSpot = parkingSpotDAO.findParkingSpotByStatus(status);
            //response.addObject("info", info);
            response.addObject("parkingSpots", parkingSpots);
            //response.addObject("allSpots", allSpots);


            return response;
        }

}
