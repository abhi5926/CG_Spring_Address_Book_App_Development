package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDto;
import com.example.AddressBook.model.AddressBook;
import com.example.AddressBook.modelmapper.AddressBookMapper;
import com.example.AddressBook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressBookService {

    private final AddressBookRepository addressBookRepository;
    private final AddressBookMapper addressBookMapper;

    @Autowired
    public AddressBookService(AddressBookRepository addressBookRepository, AddressBookMapper addressBookMapper) {
        this.addressBookRepository = addressBookRepository;
        this.addressBookMapper = addressBookMapper;
    }

    public List<AddressBookDto> getAllAddressBook() {
        List<AddressBook> addressBooks = addressBookRepository.findAll();
        return addressBookMapper.toDtoList(addressBooks);
    }

    public AddressBookDto getAddressBookById(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        return addressBookMapper.toDto(addressBook);
    }

    public AddressBookDto createAddressBook(AddressBookDto addressBookDTO) {
        AddressBook addressBook = addressBookMapper.toEntity(addressBookDTO);
        AddressBook savedAddressBook = addressBookRepository.save(addressBook);
        return addressBookMapper.toDto(savedAddressBook);
    }

    public AddressBookDto updateAddressBook(Long id, AddressBookDto addressBookDTO) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        if (addressBook != null) {
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setZip(addressBookDTO.getZip());
            AddressBook savedAddressBook = addressBookRepository.save(addressBook);
            return addressBookMapper.toDto(savedAddressBook);
        } else {
            return null;
        }
    }

    public void deleteAddressBook(Long id) {
        addressBookRepository.deleteById(id);
    }
}
