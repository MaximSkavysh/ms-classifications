package com.lobster.data.jpa.entity.localization;

import com.lobster.constants.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class CommonLocalization extends Localization {
    @Size(max = 100)
    private String value;

    public CommonLocalization(String lang, String value) {
        super(lang);
        validate(value);
    }

    private void validate(String value) {
        this.value = (value != null && value.length() > Constants.Validation.NAME_LENGTH.getLength())
                ? this.value.substring(0, Constants.Validation.NAME_LENGTH.getLength()) : value;
    }

    public static <T extends Localization> Map<String, String> localizationsToMap(Set<T> localizations,
                                                                                  Function<T, String> mappingFunc) {
        return !CollectionUtils.isEmpty(localizations)
                ? localizations.stream()
                .collect(HashMap::new,
                        (map, value) -> {
                            String val = mappingFunc.apply(value);
                            if (val != null) {
                                map.put(value.getLang(), val);
                            }
                        },
                        HashMap::putAll)
                : Map.of();
    }

    public static Set<CommonLocalization> localizationMapToSet(Map<String, String> names){
        return names.entrySet()
                .stream()
                .map(stringStringEntry -> new CommonLocalization(stringStringEntry.getKey(), stringStringEntry.getValue()))
                .collect(Collectors.toSet());
    }
}
