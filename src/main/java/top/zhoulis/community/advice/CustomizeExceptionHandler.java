package top.zhoulis.community.advice;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import top.zhoulis.community.exception.CustomizeException;

@ControllerAdvice
public class CustomizeExceptionHandler{

        @ExceptionHandler(Exception.class)
        ModelAndView handle(Throwable ex,Model model) {
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", "服务冒烟了，稍后再试！！！");
            }
            return new ModelAndView("error");
        }
}
