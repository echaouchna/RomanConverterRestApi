package romanconverter.rest;

import com.google.common.collect.ImmutableMap;
import restx.exceptions.*;
import restx.factory.*;


@Component
public final class HelloResourceRulesIntegerNumberRefDescriptor extends ErrorDescriptor {
    public HelloResourceRulesIntegerNumberRefDescriptor() {
        super(
            400,
            "ROMAN-CONVERTER-001",
            "Number out of range 1-3999",
            ImmutableMap.<String, ErrorFieldDescriptor>builder()
                .put("KEY", new ErrorDescriptor.ErrorFieldDescriptor("KEY", "number"))
                .build()
        );
    }
}
