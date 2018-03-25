package com.epul.controle;

import com.epul.dao.Service;
import com.epul.gestiondeserreurs.MonException;
import com.epul.metier.AdherentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by tardy on 24/03/2018.
 */
@Controller
public class AdherentController {


    @RequestMapping(value = "listerAdherent.htm")
    public ModelAndView afficherAdherents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = new String();
        Adher


        return new ModelAndView(destinationPage);
    }

}
