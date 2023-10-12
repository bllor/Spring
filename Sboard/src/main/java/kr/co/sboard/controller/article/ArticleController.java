package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @GetMapping("/article/list")
    public String list(Model model){
        List<ArticleEntity> entities = articleService.selectArticles();

        List<ArticleDTO> lists = new ArrayList<>();
        for(ArticleEntity entity : entities){
            ArticleDTO list = entity.toDTO();
            log.info("list : "+list);
            lists.add(list);
       }
        log.info("lists : "+lists);

        return"/article/list";
    }

    @GetMapping("/article/register")
    public String register(){
        return "/article/register";
    }

    @PostMapping("/article/register")
    public String register(ArticleDTO dto, HttpServletRequest request){
        dto.setRegip(request.getRemoteAddr());
        articleService.save(dto);
        return "redirect:/article/list";
    }

}
