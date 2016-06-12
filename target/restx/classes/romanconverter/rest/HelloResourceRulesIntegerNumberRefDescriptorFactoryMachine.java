package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor;

@Machine
public class HelloResourceRulesIntegerNumberRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor> {
    public static final Name<romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor> NAME = Name.of(romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor.class, "HelloResourceRulesIntegerNumberRefDescriptor");

    public HelloResourceRulesIntegerNumberRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.HelloResourceRulesIntegerNumberRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new HelloResourceRulesIntegerNumberRefDescriptor(

                );
            }
        });
    }

}
