package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.HelloResource;

@Machine
public class HelloResourceFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.HelloResource> {
    public static final Name<romanconverter.rest.HelloResource> NAME = Name.of(romanconverter.rest.HelloResource.class, "HelloResource");

    public HelloResourceFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.HelloResource>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<restx.exceptions.RestxErrors> errors = Factory.Query.byClass(restx.exceptions.RestxErrors.class).mandatory();
private final Factory.Query<romanconverter.service.RomanConverterService> romanConverterService = Factory.Query.byClass(romanconverter.service.RomanConverterService.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
errors,
romanConverterService
                ));
            }

            @Override
            protected romanconverter.rest.HelloResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new HelloResource(
satisfiedBOM.getOne(errors).get().getComponent(),
satisfiedBOM.getOne(romanConverterService).get().getComponent()
                );
            }
        });
    }

}
