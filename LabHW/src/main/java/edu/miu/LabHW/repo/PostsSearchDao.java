package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostsSearchDao {

    private final EntityManager em;

    public List<Post> findPostsByCriteria(Post post) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);

        List<Predicate> predicates = new ArrayList<>();
        if (post.getTitle() != null)
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + post.getTitle() + "%"));

        if (post.getContent() != null)
            predicates.add(criteriaBuilder.like(root.get("content"), "%" + post.getContent() + "%"));

        if (post.getAuthor() != null)
            predicates.add(criteriaBuilder.like(root.get("author"), "%" + post.getAuthor() + "%"));

        criteriaQuery.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return em.createQuery(criteriaQuery).getResultList();
    }

}
