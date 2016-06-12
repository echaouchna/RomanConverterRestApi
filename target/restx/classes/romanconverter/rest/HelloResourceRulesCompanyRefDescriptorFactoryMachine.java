package romanconverter.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.rest.HelloResourceRulesCompanyRefDescriptor;

@Machine
public class HelloResourceRulesCompanyRefDescriptorFactoryMachine extends SingleNameFactoryMachine<romanconverter.rest.HelloResourceRulesCompanyRefDescriptor> {
    public static final Name<romanconverter.rest.HelloResourceRulesCompanyRefDescriptor> NAME = Name.of(romanconverter.rest.HelloResourceRulesCompanyRefDescriptor.class, "HelloResourceRulesCompanyRefDescriptor");

    public HelloResourceRulesCompanyRefDescriptorFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.rest.HelloResourceRulesCompanyRefDescriptor>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.rest.HelloResourceRulesCompanyRefDescriptor doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new HelloResourceRulesCompanyRefDescriptor(

                );
            }
        });
    }

}
