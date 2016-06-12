package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor;

@Machine
public class HelloResourceRulesRomanNumberRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor> {
    public static final Name<romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor> NAME = Name.of(romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor.class, "HelloResourceRulesRomanNumberRefDescriptor");

    public HelloResourceRulesRomanNumberRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.HelloResourceRulesRomanNumberRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new HelloResourceRulesRomanNumberRefDescriptor(

                );
            }
        });
    }

}
