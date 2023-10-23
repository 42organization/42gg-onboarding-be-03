package jpabook.jpashop;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {
  @GetMapping("/mapping/post/{postId}")
  public String findPost(@PathVariable String postId) {
    return "get postId=" + postId;
  }

  @PostMapping("mapping/post")
  public String addPost() {
    return "add post";
  }

  @DeleteMapping("mapping/post/{postId}")
  public String deletePost(@PathVariable String postId) {
    return "delete postId=" + postId;
  }

  @PutMapping("mapping/post/{postId}")
  public String updatePost(@PathVariable String postId) {
    return "update postId=" + postId;
  }

}
