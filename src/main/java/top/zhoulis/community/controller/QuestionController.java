package top.zhoulis.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zhoulis.community.dto.QuestionDTO;
import top.zhoulis.community.mapper.QuestionMapper;
import top.zhoulis.community.service.QuestionService;

@Controller
public class QuestionController {

    /**
     * 使用question ID查询是否存在
     */
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
