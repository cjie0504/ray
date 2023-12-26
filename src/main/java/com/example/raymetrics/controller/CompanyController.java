package com.example.raymetrics.controller;

import com.example.raymetrics.model.NewsResDTO;
import com.example.raymetrics.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final NewsService newsService;

    @RequestMapping(value= "/company", method = RequestMethod.GET)
    public String company() {
        return "/company/main";
    }

    @RequestMapping(value= "/corportaion", method = RequestMethod.GET)
    public String corporation() {
        return "/company/main";
    }

    @RequestMapping(value= "/managementPhilosophy", method = RequestMethod.GET)
    public String managementPhilosophy() {
        return "/company/philosophy";
    }

    @RequestMapping(value= "/history", method = RequestMethod.GET)
    public String history() {
        return "/company/history";
    }
    @RequestMapping(value= "/organization", method = RequestMethod.GET)
    public String organization() {
        return "/company/organization";
    }

    /**
     * 뉴스조회하기
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value= "/news", method = RequestMethod.GET)
    public String news(@RequestParam Map<String,Object> param, Model model) {

        Page<NewsResDTO> newsList = newsService.getList(param);


        int pageBlock = 10;
        int page = newsList.getNumber()+1;

        // 현재 페이지 블록
        int currentBlock = (int) Math.ceil((double) page / pageBlock);

        // 페이지 블록 시작 페이지
        int startPage = (currentBlock - 1) * pageBlock + 1;

        // 페이지 블록 끝 페이지
        int endPage = Math.min(startPage + pageBlock - 1, newsList.getTotalPages());
        endPage = Math.max(endPage, 1);

        model.addAttribute("NEWS_LIST", newsList);
        model.addAttribute("START_PAGE", startPage);
        model.addAttribute("END_PAGE", endPage);


        return "/company/news";
    }

    /**
     * 상세페이지
     * @param newsNo
     * @param model
     * @return
     */
    @RequestMapping(value= "/news/detail/{newsNo}", method = RequestMethod.GET)
    public String inquiry(@PathVariable("newsNo") int newsNo, Model model, @RequestParam Map<String,Object> param) {

        NewsResDTO news = newsService.getOne(newsNo);
        model.addAttribute("NEWS",news);

         return "/company/newsDetail";
    }

}
