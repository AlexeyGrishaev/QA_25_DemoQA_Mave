package dto;

import enums.Gender;
import enums.Hobbies;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

public class StudentLombok {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobile;
    private String dateOfBirth;
    private String subject;
    private List<Hobbies> hobbies;
    private String currentAddress;
    private String state;
    private String city;

}
