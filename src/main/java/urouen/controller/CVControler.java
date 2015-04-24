package urouen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import urouen.dao.CVRepository;
import urouen.model.CV;
import urouen.model.CVList;

@Controller
@RequestMapping("/resume")
public class CVControler {

    CVRepository repository = new CVRepository();

    /**
     * renvoie un flux XML contenant la liste des CV
     * @return une liste de CV
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public @ResponseBody
    CVList getAllCV() {
        return repository.getAll();
    }

    /**
     * renvoie un flux XML d ́ecrivant le CV d’idenditifiant id.
     * @param id de la personne recherchee
     * @return le cv de la personne dont l'id est entre en parametre
     */
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    CV getCVByID(@PathVariable int id) {
        return repository.get(""+id);
    }

    /**
     * recoit un flux XML decrivant un CV, cree l'objet correspondant et retourne son nouvel identifiant au format XML
     * @param cv
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public @ResponseBody
    CV getCVByPost(@RequestBody CV cv) {
        CV cvEntry = new CV();

        cvEntry.setFirstname(cv.getFirstname());
        cvEntry.setName(cv.getName());

        cvEntry = repository.add(cvEntry);
        return cvEntry;
    }

}