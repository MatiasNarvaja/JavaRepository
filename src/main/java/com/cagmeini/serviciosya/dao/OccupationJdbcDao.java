package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

  @Override
  public List<Occupation> findAllOccupations() {
    return null;
  }

  @Override
  public void add(Occupation occupation) {

  }

  @Override
  public Occupation searchById(String id) {
    return null;
  }

  @Override
  public void deleteById(String id) {

  }
  @Override
  public void updateById (String id , Occupation updateOccupation){

  }
}
