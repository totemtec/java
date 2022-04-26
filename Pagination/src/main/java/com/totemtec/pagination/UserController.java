package com.totemtec.pagination;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private static final int DEFAULT_CURRENT = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    @GetMapping(value = {"/user/list"})
    public String getUserList(@RequestParam Optional<Integer> page,
                             @RequestParam Optional<Integer> size,
                             Model model) {

        // 请求参数处理
        int currentPage = page.orElse(DEFAULT_CURRENT);
        int pageSize = size.orElse(DEFAULT_PAGE_SIZE);
        // 这里当前页码需要减去1，因为Pageable翻页从0开始
        Pageable pageable = PageRequest.of(currentPage-DEFAULT_CURRENT, pageSize, Sort.by("id").descending());



        // 返回数据，这里是样例，随便做了点数据
        List<User> userList = new ArrayList<>();
        for (int i = 10 * (currentPage-1); i < 10 * currentPage; i++) {
            User user = new User();
            user.setId(new Long(i));
            user.setName("User " + i);
            userList.add(user);
        }

        // 返回的分页数据，此处总条数需要按照自己的数据量来设置
        Page pageList = new PageImpl<>(userList, pageable, 200);
        model.addAttribute("pageList", pageList);

        return "user/list";
    }

    @GetMapping(value = {"/pagination"})
    public String pagination(@RequestParam Optional<Integer> page,
                             @RequestParam Optional<Integer> size,
                             Model model) {

        // 请求参数处理
        int currentPage = page.orElse(DEFAULT_CURRENT);
        int pageSize = size.orElse(DEFAULT_PAGE_SIZE);
        // 这里当前页码需要减去1，因为Pageable翻页从0开始
        Pageable pageable = PageRequest.of(currentPage-DEFAULT_CURRENT, pageSize, Sort.by("id").descending());



        // 返回数据，这里是样例，随便做了点数据
        List<User> userList = new ArrayList<>();
        for (int i = 10 * (currentPage-1); i < 10 * currentPage; i++) {
            User user = new User();
            user.setId(new Long(i));
            user.setName("User " + i);
            userList.add(user);
        }

        // 返回的分页数据，此处总条数需要按照自己的数据量来设置
        Page pageList = new PageImpl<>(userList, pageable, 200);
        model.addAttribute("pageList", pageList);

        return "fragment/page";
    }
}
