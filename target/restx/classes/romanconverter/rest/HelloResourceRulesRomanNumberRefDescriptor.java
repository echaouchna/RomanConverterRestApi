package romanconverter.rest;

import com.google.common.collect.ImmutableMap;
import restx.exceptions.*;
import restx.factory.*;


@Component
public final class HelloResourceRulesRomanNumberRefDescriptor extends ErrorDescriptor {
    public HelloResourceRulesRomanNumberRefDescriptor() {
        super(
            400,
            "ROMAN-CONVERTER-002",
            "Not a roman number",
            ImmutableMap.<String, ErrorFieldDescriptor>builder()
                .put("KEY", new ErrorDescriptor.ErrorFieldDescriptor("KEY", "number"))
                .build()
        );
    }
}
