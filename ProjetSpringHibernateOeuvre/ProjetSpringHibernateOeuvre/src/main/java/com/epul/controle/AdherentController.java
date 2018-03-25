package com.epul.controle;

import com.epul.dao.Service;
import com.epul.dao.AdherentService;
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
    public ModelAndView afficherLesAdrents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            AdherentService unAdherentService = new AdherentService();
            request.setAttribute("mesAdherents", unAdherentService.consulterListeAdherents());
            destinationPage = "listerAdherent";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }



    @RequestMapping(value = "ajouterAdherent.htm")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "rreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererAdherent.htm")
    public ModelAndView insererAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            AdherentEntity unAdherent = new AdherentEntity();
            unAdherent.setNomAdherent(request.getParameter("nomAdherent"));
            unAdherent.setPrenomAdherent(request.getParameter("prenomAdherent"));
            unAdherent.setVilleAdherent(request.getParameter("villeAdherent"));
            AdherentService unAdherentService = new AdherentService();
            unAdherentService.insertAdherent(unAdherent);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        destinationPage = "home";
        return new ModelAndView(destinationPage);
    }

}
