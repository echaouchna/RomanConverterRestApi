package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor;

@Machine
public class ConverterResourceRulesRomanNumberRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor> {
    public static final Name<romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor> NAME = Name.of(romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor.class, "ConverterResourceRulesRomanNumberRefDescriptor");

    public ConverterResourceRulesRomanNumberRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.ConverterResourceRulesRomanNumberRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new ConverterResourceRulesRomanNumberRefDescriptor(

                );
            }
        });
    }

}
