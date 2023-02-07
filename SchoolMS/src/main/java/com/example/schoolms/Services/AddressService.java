package com.example.schoolms.Services;

import com.example.schoolms.Exceptions.ApiResponse;
import com.example.schoolms.Models.Address;
import com.example.schoolms.Models.Teacher;
import com.example.schoolms.Repositries.AddressRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepositry addressRepositry;
    private final Address address;

    public List<Address> getAddress(){
        return addressRepositry.findAll();
    }
    public void addAddress(Address a){
        addressRepositry.save(a);
    }
    public void updateAddress(Long id, Address a){
        Address oldAddress = addressRepositry.getById(id);
        if(oldAddress == null){
            throw new ApiResponse("Teacher not found");
        }
        oldAddress.setArea(a.getArea());
        oldAddress.setStreet(a.getStreet());
        oldAddress.setBuildingNumber(a.getBuildingNumber());
        addressRepositry.save(oldAddress);
    }

    public void deleteTeacher(Long id){
        Address oldAddress = addressRepositry.getById(id);
        if(oldAddress == null){
            throw new ApiResponse("Address not found");
        }
        addressRepositry.delete(oldAddress);
    }
}
