package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor;

@Machine
public class HelloResourceRulesValidCompanyRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor> {
    public static final Name<romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor> NAME = Name.of(romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor.class, "HelloResourceRulesValidCompanyRefDescriptor");

    public HelloResourceRulesValidCompanyRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.HelloResourceRulesValidCompanyRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new HelloResourceRulesValidCompanyRefDescriptor(

                );
            }
        });
    }

}
