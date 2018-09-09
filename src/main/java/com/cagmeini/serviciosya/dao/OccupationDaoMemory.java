
package com.cagmeini.serviciosya.dao;


import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.*;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public class OccupationDaoMemory implements IOccupationDao {


    private Map<String, Occupation> occupations;


    public OccupationDaoMemory() {

        super ();

        this.occupations = new TreeMap<>();

        // Load occupations.
        Occupation o1 = new Occupation (randomAlphabetic(5),
                                        "Encantador de Serpientes",
                                    "Encantador de Serpientes");

        Occupation o2 = new Occupation (randomAlphabetic(5),
                                       "Cuidador de Suegras",
                                   "Cuidador de Suegras");

        // Add values to map.
        this.occupations.put (o1.getId (), o1);
        this.occupations.put (o2.getId (), o2);
    }

    @Override
    public List<Occupation> findAllOccupations () {

        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {

            list.add (item.getValue ());
        }

        // Return the occupations.
        return list;
    }

    @Override
    public void add (Occupation occupation) {
        this.occupations.put (occupation.getId (), occupation);
    }

    @Override
    public Occupation searchById(String id){
        return occupations.get(id);
    }
    @Override
    public  void deleteById (String id){
        this.occupations.remove(id);
    }
    @Override
    public void updateById(String id, Occupation newOccupation){
        this.occupations.replace(id,newOccupation);
    }

}