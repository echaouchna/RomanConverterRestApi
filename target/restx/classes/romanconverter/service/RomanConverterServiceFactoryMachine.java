package romanconverter.service;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import romanconverter.service.RomanConverterService;

@Machine
public class RomanConverterServiceFactoryMachine extends SingleNameFactoryMachine<romanconverter.service.RomanConverterService> {
    public static final Name<romanconverter.service.RomanConverterService> NAME = Name.of(romanconverter.service.RomanConverterService.class, "RomanConverterService");

    public RomanConverterServiceFactoryMachine() {
        super(0, new StdMachineEngine<romanconverter.service.RomanConverterService>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected romanconverter.service.RomanConverterService doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new RomanConverterService(

                );
            }
        });
    }

}
