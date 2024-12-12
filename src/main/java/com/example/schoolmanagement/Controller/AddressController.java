package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity get (){
        return ResponseEntity.status(200).body(addressService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add (@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse( "update successfully"));
    }
}
