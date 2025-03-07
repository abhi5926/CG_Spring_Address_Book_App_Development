package com.example.AddressBook.modelmapper;


import com.example.AddressBook.dto.AddressBookDto;
import com.example.AddressBook.model.AddressBook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressBookMapper {

    private final ModelMapper modelMapper;

    public AddressBookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AddressBookDto toDto(AddressBook addressBook) {
        return modelMapper.map(addressBook, AddressBookDto.class);
    }

    public List<AddressBookDto> toDtoList(List<AddressBook> addressBooks) {
        return addressBooks.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AddressBook toEntity(AddressBookDto addressBookDTO) {
        return modelMapper.map(addressBookDTO, AddressBook.class);
    }
}