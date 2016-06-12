package romanconverter.rest;

import com.google.common.collect.ImmutableMap;
import restx.exceptions.*;
import restx.factory.*;


@Component
public final class HelloResourceRulesCompanyRefDescriptor extends ErrorDescriptor {
    public HelloResourceRulesCompanyRefDescriptor() {
        super(
            400,
            "USER-001",
            "must have a company",
            ImmutableMap.<String, ErrorFieldDescriptor>builder()
                .put("KEY", new ErrorDescriptor.ErrorFieldDescriptor("KEY", "user key"))
                .build()
        );
    }
}
