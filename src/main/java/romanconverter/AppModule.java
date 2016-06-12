package romanconverter;

import java.io.IOException;
import java.nio.file.Paths;

import javax.inject.Named;

import restx.RestxContext;
import restx.RestxFilter;
import restx.RestxHandler;
import restx.RestxHandlerMatch;
import restx.RestxRequest;
import restx.RestxRequestMatch;
import restx.RestxResponse;
import restx.StdRestxRequestMatch;
import restx.config.ConfigLoader;
import restx.config.ConfigSupplier;
import restx.factory.Module;
import restx.factory.Provides;
import restx.http.HttpStatus;
import restx.security.BCryptCredentialsStrategy;
import restx.security.BasicPrincipalAuthenticator;
import restx.security.CredentialsStrategy;
import restx.security.FileBasedUserRepository;
import restx.security.SecuritySettings;
import restx.security.SignatureKey;
import restx.security.StdBasicPrincipalAuthenticator;
import restx.security.StdUser;
import restx.security.StdUserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

@Module
public class AppModule {
    @Provides
    public SignatureKey signatureKey() {
         return new SignatureKey("a1f94f36-81ea-4e29-9cf1-edfa1e07c5ef romanconverter RomanConverter 8604691410573591389".getBytes(Charsets.UTF_8));
    }

    @Provides
    @Named("restx.admin.password")
    public String restxAdminPassword() {
        return "1234";
    }

    @Provides
    public ConfigSupplier appConfigSupplier(ConfigLoader configLoader) {
        // Load settings.properties in romanconverter package as a set of config entries
        return configLoader.fromResource("romanconverter/settings");
    }

    @Provides
    public CredentialsStrategy credentialsStrategy() {
        return new BCryptCredentialsStrategy();
    }
    
    @Provides @Named("restx.activation::restx.security.CORSFilter::CORSFilter")
    public String disableCorsFilter() {
        return "false";
    }
    
    @Provides
    public RestxFilter getCorsAuthorizerFilter() {
        return new RestxFilter() {
            @Override
            public Optional<RestxHandlerMatch> match(RestxRequest r) {
                return RestxHandlerMatch.of(Optional.of(new StdRestxRequestMatch(r.getRestxPath())),
                        new RestxHandler() {

							@Override
							public void handle(
									RestxRequestMatch paramRestxRequestMatch,
									RestxRequest paramRestxRequest,
									RestxResponse paramRestxResponse,
									RestxContext paramRestxContext)
									throws IOException {
								Optional<String> origin = paramRestxRequest.getHeader("Origin");
                                if (origin.isPresent()) {
                                	paramRestxResponse.setHeader("Access-Control-Allow-Origin", origin.get());
                                	paramRestxResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
                                	paramRestxResponse.setHeader("Access-Control-Allow-Credentials", Boolean.TRUE.toString());
                                	paramRestxResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

                                    if ("OPTIONS".equals(paramRestxRequest.getHttpMethod())) {
                                    	paramRestxResponse.setStatus(HttpStatus.OK);
                                    } else {
                                    	paramRestxContext.nextHandlerMatch().handle(paramRestxRequest, paramRestxResponse, paramRestxContext);
                                    }
                                } else {
                                	paramRestxContext.nextHandlerMatch().handle(paramRestxRequest, paramRestxResponse, paramRestxContext);
                                }
								
							}
                        }
                );
            }
        };
    }

    @Provides
    public BasicPrincipalAuthenticator basicPrincipalAuthenticator(
            SecuritySettings securitySettings, CredentialsStrategy credentialsStrategy,
            @Named("restx.admin.passwordHash") String defaultAdminPasswordHash, ObjectMapper mapper) {
        return new StdBasicPrincipalAuthenticator(new StdUserService<>(
                // use file based users repository.
                // Developer's note: prefer another storage mechanism for your users if you need real user management
                // and better perf
                new FileBasedUserRepository<>(
                        StdUser.class, // this is the class for the User objects, that you can get in your app code
                        // with RestxSession.current().getPrincipal().get()
                        // it can be a custom user class, it just need to be json deserializable
                        mapper,

                        // this is the default restx admin, useful to access the restx admin console.
                        // if one user with restx-admin role is defined in the repository, this default user won't be
                        // available anymore
                        new StdUser("admin", ImmutableSet.<String>of("*")),

                        // the path where users are stored
                        Paths.get("data/users.json"),

                        // the path where credentials are stored. isolating both is a good practice in terms of security
                        // it is strongly recommended to follow this approach even if you use your own repository
                        Paths.get("data/credentials.json"),

                        // tells that we want to reload the files dynamically if they are touched.
                        // this has a performance impact, if you know your users / credentials never change without a
                        // restart you can disable this to get better perfs
                        true),
                credentialsStrategy, defaultAdminPasswordHash),
                securitySettings);
    }
}
