package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.ConverterResourceRouter;

@Machine
public class ConverterResourceRouterFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.ConverterResourceRouter> {
    public static final Name<romanconverter.rest.ConverterResourceRouter> NAME = Name.of(romanconverter.rest.ConverterResourceRouter.class, "ConverterResourceRouter");

    public ConverterResourceRouterFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.ConverterResourceRouter>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<romanconverter.rest.ConverterResource> resource = Factory.Query.byClass(romanconverter.rest.ConverterResource.class).mandatory();
private final Factory.Query<restx.entity.EntityRequestBodyReaderRegistry> readerRegistry = Factory.Query.byClass(restx.entity.EntityRequestBodyReaderRegistry.class).mandatory();
private final Factory.Query<restx.entity.EntityResponseWriterRegistry> writerRegistry = Factory.Query.byClass(restx.entity.EntityResponseWriterRegistry.class).mandatory();
private final Factory.Query<restx.converters.MainStringConverter> converter = Factory.Query.byClass(restx.converters.MainStringConverter.class).mandatory();
private final Factory.Query<javax.validation.Validator> validator = Factory.Query.byClass(javax.validation.Validator.class).optional();
private final Factory.Query<restx.security.RestxSecurityManager> securityManager = Factory.Query.byClass(restx.security.RestxSecurityManager.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
resource,
readerRegistry,
writerRegistry,
converter,
validator,
securityManager
                ));
            }

            @Override
            protected romanconverter.rest.ConverterResourceRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new ConverterResourceRouter(
satisfiedBOM.getOne(resource).get().getComponent(),
satisfiedBOM.getOne(readerRegistry).get().getComponent(),
satisfiedBOM.getOne(writerRegistry).get().getComponent(),
satisfiedBOM.getOne(converter).get().getComponent(),
satisfiedBOM.getOneAsComponent(validator),
satisfiedBOM.getOne(securityManager).get().getComponent()
                );
            }
        });
    }

}
