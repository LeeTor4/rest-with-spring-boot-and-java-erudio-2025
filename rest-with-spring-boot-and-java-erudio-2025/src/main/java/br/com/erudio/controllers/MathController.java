package br.com.erudio.controllers;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

     private SimpleMath math = new SimpleMath();

     //http://localhost:8080/math/sum/5/3
     @RequestMapping(value ="/sum/{numberOne}/{numberTwo}")
     public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
     ) throws Exception
     {
          if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.sum(NumberConverter.covertToDouble(numberOne) , NumberConverter.covertToDouble(numberTwo));
     }

     // http://localhost:8080/math/multiplication/5/3
     @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")
     public Double multiplication(
             @PathVariable("numberOne") String numberOne,
             @PathVariable("numberTwo") String numberTwo
     ) throws Exception
     {
          if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.multiplication( NumberConverter.covertToDouble(numberOne) , NumberConverter.covertToDouble(numberTwo));
     }

     // http://localhost:8080/math/subtraction/5/3
     @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}" )
     public Double subtraction(
             @PathVariable("numberOne") String numberOne,
             @PathVariable("numberTwo") String numberTwo
     ) throws Exception
     {
          if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.subtraction(NumberConverter.covertToDouble(numberOne) , NumberConverter.covertToDouble(numberTwo));
     }

     // http://localhost:8080/math/division/5/3
     @RequestMapping(value = "/division/{numberOne}/{numberTwo}")
     public Double division(
             @PathVariable("numberOne") String numberOne,
             @PathVariable("numberTwo") String numberTwo
     ) throws Exception
     {
          if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.division(NumberConverter.covertToDouble(numberOne),NumberConverter.covertToDouble(numberTwo));
     }

     // http://localhost:8080/math/mean/5/3
     @RequestMapping(value = "/mean/{numberOne}/{numberTwo}")
     public Double mean(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo
     ) throws Exception
     {
          if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.mean(NumberConverter.covertToDouble(numberOne) , NumberConverter.covertToDouble(numberTwo));
     }

     // http://localhost:8080/math/squareroot/5/
     @RequestMapping(value = "/squareroot/{number}")
     public Double squareRoot(@PathVariable("number") String number) throws Exception {
          if (!NumberConverter.isNumeric(number)) {
               throw new UnsuportedMathOperationException("Please set a numeric value!");
          }
          return math.squareRoot(Math.sqrt(NumberConverter.covertToDouble(number)));
     }
}
