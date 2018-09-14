package javarush.test.dao;

import javarush.test.modeldata.Part;

import java.util.List;

/**
 * Created by Kryuchkov on 20.09.2018.
 */
public interface PartDao {
    public void addPart(Part part);
    public void updatePart(Part part);
    public void deletePart(int id);
    public Part getPartById(int id);
    public List<Part> listParts();
    public void listSort(Part part);
}
