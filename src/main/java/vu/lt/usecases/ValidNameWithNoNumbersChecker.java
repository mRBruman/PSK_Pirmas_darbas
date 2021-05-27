package vu.lt.usecases;

import javax.enterprise.inject.Specializes;

@Specializes
public class ValidNameWithNoNumbersChecker extends ValidNameChecker{
    public boolean isValidName(String companyName) {
        if (companyName.length() < 3) {
            return false;
        }
        else {
            if(companyName.matches(".*\\d.*"))
                return false;
        }
        return true;
    }
}
