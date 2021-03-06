
package com.cagmeini.serviciosya.service.test;


import java.util.List;

import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.OccupationDaoMemory;
import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.service.OccupationService;


public class OccupationServiceTest {


    private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao = new OccupationDaoMemory ();


    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {
        this.occupationService.setOccupationDao (this.occupationDao);
        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");
        List<Occupation> init = this.occupationDao.findAllOccupations ();
        this.occupationService.addOccupation (o);
        List<Occupation> end = this.occupationDao.findAllOccupations ();
        Assert.assertTrue (init.size()+1 == end.size());
    }

    @Test
    public void testSearchById(){
        this.occupationService.setOccupationDao (this.occupationDao);
        Occupation newOccupation = new Occupation ("1", "Catador de Ron", "Beber alcohol...");
        this.occupationService.addOccupation (newOccupation);
        Occupation foundedOccupation =  this.occupationDao.searchById("1");
        Assert.assertTrue(newOccupation.equals(foundedOccupation));
    }
    @Test
    public void testDeleteById(){
        this.occupationService.setOccupationDao (this.occupationDao);
        Occupation newOccupation = new Occupation ("1", "Catador de Ron", "Beber alcohol...");
        this.occupationService.addOccupation(newOccupation);
        this.occupationDao.deleteById("1");
        Assert.assertTrue(this.occupationDao.searchById("1")== null);


    }

    @Test
    public void testUpdateById (){
        this.occupationService.setOccupationDao (this.occupationDao);
        Occupation initialOccupation = new Occupation ("1", "Catador de Ron", "Beber alcohol...");
        this.occupationService.addOccupation(initialOccupation);
        Occupation newOccupation = new Occupation("2","Desarrollador","Desarrollar aplicaciones...");
        this.occupationDao.updateById("1",newOccupation);
        Assert.assertFalse(this.occupationDao.searchById("1").equals(initialOccupation));



    }


}