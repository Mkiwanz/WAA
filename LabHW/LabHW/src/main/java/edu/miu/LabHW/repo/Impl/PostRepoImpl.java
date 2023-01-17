package edu.miu.LabHW.repo.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static final List<Post> posts;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(111, "New post 1", "about Anything 1", "kiwan");
        Post p2 = new Post(222, "New post 2", "about Anything 2", "omar");
        Post p3 = new Post(333, "New post 3", "about Anything 3", "kiwan");
        Post p4 = new Post(444, "New post 4", "about Anything 4", "omar");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
    }
    @Override
    public List<Post> findPost() {
        return posts;
    }

    @Override
    public Post findPostById(int id) {
        return posts.stream().filter(x -> x.getId() == id).findFirst().orElse(new Post());
    }

    @Override
    public void deleteById(int id) {
        var post = posts.stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void updateById(int id, Post post) {
        Post toUpdate = findPostById(id);
        toUpdate.setAuthor(post.getAuthor());
        toUpdate.setTitle(post.getTitle());
        toUpdate.setContent(post.getContent());
    }

}
