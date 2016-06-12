package romanconverter.rest;

import restx.annotations.GET;
import restx.annotations.RestxResource;
import restx.exceptions.ErrorCode;
import restx.exceptions.ErrorField;
import restx.exceptions.RestxErrors;
import restx.factory.Component;
import restx.security.PermitAll;
import romanconverter.domain.Message;
import romanconverter.service.RomanConverterService;
import exceptions.NotRomanNumeralException;
import exceptions.NumberOutOfRangeException;

@Component @RestxResource
public class HelloResource {
	
	private final RestxErrors errors;
	private final RomanConverterService romanConverterService;
	
	public HelloResource(RestxErrors errors, RomanConverterService romanConverterService) {
		this.errors = errors;
		this.romanConverterService = romanConverterService;
	}
	
	public static class Rules {
	    @ErrorCode(code = "ROMAN-CONVERTER-001", description = "Number out of range 1-3999")
	    public static enum IntegerNumberRef {
	        @ErrorField("number") KEY
	    }
	    @ErrorCode(code = "ROMAN-CONVERTER-002", description = "Not a roman number")
	    public static enum RomanNumberRef {
	        @ErrorField("number") KEY
	    }
	}
    
    /**
     * Say hello to anybody.
     *
     * Does not require authentication.
     *
     * @return a Message to say hello
     * @throws NumberOutOfRangeException 
     */
    @GET("/convertToRoman")
    @PermitAll
    public Message convertToRoman(Integer arabic) {
    	try {
			return new Message().setMessage(romanConverterService.getRomanNumber(arabic));
		} catch (NumberOutOfRangeException e) {
			throw errors.on(Rules.IntegerNumberRef.class)
            .set(Rules.IntegerNumberRef.KEY, "")
            .raise();
		}
    }
    
    /**
     * Say hello to anybody.
     *
     * Does not require authentication.
     *
     * @return a Message to say hello
     * @throws NumberOutOfRangeException 
     */
    @GET("/convertToArabic")
    @PermitAll
    public Integer convertToArabic(String roman) {
    	try {
			return romanConverterService.getIntNumber(roman);
		} catch (NotRomanNumeralException e) {
			throw errors.on(Rules.RomanNumberRef.class)
            .set(Rules.RomanNumberRef.KEY, roman)
            .raise();
		}
    }
}
