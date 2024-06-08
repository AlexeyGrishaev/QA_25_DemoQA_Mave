package dto;

import enums.Gender;
import enums.Hobbies;
import lombok.*;

import java.util.List;
import java.util.Objects;

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
    private String subjects;
    private List<Hobbies> hobbies;
    private String currentAddress;
    private String state;
    private String city;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentLombok that = (StudentLombok) o;
        return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && gender == that.gender && Objects.equals(mobile, that.mobile) && Objects.equals(subjects, that.subjects) && Objects.equals(currentAddress, that.currentAddress) && Objects.equals(state, that.state) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, gender, mobile, subjects, currentAddress, state, city);
    }
}
