package romanconverter.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Optional;
import static com.google.common.base.Preconditions.checkNotNull;

import restx.common.Types;
import restx.*;
import restx.entity.*;
import restx.http.*;
import restx.factory.*;
import restx.security.*;
import static restx.security.Permissions.*;
import restx.description.*;
import restx.converters.MainStringConverter;
import static restx.common.MorePreconditions.checkPresent;

import javax.validation.Validator;
import static restx.validation.Validations.checkValid;

import java.io.IOException;
import java.io.PrintWriter;

@Component(priority = 0)

public class HelloResourceRouter extends RestxRouter {

    public HelloResourceRouter(
                    final HelloResource resource,
                    final EntityRequestBodyReaderRegistry readerRegistry,
                    final EntityResponseWriterRegistry writerRegistry,
                    final MainStringConverter converter,
                    final Optional<Validator> validator,
                    final RestxSecurityManager securityManager) {
        super(
            "default", "HelloResourceRouter", new RestxRoute[] {
        new StdEntityRoute<Void, romanconverter.domain.Message>("default#HelloResource#convertToRoman",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<romanconverter.domain.Message>build(romanconverter.domain.Message.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/convertToRoman"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<romanconverter.domain.Message> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.convertToRoman(
                        /* [QUERY] arabic */ converter.convert(checkPresent(request.getQueryParam("arabic"), "query param arabic is required"), java.lang.Integer.class)
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription arabic = new OperationParameterDescription();
                arabic.name = "arabic";
                arabic.paramType = OperationParameterDescription.ParamType.query;
                arabic.dataType = "int";
                arabic.schemaKey = "";
                arabic.required = true;
                operation.parameters.add(arabic);


                operation.responseClass = "Message";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "romanconverter.domain.Message";
                operation.sourceLocation = "romanconverter.rest.HelloResource#convertToRoman(java.lang.Integer)";
            }
        },
        new StdEntityRoute<Void, java.lang.Integer>("default#HelloResource#convertToArabic",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<java.lang.Integer>build(java.lang.Integer.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/convertToArabic"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<java.lang.Integer> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.convertToArabic(
                        /* [QUERY] roman */ checkPresent(request.getQueryParam("roman"), "query param roman is required")
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription roman = new OperationParameterDescription();
                roman.name = "roman";
                roman.paramType = OperationParameterDescription.ParamType.query;
                roman.dataType = "string";
                roman.schemaKey = "";
                roman.required = true;
                operation.parameters.add(roman);


                operation.responseClass = "int";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "";
                operation.sourceLocation = "romanconverter.rest.HelloResource#convertToArabic(java.lang.String)";
            }
        },
        });
    }

}
