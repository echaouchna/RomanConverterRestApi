package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.ConverterResource;

@Machine
public class ConverterResourceFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.ConverterResource> {
    public static final Name<romanconverter.rest.ConverterResource> NAME = Name.of(romanconverter.rest.ConverterResource.class, "ConverterResource");

    public ConverterResourceFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.ConverterResource>(NAME, 0, BoundlessComponentBox.FACTORY) {
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
            protected romanconverter.rest.ConverterResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new ConverterResource(
satisfiedBOM.getOne(errors).get().getComponent(),
satisfiedBOM.getOne(romanConverterService).get().getComponent()
                );
            }
        });
    }

}
