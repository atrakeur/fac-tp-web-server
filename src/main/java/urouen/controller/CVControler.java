package urouen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import urouen.model.CV;
import urouen.model.CVEntry;
import urouen.model.CVList;

@Controller
@RequestMapping("/resume")
public class CVControler {

    public CVList cvList = new CVList();

    /**
     * renvoie un flux XML contenant la liste des CV
     * @return une liste de CV
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public @ResponseBody
    CVList getAllCV() {
        return cvList;
    }

    /**
     * renvoie un flux XML d ́ecrivant le CV d’idenditifiant id.
     * @param id de la personne recherchée
     * @return le cv de la personne dont l'id est entré en paramètre
     */
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    CVEntry getCVByID(@PathVariable int id) {
        CVEntry cv = new CVEntry();

        for (CVEntry cvEntry: cvList.getListCV()) {
            if (cvEntry.getId() == id) {
                cv = cvEntry;
                break;
            }
        }
        return cv;
    }

    /**
     * reçcoit un flux XML décrivant un CV, créé l'objet correspondant et retourne son nouvel identifiant au format XML
     * @param cv
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public @ResponseBody
    CVEntry getCVByPost(CVEntry cv) {
        CVEntry cvEntry = new CVEntry(cv.getId(), cv.getFirstname(), cv.getName());
        cvEntry.setId(cv.getId());
        cvEntry.setFirstname(cv.getFirstname());
        cvEntry.setName(cv.getName());

        return cvEntry;
    }

}