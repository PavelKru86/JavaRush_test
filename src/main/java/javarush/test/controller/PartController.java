package javarush.test.controller;

import javarush.test.modeldata.Part;
import javarush.test.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kryuchkov on 20.09.2018.
 */
@Controller
public class PartController {
private PartService partService;

@Autowired(required = true)
@Qualifier("partService")
    public void setPartService(PartService partService) {
        this.partService = partService;
    }
     @RequestMapping(value = "parts",method = RequestMethod.GET)
        public String listParts(Model model){
        model.addAttribute("part",new Part());
        model.addAttribute("listParts",this.partService.listParts());
         model.addAttribute("listPartsPart",this.partService.listPartsPart());
         model.addAttribute("listPartTotal",this.partService.listPartTotal());
        return "parts";
     }
     @RequestMapping(value = "next",method = RequestMethod.GET)
     public String listPartsPart(Model model){
         model.addAttribute("part",new Part());
         model.addAttribute("listPartsNext",this.partService.listPartsNext());
         model.addAttribute("listPartTotal",this.partService.listPartTotal());
         return "next";
     }
     @RequestMapping(value = "previous",method = RequestMethod.GET)
     public String listPartsPrevious(Model model){
         model.addAttribute("part",new Part());
         model.addAttribute("listPartsPrevious",this.partService.listPartsPrevious());
         model.addAttribute("listPartTotal",this.partService.listPartTotal());
         return "previous";
     }
    @RequestMapping(value = "parts/add",method = RequestMethod.POST)
    public String addpart(@ModelAttribute("part") Part part){

        if(part.getId()==0)
            this.partService.addPart(part);
        else {
            this.partService.updatePart(part);
        }
        return "redirect:/parts";
    }
    @RequestMapping(value = "remove/{id}")
    public String removepart(@PathVariable("id")int id){
        this.partService.deletePart(id);
        return "redirect:/parts";
    }
    @RequestMapping(value = "edit/{id}")
    public String updatepart(@PathVariable("id")int id,Model model){
        model.addAttribute("part",this.partService.getPartById(id));
        model.addAttribute("listParts",this.partService.listParts());
        model.addAttribute("listPartTotal",this.partService.listPartTotal());
        return "parts";
    }
    @RequestMapping(value = "partdata/",method = RequestMethod.GET)
    public String partData(@RequestParam("name") String name, Model model){

      model.addAttribute("listPartsByName",this.partService.listPartsByName(name));
        model.addAttribute("listPartTotal",this.partService.listPartTotal());
      return "partdata";
    }

   /* @RequestMapping(value = "sort",method = RequestMethod.GET)
    public String listPartsSort( Model model){
        model.addAttribute("part",new Part());
        model.addAttribute("listParts",this.partService.listParts());
        model.addAttribute("listPartsSort",this.partService.listPartsSort());
        model.addAttribute("listPartTotal",this.partService.listPartTotal());

        return "sort";
    }*/

    @RequestMapping(value = "sort",method = RequestMethod.GET)
    public String listPartsSort(@ModelAttribute("part") Part part, Model model){
      //  this.partService.listSort(part);
        model.addAttribute("part",new Part());
        model.addAttribute("listParts",this.partService.listParts());
        model.addAttribute("listPartsSort",this.partService.listPartsSort());
        model.addAttribute("listPartTotal",this.partService.listPartTotal());

        return "sort";
    }



}
