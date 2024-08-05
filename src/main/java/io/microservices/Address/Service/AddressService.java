package io.microservices.Address.Service;

import io.microservices.Address.Repository.AddressRepository;
import io.microservices.Address.model.Address;
import io.microservices.Configuration.UserContext;
import io.microservices.User.model.User;
import io.microservices.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Address getAddress(Long id){
        Optional<Address> mayBeAddress = addressRepository.findById(id);
        return mayBeAddress.orElse(null);
    }

    public Optional<Address> getAddressById(Long id){
        return addressRepository.findById(id);
    }

    public void updateAddress(Long id, Address updatedAddress) throws Exception {
        Optional<Address> maybeAddress = addressRepository.findById(id);


        if(maybeAddress.isPresent()){

            Address oldAddress = maybeAddress.get();
            oldAddress.setStreet(updatedAddress.getStreet());
            oldAddress.setCity(updatedAddress.getCity());
            oldAddress.setState(updatedAddress.getState());
            oldAddress.setCountry(updatedAddress.getCountry());
            oldAddress.setPincode(updatedAddress.getPincode());
            oldAddress.setAddressType(updatedAddress.getAddressType());
            addressRepository.save(oldAddress);
        }else{
            throw new Exception("Address Not Found");
        }

    }


    public Address saveAddress( Address address) throws Exception  {

        Long userId = UserContext.getUserId();

        User user = userRepository.findById(userId).orElseThrow( () -> new Exception("User does not exists"));
              address.setUser(user);

        return addressRepository.save(address);
    }

    public void deleteAddress(Long id){

        boolean addressExist = addressRepository.existsById(id);

        if(addressExist){
            addressRepository.deleteById(id);
        }

    }
}
