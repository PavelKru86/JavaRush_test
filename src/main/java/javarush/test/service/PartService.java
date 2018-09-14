package javarush.test.service;

import javarush.test.modeldata.Part;

import java.util.List;

/**
 * Created by Kryuchkov on 20.09.2018.
 */
public interface PartService {
    public void addPart(Part part);
    public void updatePart(Part part);
    public void deletePart(int id);
    public Part getPartById(int id);
    public List<Part> listParts();
    public void listSort(Part part);
    public List<Part> listPartsSort();
    public List<Part> listPartsByName(String name);
    public List<Part> listPartsPart();
    public List<Part> listPartsNext();
   public List<Part> listPartsPrevious();

   public int listPartTotal();
}
