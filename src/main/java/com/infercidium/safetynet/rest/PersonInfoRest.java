package com.infercidium.safetynet.rest;

import com.infercidium.safetynet.dto.PersonInfoDTO;
import com.infercidium.safetynet.mapper.PersonInfoMapper;
import com.infercidium.safetynet.model.MedicalRecords;
import com.infercidium.safetynet.service.MedicalRecordsI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfoRest {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(PersonInfoRest.class);

    private final MedicalRecordsI medicalRecordsI;
    private final PersonInfoMapper personInfoM;

    public PersonInfoRest(final MedicalRecordsI medicalRecordsIn,
                          final PersonInfoMapper personInfoMa) {
        this.medicalRecordsI = medicalRecordsIn;
        this.personInfoM = personInfoMa;
    }

    /**
     * This url allows to have the complete information of a person.
     * @param firstName : allows you to find the resource in the database.
     * @param lastName : allows you to find the resource in the database.
     * @return personInfoDTO and 200 Ok if successful
     * or 404 not found if it does not exist.
     */
    @GetMapping(value = "personInfo")
    public PersonInfoDTO getPersonInfo(@RequestParam final String firstName,
                                       @RequestParam final String lastName) {
        MedicalRecords medicalRecords
                = medicalRecordsI.getMedicalRecordName(firstName, lastName);
        LOGGER.info("Person information " + firstName
                + " " + lastName + " found");
        return personInfoM.modelToDto(medicalRecords);
    }
}
