package vu.lt.usecases;

import javax.enterprise.inject.Specializes;

@Specializes
public class ExtendedNameValidator extends NameValidator {
    public boolean isValidName(String companyName) {
        if (companyName.length() < 3) {
            return false;
        }
        else {
            if(companyName.matches(".*[^A-Za-z].*"))
                return false;
        }
        return true;
    }
}
