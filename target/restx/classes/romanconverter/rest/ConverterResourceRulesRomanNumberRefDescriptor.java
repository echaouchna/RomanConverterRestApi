package romanconverter.rest;

import com.google.common.collect.ImmutableMap;
import restx.exceptions.*;
import restx.factory.*;


@Component
public final class ConverterResourceRulesRomanNumberRefDescriptor extends ErrorDescriptor {
    public ConverterResourceRulesRomanNumberRefDescriptor() {
        super(
            400,
            "ROMAN-CONVERTER-ERROR-002",
            "Not a roman number",
            ImmutableMap.<String, ErrorFieldDescriptor>builder()
                .put("KEY", new ErrorDescriptor.ErrorFieldDescriptor("KEY", "number"))
                .build()
        );
    }
}
