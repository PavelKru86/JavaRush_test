package javarush.test.service;

import javarush.test.dao.PartDao;
import javarush.test.modeldata.Part;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kryuchkov on 20.09.2018.
 */
@Service
public class PartServiceImpl implements PartService {
    private Part part;
    private PartDao partDao;
    private static int startPos = 0;
    private static int quantity = 10;
    private static int rev = 0;
    private static int srt = 0;
    private static int prev = 0;
    private static int nex = 0;

    public void setPartDao(PartDao partDao) {
        this.partDao = partDao;
    }

    @Transactional
    public void addPart(Part part) {
        this.partDao.addPart(part);
    }

    @Transactional
    public void updatePart(Part part) {
        this.partDao.updatePart(part);
    }

    @Transactional
    public void deletePart(int id) {
        this.partDao.deletePart(id);
    }

    @Transactional
    public Part getPartById(int id) {
        return this.partDao.getPartById(id);
    }

    @Transactional
    public List<Part> listParts() {
        return this.partDao.listParts();
    }

    @Transactional
    public void listSort(Part part) {
         this.partDao.listSort(part);
    }

    @Transactional
    public List<Part> listPartsByName(String name) {
        List<Part> list = this.partDao.listParts();
        List<Part> listName = new ArrayList<>();
        for (Part part : list) {
            if (part.getName().equals(name))
                listName.add(part);
        }
        return listName;
    }

    @Transactional
    public List<Part> listPartsPart() {
        List<Part> list = this.partDao.listParts();
        List<Part> listPart = new ArrayList<>();
        //startPos += 10;
       // if (startPos >= list.size())
         //   startPos = 0;
        srt = 0;
        for (int i = 0; i < quantity; i++) {
            if (i >= list.size())
                return listPart;
            listPart.add(list.get(i));
        }
        return listPart;
    }

    @Transactional
    public List<Part> listPartsNext() {
        List<Part> list = this.partDao.listParts();
        List<Part> listPart = new ArrayList<>();

        if (srt == 1) {
            nex = 1;
            srt = 0;
            List<Part> listPartS = listPartsSort();
            nex = 0;
            return listPartS;
        }
        else {
            startPos += 10;
            if (startPos >= list.size())
                startPos = 0;
            for (int i = startPos; i < (startPos + quantity); i++) {
                if (i >= list.size())
                    return listPart;
                listPart.add(list.get(i));
            }
            return listPart;
        }
    }

    //Previous
    @Transactional
    public List<Part> listPartsPrevious() {
        List<Part> list = this.partDao.listParts();
        List<Part> listPart = new ArrayList<>();

        if (srt == 1) {
            prev = 1;
            srt = 0;
            List<Part> listPartS = listPartsSort();
            prev = 0;
            return listPartS;
        }
        else {
            if (startPos == 0) {
                startPos = list.size() - 10;
                for (int i = startPos; i < (startPos + quantity); i++) {
               /* if (i < 0)
                    i = 0;*/
                    listPart.add(list.get(i));
                }
                return listPart;
            } else {
                startPos -= 10;

                if (startPos < 0)
                    startPos = 0;
                for (int i = startPos; i < (startPos + quantity); i++) {
               /* if (i < 0)
                    i = 0;*/
                    listPart.add(list.get(i));
                }
                return listPart;
            }
        }
    }

    //Total computer
    @Transactional
    public int listPartTotal() {
        List<Part> list = this.partDao.listParts();
        ArrayList<Integer> listPart = new ArrayList<>();
        for (Part part : list) {
            if (part.isNeed())
                listPart.add(part.getQuant());
        }
        return Collections.min(listPart);
    }

    @Transactional
    public List<Part> listPartsSort(){

        List<Part> list=this.partDao.listParts();
        List<Part> listPart=new ArrayList<>();
        List<Part> listPart_fin=new ArrayList<>();
        srt = 1;
        if (nex == 0 && prev == 0) {
            if (rev == 0) {
                list.sort(Comparator.comparing(Part::isNeed));
                rev = 1;
            } else {
                list.sort(Comparator.comparing(Part::isNeed).reversed());
                rev = 0;
            }

            if(startPos>=list.size())
                startPos=0;
          /*  for(int i=1;i<list.size();i++){
                if(i>=list.size())
                    return listPart;
                listPart.add(list.get(i));
            }*/

            for(int i=0;i<(quantity);i++){
                /*if(i>=list.size())
                    return listPart_fin;*/
                listPart_fin.add(list.get(i));
            }

            return listPart_fin;
        }

        else if (nex == 1) {


            if (rev == 0) {
                list.sort(Comparator.comparing(Part::isNeed).reversed());


            } else {
                list.sort(Comparator.comparing(Part::isNeed));


            }
           /* for(int i=1;i<list.size();i++){
                if(i>=list.size())
                    return listPart;
                listPart.add(list.get(i));
            }*/
            startPos += 10;
            if(startPos>=list.size())
                startPos=0;
            for(int i=startPos;i<(startPos+quantity);i++){
                if(i>=list.size())
                    return listPart_fin;
                listPart_fin.add(list.get(i));
            }

            return listPart_fin;
        }
        else {
            if (rev == 0) {
                list.sort(Comparator.comparing(Part::isNeed).reversed());

            } else {
                list.sort(Comparator.comparing(Part::isNeed));


            }
            if (startPos == 0) {
                startPos = list.size() - 10;
                for (int i = startPos; i < (startPos + quantity); i++) {
               /* if (i < 0)
                    i = 0;*/
                    listPart.add(list.get(i));
                }
                return listPart;
            } else {
                startPos -= 10;

                if (startPos < 0)
                    startPos = 0;
                for (int i = startPos; i < (startPos + quantity); i++) {
               /* if (i < 0)
                    i = 0;*/
                    listPart.add(list.get(i));
                }
                return listPart;
            }
        }

    }


}
