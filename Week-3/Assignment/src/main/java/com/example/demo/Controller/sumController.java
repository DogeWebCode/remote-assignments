package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class sumController {
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String numberSum(@RequestParam(value = "num", required = true, defaultValue = "") String num) {
        //The center bracket is used to define the character class, \d is for 0~9, * is for 0 or more numbers.
        boolean isInteger = num.matches("^[\\d]*$");
        if (num.isEmpty()) {
            return "Lack of Parameter";
        } else if (!isInteger) {
            return "Wrong Parameter";
        } else {
            try {
                // Use the 'long' type to extend the numeric range and minimize the occurrence of overflow.
                long number = Long.parseLong(num);
                // (1 + 2 + 3 +...+ N) = N * (N + 1) / 2
                // look at it in terms of nanometer time, it is around 200ns.
                long total = number * (number + 1) / 2;

                /* With nano time, each additional digit increases the time by a factor of 10.
                for (int i = 0; i <= number; i++) {
                    total1 += i;
                }
                */
                return (String.valueOf(total));
            } catch (NumberFormatException e) {
                return "Too Large Number";
            }
        }
    }
}

