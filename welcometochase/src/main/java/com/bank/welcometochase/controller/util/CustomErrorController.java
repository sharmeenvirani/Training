package com.bank.welcometochase.controller.util;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController extends RuntimeException implements ErrorController {

   @Override
   public String getErrorPath() {
      return "/error";
   }

   @RequestMapping("/error")
   public String handleError(HttpServletRequest request) {
      Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

      if (status != null) {
         Integer statusCode = Integer.valueOf(status.toString());

         try {
            if (statusCode == HttpStatus.NOT_FOUND.value()) {

               //TODO - add logging statement and remove print line
               System.out.println(" 404 Exception occurred");
               return "error-pages/404page";

            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {

               //TODO - add logging statement and remove print line
               System.out.println("403 Exception occurred");
               return "error-pages/403page";
            }
         } catch (Exception e){

            //TODO - add logging statement and remove print line
            System.out.println("Exception occurred");
         }
      }
      return "error-pages/error";
   }

}

