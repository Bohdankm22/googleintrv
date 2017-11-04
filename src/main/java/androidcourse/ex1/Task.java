package androidcourse.ex1;

import java.util.HashMap;
import java.util.Map;

public class Task {

    private static final Map<String, String> CODE_COUNTRY_MAPPING = new HashMap<>();
    static {
        CODE_COUNTRY_MAPPING.put("AFG", "Afghanistan");
        CODE_COUNTRY_MAPPING.put("ALA", "Aland Islands");
        CODE_COUNTRY_MAPPING.put("ALB", "Albania");
        CODE_COUNTRY_MAPPING.put("DZA", "Algeria");
        CODE_COUNTRY_MAPPING.put("ASM", "American Samoa");
        CODE_COUNTRY_MAPPING.put("AND", "Andorra");
        CODE_COUNTRY_MAPPING.put("UKR", "Ukraine");
    }

    /**
     * Gives the name of the county if 3-letter country code sent in parameters.
     * If the argument is longer then 3 it assumes that county name provided and returns the country 3-letter code.
     * @param codeOrCountry 3-letter country code or country name.
     * @return country name or 3-letter country code.
     */
    public static String getCountryOrCode(String codeOrCountry) {
        if (codeOrCountry.length() < 3) {
            throw new IllegalArgumentException("Country code or name should be longer 2 symbols.");
        }
        if (codeOrCountry.length() == 3) {
            if (CODE_COUNTRY_MAPPING.containsKey(codeOrCountry)) {
                return CODE_COUNTRY_MAPPING.get(codeOrCountry);
            }
        } else {
            for (Map.Entry<String, String> entry: CODE_COUNTRY_MAPPING.entrySet()) {
                if (codeOrCountry.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
        }
        throw new RuntimeException("The 3-letter country code or country was not found in the database.");
    }
}