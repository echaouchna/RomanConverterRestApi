package romanconverter.rest;

import com.google.common.collect.ImmutableMap;
import restx.exceptions.*;
import restx.factory.*;


@Component
public final class HelloResourceRulesValidCompanyRefDescriptor extends ErrorDescriptor {
    public HelloResourceRulesValidCompanyRefDescriptor() {
        super(
            400,
            "USER-002",
            "must have valid company - provided company key not found",
            ImmutableMap.<String, ErrorFieldDescriptor>builder()
                .put("KEY", new ErrorDescriptor.ErrorFieldDescriptor("KEY", "user key"))
.put("COMPANY_REF", new ErrorDescriptor.ErrorFieldDescriptor("COMPANY_REF", "company ref"))
                .build()
        );
    }
}
