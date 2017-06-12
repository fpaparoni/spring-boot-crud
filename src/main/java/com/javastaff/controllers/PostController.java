package com.javastaff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastaff.entities.Post;
import com.javastaff.services.PostService;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    /**
     * List all posts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("posts", postService.listPosts());
        System.out.println("Returning posts:");
        return "posts";
    }

    /**
     * View a specific post by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("post/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "postshow";
    }

    @RequestMapping("post/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "postform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("post/new")
    public String newProduct(Model model) {
        model.addAttribute("post", new Post());
        return "postform";
    }

    /**
     * Save post to database.
     *
     * @param post
     * @return
     */
    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String saveProduct(Post post) {
    	postService.savePost(post);
        return "redirect:/post/" + post.getId();
    }

    /**
     * Delete post by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("post/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	postService.deletePost(id);
        return "redirect:/posts";
    }

}
