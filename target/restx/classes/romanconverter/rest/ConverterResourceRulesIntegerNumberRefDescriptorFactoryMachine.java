package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor;

@Machine
public class ConverterResourceRulesIntegerNumberRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor> {
    public static final Name<romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor> NAME = Name.of(romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor.class, "ConverterResourceRulesIntegerNumberRefDescriptor");

    public ConverterResourceRulesIntegerNumberRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.ConverterResourceRulesIntegerNumberRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new ConverterResourceRulesIntegerNumberRefDescriptor(

                );
            }
        });
    }

}
