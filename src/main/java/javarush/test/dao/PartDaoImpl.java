package javarush.test.dao;

import javarush.test.modeldata.Part;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kryuchkov on 20.09.2018.
 */

@Repository
public class PartDaoImpl implements PartDao {
    private static final Logger logger= LoggerFactory.getLogger(PartDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPart(Part part) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(part);
        logger.info("Part successfully added! Part info: "+ part);
    }

    public void updatePart(Part part) {
         Session session=this.sessionFactory.getCurrentSession();
         session.update(part);
         logger.info("Part successfully updated! Part info: "+ part);
    }

    public void deletePart(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Part part =(Part) session.load(Part.class,new Integer(id));
        if(part !=null){
            session.delete(part);
        }
            logger.info("Part successfully deleted! Part info: "+ part);
    }

    public Part getPartById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Part part =(Part)session.load(Part.class,new Integer(id));
           logger.info("Part successfully loaded! Part info: "+ part);
        return part;
    }



    public List<Part> listParts() {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(Part.class);
        List<Part> partList =criteria.list();
         for(Part part : partList){
             logger.info("Part list "+ part);
         }
         return partList;
    }
    public void listSort(Part part) {
        Session session=this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(part.getClass()).addOrder(Order.asc("Need"));
       /* List<Part> PartList=criteria.list();
        for(Part part:PartList){
            logger.info("Part list "+part);
        }
        return PartList;*/
    }

}
