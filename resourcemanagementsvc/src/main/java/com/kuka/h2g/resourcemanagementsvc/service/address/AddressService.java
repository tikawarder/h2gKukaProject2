package com.kuka.h2g.resourcemanagementsvc.service.address;

import com.kuka.h2g.resourcemanagementsvc.dal.dao.address.AddressDao;
import com.kuka.h2g.resourcemanagementsvc.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public Address update (Address address){
        return addressDao.save(address);
    }

    public Address save (Address address){
        return addressDao.save(address);
    }

    public Address findById (long id) {
        return addressDao.findById(id);
    }

    public List<Address> findAll(){
        return addressDao.findAll();
    }

    public boolean delete (Address address){
        return addressDao.delete(address);
    }

    public boolean deleteById (long id){
        return addressDao.deleteById(id);
    }

    public List<Address> findByCity (String city){
        return addressDao.findByCity(city);
    }
}
